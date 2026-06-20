package battleGame;

public abstract class Character implements CharacterActions {

	private String name;
	private int hp;
	private int attackPower;
	private boolean defending;

	protected Character(String name, int hp, int attackPower) {
		this.name = name;
		this.hp = hp;
		this.attackPower = attackPower;
	}

	public abstract void attack(Character target);

	public void defend() {
		defending = true;
	}
	public void notDefend() {
		defending = false;
	}
	
	public boolean isAlive() {
		return hp > 0;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public boolean isDefending() {
		return defending;
	}

	public void takeDamage(int damage) {
		hp -= damage;
	}
}