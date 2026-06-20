package stonegame;

import java.util.Random;
import java.util.Scanner;

public class StoneGame {

	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();

	static int stone = 15;
	static int enemy;
	static boolean again = true;

	public static void main(String[] args) {

		while (again) {
			stone = 15;
			System.out.println("=== 石取りゲーム ===");
			System.out.println("石の数：15");
			System.out.println("1ターンに1～３個の石を取ることができます");
			System.out.println("最後の石を取った方が負けです");

			while (stone > 0) {

				playerTurn();
				if (stone <= 0) {
					break;
				}
				computerTurn();
				if (stone <= 0) {
					break;
				}
			}
			while (true) {
				System.out.println("このままゲームを続けますか？");
				System.out.println("yesかnoを入力してください");

				//入力がyes,no以外の場合
				String cont = scanner.next();
				if (cont.equals("yes")) {
					break;
				}
				if (cont.equals("no")) {
					again = false;
					System.out.println("ゲームを終了します");
					break;
				}
				System.out.println("正しい文字を入力してください");
			}
		}
	}

	public static void playerTurn() {

		int input = 0;
		while (input < 1 || input > 3 || input > stone) {
			try {
				System.out.print("取る石の数(１～３)を入力してください：");
				input = scanner.nextInt();

				//数字以外が入力された場合の例外処理を行いたい。適切な数字が入力されるまで
				//入力要求したいからwhile文使う？

				if (input < 1 || input > 3 || input > stone) {
					System.out.println("再度入力してください");
					continue;
				}
			} catch (Exception e) {
				System.out.println("数字を入力してください");
				scanner.next();
			}
		}
		System.out.println("あなたは " + input + "個の石を取りました。残りの石：" + (stone - input));
		stone = stone - input;
		if (stone <= 0) {
			System.out.println("あなたの負けです！");
		}
	}

	public static void computerTurn() {
		enemy = random.nextInt(Math.min(3, stone)) + 1;
		System.out.println("コンピュータは" + enemy + "個の石を取りました。残りの石：" + (stone - enemy));
		stone = stone - enemy;
		if (stone <= 0) {
			System.out.println("あなたの勝ちです！");
		}

	}

}
