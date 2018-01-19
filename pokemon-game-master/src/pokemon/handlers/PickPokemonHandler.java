package pokemon.handlers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import pokemon.Game;
import pokemon.Navigator;
import pokemon.models.Player;
import pokemon.models.Pokemon;
import pokemon.repositories.DAO;
import pokemon.repositories.mysql.PokemonsRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class PickPokemonHandler implements Initializable {

	DAO<Pokemon> initialPokemonsRepository;
	Player player;

	@FXML
	protected Label messageLabel;
	@FXML
	protected ListView<Pokemon> pokemonsListView;

	public PickPokemonHandler() {
		this.player = Game.getInstance().player;
		this.initialPokemonsRepository = new PokemonsRepository();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		messageLabel.setText(Game.getInstance().player.getName() + ", elige tu pokemon:");

		try {
			pokemonsListView.setItems(FXCollections.observableArrayList(initialPokemonsRepository.find()));
			pokemonsListView.setCellFactory(list -> new PokemonListCell());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		pokemonsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				try {
					this.player.assignPokemon(newValue);
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}

				try {
					this.player.save();
					Game.getInstance().player = this.player;
					Navigator.loadVista(Navigator.GAME);
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		});
	}

	@FXML
	protected void back(ActionEvent actionEvent) {
		Navigator.loadVista(Navigator.MENU);
	}

}

class PokemonListCell extends ListCell<Pokemon> {

	private HBox hBox = new HBox();
	private ImageView image = new ImageView();
	private Label name = new Label();

	public PokemonListCell() {
		setupHBox();
		setupImage();
		setupName();
		addElementsToVBox();
	}

	private void setupHBox() {
		hBox.getStyleClass().add("h-box");
		hBox.setAlignment(Pos.CENTER_LEFT);
	}

	private void setupImage() {
		//
	}

	private void setupName() {
		//
	}

	private void addElementsToVBox() {
		hBox.getChildren().addAll(image, name);
	}

	@Override
	public void updateItem(Pokemon pokemon, boolean empty) {
		super.updateItem(pokemon, empty);
		if (empty) {
			clearContent();
		} else {
			addContent(pokemon);
		}
	}

	private void clearContent() {
		setText(null);
		setGraphic(null);
	}

	private void addContent(Pokemon pokemon) {
		setText(null);
		image.setImage(new Image(pokemon.getImagePath()));
		image.setFitHeight(42d);
		image.setPreserveRatio(true);

		name.setText(pokemon.toString());
		setGraphic(hBox);
	}

}
