package principales;

public class Fight {
	
	int idFight;
	int pokemon1;
	int pokemon2;
	int winner;
	
	//CONSTRUCTOR
	public Fight(int idFight, int pokemon1, int pokemon2, int winner) {
		this.idFight = idFight;
		this.pokemon1 = pokemon1;
		this.pokemon2 = pokemon2;
		this.winner = winner;
	}

	//GETTERS & SETTERS
	//idFight
	public int getIdFight() {
		return idFight;
	}

	public void setIdFight(int idFight) {
		this.idFight = idFight;
	}

	//pokemon1
	public int getPokemon1() {
		return pokemon1;
	}

	public void setPokemon1(int pokemon1) {
		this.pokemon1 = pokemon1;
	}

	//pokemon2
	public int getPokemon2() {
		return pokemon2;
	}

	public void setPokemon2(int pokemon2) {
		this.pokemon2 = pokemon2;
	}

	//winner
	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}
	
	
	
	
	
}
