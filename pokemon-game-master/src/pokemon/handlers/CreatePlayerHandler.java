package pokemon.handlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pokemon.Game;
import pokemon.Message;
import pokemon.Navigator;
import pokemon.models.Player;

public class CreatePlayerHandler {

	@FXML
	protected TextField nameTextField;

	@FXML
	protected void storePlayer(ActionEvent actionEvent) {
		String name = nameTextField.getText().trim();
		if (name.isEmpty()) {
			return;
		} else if (name.length() > 30) {
			Message.alert("Nombre muy largo");
		} else {
			Player player = new Player(name);
			try {
				player.save();
				Game.getInstance().player = player;
				Navigator.loadVista(Navigator.PICK_POKEMON);
			} catch (Exception ex) {
				Message.alert("Nombre en uso.");
			}
		}
	}

	@FXML
	protected void back(ActionEvent actionEvent) {
		Navigator.loadVista(Navigator.MENU);
	}
}
