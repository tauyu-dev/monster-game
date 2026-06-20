package newmonstergame;

import java.util.List;

public class TestMonsterDAO {

	public static void main(String[] args) {

		Monster slime = new Monster("スライム", 30, 10);
		Monster draky = new Monster("ドラキー", 50, 10);
		Monster kingSlime = new Monster(2, "キングスライム", 80, 30);

		MonsterDAO dao = new MonsterDAO();

		try {
			dao.insertMonster(slime);
			dao.insertMonster(draky);

			List<Monster> list = dao.findAll();
			for (Monster m : list) {
				System.out.println(m.getId() + " " + m.getName() + " " + m.getHp() + " " + m.getAttack());
			}

			Monster monster = dao.findById(2);
			if (monster != null) {
				System.out.println(
						monster.getId() + " " + monster.getName() + " " + monster.getHp() + " " + monster.getAttack());
			} else {
				System.out.println("モンスターが見つかりません");
			}
			int count = dao.updateMonster(kingSlime);
			System.out.println("id" + kingSlime.getId() + "の" + count + "匹のモンスターを更新しました！");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}