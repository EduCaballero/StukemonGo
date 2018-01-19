package pokemon;

import javafx.fxml.FXMLLoader;
import pokemon.handlers.MainHandler;

import java.io.IOException;

public class Navigator {

	public static final String MAIN = view("main");
	public static final String MENU = view("menu");
	public static final String CREATE_PLAYER = view("create-player");
	public static final String PICK_POKEMON = view("pick-pokemon");
	public static final String GAME = view("game");
	public static final String BATTLE = view("battle");

	private static MainHandler mainHandler;

	public static void setMainHandler(MainHandler mainHandler) {
		Navigator.mainHandler = mainHandler;
	}

	public static void loadVista(String fxml) {
		try {
			mainHandler.setVista(FXMLLoader.load(Navigator.class.getResource(fxml)));
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static String view(String view) {
		return "resources/views/" + view + ".fxml";
	}

}
