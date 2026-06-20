package battleGame;

import java.util.Random;

public class Monster extends Character {

	Random random = new Random();

	public Monster() {
		super("ドラゴン", 100, 40);
	}

	private int attackChance = 60;
	private int upAttackChance = 20;

	public int getAttackChance() {
		return attackChance;
	}

	public void setAttackChance(int attackChance) {
		this.attackChance = attackChance;
	}

	public int getUpAttackChance() {
		return upAttackChance;
	}

	@Override
	public void attack(Character target) {
		int chance = random.nextInt(100) + 1;

		if (target.isDefending() == true || chance > attackChance) {
			System.out.println("攻撃がミス！");
			if (getUpAttackChance() != 0) {
				attackChance = Math.min(100, attackChance + upAttackChance);
				System.out.println("ドラゴンの攻撃成功率が" + getUpAttackChance() + "%上昇！");
			}
		} else {
			target.takeDamage(getAttackPower());
			setAttackChance(60);
			System.out.println("攻撃が成功！");
			System.out.println(target.getName() + "に" + getAttackPower() + "のダメージ！");
		}
	}
}