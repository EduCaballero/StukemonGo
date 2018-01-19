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
import pokemon.models.Pokemon;
import pokemon.repositories.mysql.PokemonsRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class BattleHandler implements Initializable {

	protected Player player;
	protected Pokemon enemy;

	protected PokemonsRepository pokemonsRepository;

	@FXML
	protected ImageView enemyImageImageView, imageImageView;
	@FXML
	protected Label enemyNameLabel, enemyLevelLabel, enemyHpLabel, nameLabel, levelLabel, hpLabel;
	@FXML
	protected Button attack1Button, attack2Button, attack3Button;

	private boolean isPlayerTurn = true;

	public BattleHandler() {
		this.pokemonsRepository = new PokemonsRepository();
		this.player = Game.getInstance().player;
		try {
			this.enemy = pokemonsRepository.findRandom();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setupEnemy();
		setupPlayer();
	}

	@FXML
	protected void attack1(ActionEvent actionEvent) {
		int damage = ((this.player.getDamage() / 2) + (this.player.getPower1() / 2)) / 2;
		attack(damage);
	}

	@FXML
	protected void attack2(ActionEvent actionEvent) {
		int damage = ((this.player.getDamage() / 2) + (this.player.getPower2() / 2)) / 2;
		attack(damage);
	}

	@FXML
	protected void attack3(ActionEvent actionEvent) {
		int damage = ((this.player.getDamage() / 2) + (this.player.getPower3() / 2)) / 2;
		attack(damage);
	}

	private void attack(int damage) {
		if (this.isPlayerTurn && this.player.getHp() > 0) {
			attackToEnemyWith(damage);
			this.isPlayerTurn = false;
			if (this.enemy.canFight()) {
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					public void run() {
						Platform.runLater(() -> generateRandomAttack());
					}
				}, 1000);
			} else {
				won();
			}
		}
	}

	private void won() {
		Message.alert("Has ganado.");
		if (this.player.levelUp(this.enemy.getLevel() * 5))
			Message.alert("Has subido de nivel.");
		abort();
	}

	private void loose() {
		Message.alert("Has perdido.");
		abort();
	}

	private void generateRandomAttack() {
		Random random = new Random(System.nanoTime());
		int attackNumber = random.nextInt(3) + 1;
		try {
			attackToPlayerWith(attackNumber);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		this.isPlayerTurn = true;
	}

	private void attackToPlayerWith(int attackNumber) throws Exception {
		int attackDamage = 0;
		String attackName = null;
		switch (attackNumber) {
			case 1:
				attackDamage = ((this.enemy.getDamage() / 2) + (this.enemy.getPower1() / 2)) / 2;
				attackName = this.enemy.getMove1();
				break;
			case 2:
				attackDamage = ((this.enemy.getDamage() / 2) + (this.enemy.getPower2() / 2)) / 2;
				attackName = this.enemy.getMove2();
				break;
			case 3:
				attackDamage = ((this.enemy.getDamage() / 2) + (this.enemy.getPower3() / 2)) / 2;
				attackName = this.enemy.getMove3();
				break;
			default:
				throw new Exception("Unknow attack.");
		}
		this.player.hpDown(attackDamage);
		setupPlayerHpLabel();
		Message.alert(this.enemy.getName() + " te ha atacado con " + attackName + ", " + attackDamage + " de daño.");
		if (this.player.getHp() <= 0) {
			Message.alert("Has perdido.");
			abort();
		}
	}

	private void attackToEnemyWith(int damage) {
		this.enemy.hpDown(damage);
		setupEnemyHplabel();
	}

	@FXML
	protected void abort() {
		try {
			this.player.save();
			Game.getInstance().player = this.player;
			Navigator.loadVista(Navigator.GAME);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void setupEnemy() {
		enemyImageImageView.setImage(new Image(this.enemy.getImagePath()));
		enemyNameLabel.setText(this.enemy.getName());
		enemyLevelLabel.setText("Nivel: " + this.enemy.getLevel());
		setupEnemyHplabel();
	}

	private void setupPlayer() {
		imageImageView.setImage(new Image(this.player.getPokemonImagePath()));
		nameLabel.setText(this.player.getPokemon());
		levelLabel.setText("Nivel: " + this.player.getLevel());
		setupPlayerHpLabel();
		attack1Button.setText(this.player.getMove1() + " (" + this.player.getPower1() + " daño)");
		attack2Button.setText(this.player.getMove2() + " (" + this.player.getPower2() + " daño)");
		attack3Button.setText(this.player.getMove3() + " (" + this.player.getPower3() + " daño)");
	}

	private void setupPlayerHpLabel() {
		hpLabel.setText("HP: " + this.player.getHp());
	}

	private void setupEnemyHplabel() {
		enemyHpLabel.setText("HP: " + this.enemy.getHp());
	}
}
