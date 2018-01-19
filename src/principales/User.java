package principales;

public class User {
	
	//Propiedades
	private String userName;
	private String password;
	private int pokeballs;
	private int potions;
	private int level;
	private String place;
	private int pokeCoins;
	private int points;
	
	//CONSTRUCTORES
	//TODO dar valores por defecto necesarios
	public User(String userName, String password, int pokeballs, int potions, int level, String place, int pokeCoins, int points) {
		this.userName=userName;
		this.password=password;
		this.pokeballs=pokeballs;
		this.potions=potions;
		this.level=level;
		this.place=place;
		this.pokeCoins=pokeCoins;
		this.potions=potions;
	}
		
	
	//GETTERS y SETTERS////////////////////
	//userName
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
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
	
	//level
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	//place
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	//pokeCoins
	public int getPokeCoins() {
		return pokeCoins;
	}
	public void setPokeCoins(int pokeCoins) {
		this.pokeCoins = pokeCoins;
	}
	
	//points
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	///////////////////////////////////////////////

}
