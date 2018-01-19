package pokemon;

import javafx.scene.control.Alert;

public class Message {

	public static void alert(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.initOwner(Main.getPrimaryStage());
		alert.setTitle("Mensaje");
		alert.setHeaderText("");
		alert.setContentText(message);
		alert.showAndWait();
	}

}
