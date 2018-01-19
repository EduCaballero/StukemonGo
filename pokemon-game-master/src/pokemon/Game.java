package pokemon;

import pokemon.models.Player;

public class Game {

	public static Player player;

	private static Game instance = new Game();

	public static Game getInstance() {
		return instance;
	}

	private Game() {
	}

}
