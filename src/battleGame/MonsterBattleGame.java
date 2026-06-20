package battleGame;

import java.util.Scanner;

public class MonsterBattleGame {

	static Player p = new Player();
	static Monster m = new Monster();
	static Scanner scanner = new Scanner(System.in);
	static int choice;

	public static void main(String[] args) {

		System.out.println("=== モンスターとのバトルゲーム ===");

		while (p.getHp() > 0 && m.getHp() > 0) {
			playerTurn();
			System.out.println();
			if (m.getHp() <= 0) {
				System.out.println("勇者の勝利");
				break;
			}
			monsterTurn();
			if (p.getHp() <= 0) {
				System.out.println("勇者はやられてしまった");
				break;
			}
		}
	}

	public static void playerTurn() {
		System.out.println(
				p.getName() + "のHP； " + p.getHp()+", "+  m.getName() + "のHP：" + m.getHp() +", "+ m.getName() +"の攻撃確率： " + m.getAttackChance() + "%");
		while (true) {
			System.out.print("攻撃するか防御するかを選んでください（１：攻撃，２：防御)");
			try {
				choice = scanner.nextInt();
				if (choice == 1) {
					p.attack(m);
					p.notDefend();
					break;
				}
				else if (choice == 2) {
					System.out.println(p.getName() + "は防御を選択した！");
					p.defend();
					break;
				}
			} catch (Exception e) {
				System.out.println("１か２を入力してください");
				scanner.nextLine();
			}
		}
	}

	public static void monsterTurn() {

		//勇者が攻撃した場合
		System.out.println
		(m.getName() + "のHP： " + m.getHp() + ", " + m.getName() + "の攻撃！");
		m.attack(p);
	}
}