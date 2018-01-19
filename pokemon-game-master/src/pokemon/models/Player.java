package pokemon.models;

import pokemon.repositories.DAO;
import pokemon.repositories.mysql.PlayersRepository;

public class Player implements Persistable {

	private long id = 0L;
	private String name = null;
	private String pokemon = null;
	private String type = null;
	private int level = 1;
	private int exp = 0;
	private int hunger = 0;
	private int maxHp = 0;
	private int hp = 0;
	private int damage = 0;
	private String move1 = null;
	private int power1 = 0;
	private String move2 = null;
	private int power2 = 0;
	private String move3 = null;
	private int power3 = 0;

	public Player() {
	}

	public Player(String name) {
		setName(name);
	}

	public boolean hasPokemon() {
		return getPokemon() != null;
	}

	public void assignPokemon(final Pokemon pokemon) throws Exception {
		if (getPokemon() == null) {
			setPokemon(pokemon.getName());
			setType(pokemon.getType());
			setMaxHp(pokemon.getHp());
			setHp(pokemon.getHp());
			setDamage(pokemon.getDamage());
			setMove1(pokemon.getMove1());
			setPower1(pokemon.getPower1());
			setMove2(pokemon.getMove2());
			setPower2(pokemon.getPower2());
			setMove3(pokemon.getMove3());
			setPower3(pokemon.getPower3());
		} else
			throw new Exception(getName() + " ya tiene pokemon.");
	}

	@Override
	public void save() throws Exception {
		DAO<Player> playersRepository = new PlayersRepository();
		if (getId() > 0L)
			playersRepository.update(this);
		else
			setId(playersRepository.create(this));
	}

	@Override
	public void delete() throws Exception {
		DAO<Player> playersRepository = new PlayersRepository();
		if (getId() > 0L)
			playersRepository.delete(this);
	}

	@Override
	public String toString() {
		if (getPokemon() != null)
			return getName() + " (" + getPokemon() + " lv." + getLevel() + ")";
		return getName();
	}

	public String getPokemonImagePath() {
		return "/pokemon/resources/images/pokemons/" + getPokemon().toLowerCase() + ".gif";
	}

	public boolean isDead() {
		return this.hp <= 0 && this.hunger >= 100;
	}

	public boolean canFight() {
		return this.hp > 0 && this.hunger < 100;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPokemon() {
		return pokemon;
	}

	public void setPokemon(final String pokemon) {
		this.pokemon = pokemon;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(final int level) {
		if (level > 99) this.level = 99;
		else if (level < 1) this.level = 1;
		else this.level = level;
	}

	public boolean levelUp(final int points) {
		boolean result = false;
		int levels = (points - (points % 100)) / 100;
		if (levels > 0) {
			this.level += levels;
			this.exp += points % 100;
			result = true;
		} else
			this.exp += points;

		if (this.exp > 100) {
			levels = (this.exp - (this.exp % 100)) / 100;
			this.level += levels;
			this.exp = this.exp % 100;
			result = true;
		}
		if (this.level > 99) this.level = 99;
		return result;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(final int exp) {
		if (exp > 100) this.exp = 100;
		else if (exp < 0) this.exp = 0;
		else this.exp = exp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(final int hp) {
		if (hp > this.maxHp) this.hp = this.maxHp;
		else if (hp < 0) this.hp = 0;
		else this.hp = hp;
	}

	public void hpDown(final int points) {
		this.hp -= points;
		if (this.hp < 0) this.hp = 0;
	}

	public void hpUp(final int points) {
		this.hp += points;
		if (this.hp > this.maxHp) this.hp = this.maxHp;
	}

	public void restoreHp() {
		this.hp = this.maxHp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(final int maxHp) {
		if (maxHp > 999) this.maxHp = 999;
		else if (maxHp < 0) this.maxHp = 0;
		else this.maxHp = maxHp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(final int damage) {
		if (damage > 999) this.damage = 999;
		else if (damage < 0) this.damage = 0;
		else this.damage = damage;
	}

	public void damageUp(final int points) {
		this.damage += points;
		if (this.damage > 100) this.damage = 100;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(final int hunger) {
		if (hunger > 100) this.hunger = 100;
		else if (hunger < 0) this.hunger = 0;
		else this.hunger = hunger;
	}

	public void hungerUp(final int points) {
		this.hunger += points;
		if (this.hunger > 100) this.hunger = 100;
	}

	public void hungerDown(final int points) {
		this.hunger -= points;
		if (this.hunger < 0) this.hunger = 0;
	}

	public void restoreHunger() {
		this.hunger = 0;
	}

	public String getMove1() {
		return move1;
	}

	public void setMove1(final String move1) {
		this.move1 = move1;
	}

	public int getPower1() {
		return power1;
	}

	public void setPower1(final int power1) {
		this.power1 = power1;
	}

	public String getMove2() {
		return move2;
	}

	public void setMove2(final String move2) {
		this.move2 = move2;
	}

	public int getPower2() {
		return power2;
	}

	public void setPower2(final int power2) {
		this.power2 = power2;
	}

	public String getMove3() {
		return move3;
	}

	public void setMove3(final String move3) {
		this.move3 = move3;
	}

	public int getPower3() {
		return power3;
	}

	public void setPower3(final int power3) {
		this.power3 = power3;
	}

}
