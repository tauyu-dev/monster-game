package newmonstergame;

import java.util.List;
import java.util.Scanner;

public class MonsterController {

	private Scanner scanner = new Scanner(System.in);
	private MonsterDAO dao = new MonsterDAO();

	public void start() {
		boolean keep = true;

		while (keep) {
			showMenu();

			System.out.println("選択してください：");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:

				registerMonster();
				break;
			case 2:
				showAllMonsters();
				break;
			case 3:

				searchMonsterById();
				break;
			case 4:
				updateMonster();
				break;
			case 5:
				deleteMonster();
				break;
			case 0:

				keep = false;
				break;
			default:
				System.out.println("不正な入力です");

			}
		}
	}

	private void showMenu() {
		System.out.println("=== モンスター図鑑  ===");
		System.out.println();
		System.out.println("1.モンスター登録");
		System.out.println("2.モンスター一覧");
		System.out.println("3.ID検索");
		System.out.println("4.更新");
		System.out.println("5.削除");
		System.out.println("0.終了");
	}

	//１．モンスター登録
	private void registerMonster() {
		System.out.println("=== 登録機能 ===");
		try {
			System.out.print("名前：");
			String name = scanner.next();

			System.out.print("HP：");
			int hp = scanner.nextInt();

			System.out.print("攻撃力：");
			int attack = scanner.nextInt();

			Monster monster = new Monster(name, hp, attack);

			int numberOfRows = dao.insertMonster(monster);
			if (numberOfRows == 1) {
				System.out.println("登録完了！");
			} else {
				System.out.println("登録失敗");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//２．モンスター一覧
	private void showAllMonsters() {

		System.out.println("=== 一覧表示機能 ===");
		try {
			List<Monster> monsters = dao.findAll();

			for (Monster m : monsters) {
				System.out.println(m.getId() + " " + m.getName() + " " + m.getHp() + " " + m.getAttack());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//3.ID検索
	private void searchMonsterById() {
		System.out.println("=== ID検索機能 ===");
		try {
			System.out.print("IDを入力してください：");
			int id = scanner.nextInt();
			Monster monster = dao.findById(id);
			if (monster != null) {
				System.out.println(
						monster.getId() + " " + monster.getName() + " " + monster.getHp() + " " + monster.getAttack());
			} else {
				System.out.println("モンスターが見つかりません");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//４．更新
	private void updateMonster() {
		System.out.println("=== 更新機能 ===");
		try {
			System.out.print("ID：");
			int id = scanner.nextInt();

			System.out.print("名前：");
			String name = scanner.next();

			System.out.print("HP：");
			int hp = scanner.nextInt();

			System.out.print("攻撃力：");
			int attack = scanner.nextInt();

			Monster monster = new Monster(id, name, hp, attack);

			int numberOfRows = dao.updateMonster(monster);
			if (numberOfRows == 1) {
				System.out.println("更新完了！");
			} else {
				System.out.println("更新できませんでした");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//５．削除
	private void deleteMonster() {
		System.out.println("=== 削除機能 ===");
		System.out.print("削除するID:");
		try {
			int id = scanner.nextInt();
			int numberOfRows = dao.deleteMonster(id);
			if (numberOfRows == 1) {
				System.out.println(numberOfRows + "件削除しました！");
			} else {
				System.out.println("モンスターが見つかりません");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
