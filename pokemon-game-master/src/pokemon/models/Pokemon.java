package pokemon.models;

import java.util.Random;

public class Pokemon {

	private long id = 0L;
	private String name = null;
	private String type = null;
	private int level = 1;
	private int hp = 0;
	private int damage = 0;
	private String move1 = null;
	private int power1 = 0;
	private String move2 = null;
	private int power2 = 0;
	private String move3 = null;
	private int power3 = 0;

	public Pokemon() {
		Random random = new Random(System.nanoTime());
		this.level = random.nextInt(99) + 1;
	}

	@Override
	public String toString() {
		return getName() + ", " + getType() + " (" + getHp() + " hp " + getDamage() + " daño)";
	}

	public String getImagePath() {
		return "/pokemon/resources/images/pokemons/" + getName().toLowerCase() + ".gif";
	}

	public boolean canFight() {
		return this.hp > 0;
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

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(final int hp) {
		if (hp > 999) this.hp = 999;
		else if (hp < 0) this.hp = 0;
		else this.hp = hp;
	}

	public void hpDown(final int points) {
		this.hp -= points;
		if (this.hp < 0) this.hp = 0;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(final int damage) {
		this.damage = damage;
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
