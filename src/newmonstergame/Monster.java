package newmonstergame;

public class Monster {

	private int id;
	private String name;
	private int hp;
	private int attack;
	
	public Monster() {

	}

	public Monster(int id, String name, int hp, int attack) {
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.attack = attack;
	}
	public Monster(String name, int hp, int attack) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getAttack() {
		return attack;
	}

}
