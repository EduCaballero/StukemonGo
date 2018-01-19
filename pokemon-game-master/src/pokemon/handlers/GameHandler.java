package pokemon.handlers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pokemon.Game;
import pokemon.Message;
import pokemon.Navigator;
import pokemon.models.Player;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class GameHandler implements Initializable {

	protected Player player;
	protected Timer statsTimer, sleepTimer;

	@FXML
	protected ImageView imageImageView;
	@FXML
	protected Label playerLabel, pokemonLabel, levelLabel, expLabel, hpLabel, hungerLabel;
	@FXML
	protected Button btn1, btn2, btn3, btn4, btn5;

	private final int hungerPerMinute = 5, hpPerMinute = 10;
	private final long loopTime = (long) 60 * 1000;
	private final long sleepTime = (long) 5 * 1000;
	private final String labelDangerClassName = "label--danger";

	public GameHandler() {
		this.player = Game.getInstance().player;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setupStats();
		startStatsTimer();
	}

	private void startStatsTimer() {
		this.statsTimer = new Timer();
		this.statsTimer.schedule(new TimerTask() {
			public void run() {
				Platform.runLater(() -> updatestats());
			}
		}, loopTime, loopTime);
	}

	private void updatestats() {
		if (this.player.isDead()) {
			gameOver();
		} else {
			updateHungerInLoop();
			updateHpInLoop();
		}
	}

	private void updateHungerInLoop() {
		this.player.hungerUp(this.hungerPerMinute);
		setupHungerLabel();
	}

	private void updateHpInLoop() {
		this.player.hpDown(this.hpPerMinute);
		setupHpLabel();
	}

	private void gameOver() {
		this.statsTimer.cancel();
		try {
			this.player.delete();
			Game.getInstance().player = null;
			this.statsTimer.purge();
			Message.alert("Game over.");
			Navigator.loadVista(Navigator.MENU);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			startStatsTimer();
		}
	}

	@FXML
	protected void onBattle(ActionEvent actionEvent) {
		if (this.player.getHp() > 0) {
			this.statsTimer.cancel();
			try {
				this.player.save();
				Game.getInstance().player = this.player;
				this.statsTimer.purge();
				Navigator.loadVista(Navigator.BATTLE);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		} else {
			Message.alert("Haz descansar tu pokemon antes de continuar.");
		}

	}

	@FXML
	protected void onSleep(ActionEvent actionEvent) {
		disableButtons(true);
		this.statsTimer.cancel();
		this.sleepTimer = new Timer();
		this.sleepTimer.schedule(new TimerTask() {
			public void run() {
				Platform.runLater(() -> wakeUp());
			}
		}, sleepTime);
	}

	private void wakeUp() {
		this.player.restoreHp();
		setupHpLabel();
		disableButtons(false);
		startStatsTimer();
	}

	private void disableButtons(boolean state) {
		btn1.setDisable(state);
		btn2.setDisable(state);
		btn3.setDisable(state);
		btn4.setDisable(state);
		btn5.setDisable(state);
	}

	@FXML
	protected void onExit(ActionEvent actionEvent) {
		this.statsTimer.cancel();
		try {
			this.player.save();
			Game.getInstance().player = this.player;
			this.statsTimer.purge();
			Navigator.loadVista(Navigator.MENU);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	@FXML
	protected void onFastFood(ActionEvent actionEvent) {
		this.player.hungerDown(30);
		this.player.damageUp(5);
		setupHungerLabel();
	}

	@FXML
	protected void onHealthyFood(ActionEvent actionEvent) {
		this.player.hungerDown(20);
		this.player.hpUp(10);
		setupHungerLabel();
		setupHpLabel();
	}

	@FXML
	protected void onSnack(ActionEvent actionEvent) {
		this.player.hungerDown(10);
		this.player.hpUp(5);
		setupHungerLabel();
		setupHpLabel();
	}

	private void setupHungerLabel() {
		hungerLabel.setText("Hambre: " + this.player.getHunger() + "/100");
		if (this.player.getHunger() >= 100 - hpPerMinute - 1)
			hungerLabel.getStyleClass().addAll(labelDangerClassName);
		else
			hungerLabel.getStyleClass().removeAll(labelDangerClassName);
	}

	private void setupHpLabel() {
		hpLabel.setText("HP: " + this.player.getHp() + "/" + this.player.getMaxHp());
		if (this.player.getHp() <= 0 + hpPerMinute + 1)
			hpLabel.getStyleClass().addAll(labelDangerClassName);
		else
			hpLabel.getStyleClass().removeAll(labelDangerClassName);
	}

	private void setupStats() {
		playerLabel.setText(this.player.getName());
		imageImageView.setImage(new Image(this.player.getPokemonImagePath()));
		pokemonLabel.setText(this.player.getPokemon());
		levelLabel.setText("Nivel: " + this.player.getLevel() + "/99");
		expLabel.setText("XP: " + this.player.getExp() + "/100");
		setupHungerLabel();
		setupHpLabel();
	}

}
