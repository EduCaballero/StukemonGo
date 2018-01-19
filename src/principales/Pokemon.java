package principales;

public class Pokemon {
	
	//ATRIBUTOS
	String name;
	String type;
	int pc;//puntos de combate
	int life;
	String place;
	
	//CONSTRUCTORES
	public Pokemon(String name, String type, int pc, int life, String place) {
		this.name = name;
		this.type = type;
		this.pc = pc;
		this.life = life;
		this.place = place;
	}

	//GETTERS Y SETTERS
	//name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//type
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//pc
	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	//life
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	//place
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	//FUNCIONES
	
	//desplazarse por stucom

}
