package pokemon.handlers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class MainHandler {

	@FXML
	protected StackPane app;

	public void setVista(Node node) {
		app.getChildren().setAll(node);
	}

}
