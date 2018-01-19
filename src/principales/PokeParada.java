package principales;

public class PokeParada {
	
	//ATRIBUTOS
	String name;
	String place;
	int pokeballs;
	int potions;
	
	//CONSTRUCTORES
	public PokeParada(String name, String place, int pokeballs, int potions) {
		this.name = name;
		this.place = place;
		this.pokeballs = pokeballs;
		this.potions = potions;
	}
	
	//GETTERS Y SETTERS
	//name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//place
	public String getPlace() {
		return place;
	}

	/*public void setPlace(String place) { //NO se puede modificar una pokeparada de lugar
		this.place = place;
	}*/

	//pokeballs
	public int getPokeballs() {
		return pokeballs;
	}

	public void setPokeballs(int pokeballs) {
		this.pokeballs = pokeballs;
	}

	//potions
	public int getPotions() {
		return potions;
	}

	public void setPotions(int potions) {
		this.potions = potions;
	}
	
	//FUNCIONES
	
	//otorgar premios (pokeballs y potions)

}
