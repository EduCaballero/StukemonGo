package principales;

import java.sql.Date;

public class Pokedex {
	
	//ATRIBUTOS
	int idPokedex;
	String user;
	String pokemon;
	Date date;
	int pc;
	int lifemax;
	int lifeCurrent;
	
	
	//CONSTRUCTOR
	public Pokedex(int idPokedex, String user, String pokemon, Date date, int pc, int lifemax, int lifeCurrent) {
		this.idPokedex = idPokedex;
		this.user = user;
		this.pokemon = pokemon;
		this.date = date;
		this.pc = pc;
		this.lifemax = lifemax;
		this.lifeCurrent = lifeCurrent;
	}

	//GETTERS & SETTERS
	//pokedex
	public int getIdPokedex() {
		return idPokedex;
	}

	public void setIdPokedex(int idPokedex) {
		this.idPokedex = idPokedex;
	}

	//user
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//pokemon
	public String getPokemon() {
		return pokemon;
	}

	public void setPokemon(String pokemon) {
		this.pokemon = pokemon;
	}

	//date
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	//pc
	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	//lifemax
	public int getLifemax() {
		return lifemax;
	}

	public void setLifemax(int lifemax) {
		this.lifemax = lifemax;
	}

	//lifeCurrent
	public int getLifeCurrent() {
		return lifeCurrent;
	}

	public void setLifeCurrent(int lifeCurrent) {
		this.lifeCurrent = lifeCurrent;
	}	

}
