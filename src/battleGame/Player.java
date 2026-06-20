package battleGame;

public class Player extends Character {

	public Player() {
		//コンストラクタでname,hp,attackPowerを定義
		super("勇者", 100, 40);
	}

	@Override
	public void attack(Character target) {
		target.takeDamage(getAttackPower());
		System.out.println("勇者の攻撃");
		System.out.println(target.getName() + "に" + getAttackPower() + "のダメージ!");		
	}

}
