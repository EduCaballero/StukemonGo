package pokemon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pokemon.handlers.MainHandler;

public class Main extends Application {

	private static Stage primaryStage;

	@Override
	public void start(Stage stage) throws Exception {
		primaryStage = stage;
		primaryStage.setTitle("Pokemon");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/images/icon.png")));
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("");
		primaryStage.setScene(new Scene(loadMainPane(), 800, 552));
		primaryStage.show();

		primaryStage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	private Pane loadMainPane() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		Pane root = (Pane) loader.load(getClass().getResourceAsStream(Navigator.MAIN));

		MainHandler mainHandler = loader.getController();
		Navigator.setMainHandler(mainHandler);
		Navigator.loadVista(Navigator.MENU);

		return root;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
