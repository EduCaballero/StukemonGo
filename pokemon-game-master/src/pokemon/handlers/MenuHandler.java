package pokemon.handlers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import pokemon.Game;
import pokemon.Navigator;
import pokemon.models.Player;
import pokemon.repositories.DAO;
import pokemon.repositories.mysql.PlayersRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MenuHandler implements Initializable {

	protected List<Player> players;

	protected DAO<Player> playersRepository;

	@FXML
	protected ListView<Player> playersListView;

	public MenuHandler() {
		this.playersRepository = new PlayersRepository();
		try {
			this.players = playersRepository.find();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playersListView.setItems(FXCollections.observableArrayList(this.players));

		playersListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				Game.getInstance().player = newValue;
				if (newValue.hasPokemon())
					Navigator.loadVista(Navigator.GAME);
				else
					Navigator.loadVista(Navigator.PICK_POKEMON);
			}
		});
	}

	@FXML
	protected void createPlayer(ActionEvent actionEvent) {
		Navigator.loadVista(Navigator.CREATE_PLAYER);
	}

	@FXML
	protected void exit(ActionEvent actionEvent) {
		Platform.exit();
		System.exit(0);
	}
}
