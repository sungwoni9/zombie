package zombie;

import java.util.Random;
import java.util.Scanner;

public class GameSetting {
	int currentPos = 1;
	private final int MAP_SIZE = 20;
	private Unit[] map;

	private Scanner scanner;
	private Random random;

	private Hero hero;
	private Zombie[] zombies;
	private Boss boss;

	public GameSetting() {
		map = new Unit[MAP_SIZE];
		random = new Random();
		scanner = new Scanner(System.in);
		hero = new Hero(currentPos, 200, 200, 5);
		zombies = new Zombie[3];
		boss = new Boss(10, 300, 300, 50);
	}

	public void run() {
		printBoard();
		setMap();
		while (!gameOver()) {
			gamePlay();
		}
	}

	public void printBoard() {
		System.out.println("==== Zombie Game ====");
		System.out.println("캐릭터 설명:");
		System.out.println("🧟 : 좀비");
		System.out.println("🐲 : 보스");
		System.out.println("🏃 : 히어로");
	}

	public void gamePlay() {
		System.out.println("현재 위치 = " + hero.getPos());
		System.out.println("앞으로 이동하기(1), 종료하기(2): ");
		System.out.println("====================");
		int move = scanner.nextInt();

		if (move == 1) {
			hero.setPos(hero.getPos() + 1);
		} else if (move == 2) {
			System.out.println("게임을 종료합니다.");
			return;
		}
		if (map[hero.getPos()] != null) {
			Unit enemy = map[hero.getPos()];

			System.out.println("보스좀비를 만났습니다. 전투를 시작합니다!");
			if (enemy instanceof Zombie) {
				Zombie boss = (Zombie) enemy;

				while (true) {
					System.out.print("공격하기(1), 포션 마시기(2): ");
					int action = scanner.nextInt();

					if (action == 1) {
						boss.attack(hero);
						hero.attack(boss);
					} else if (action == 2) {
						hero.recovery();
					}

					if (hero.getHp() <= 0) {
						System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.");
						break;
					}

					if (boss.getHp() <= 0) {
						System.out.println("보스를 처치했습니다!");
						break;
					}
				}

			} else {
				System.out.println("좀비를 만났습니다. 전투를 시작합니다!");

				while (true) {
					System.out.print("공격하기(1), 포션 마시기(2): ");
					int action = scanner.nextInt();

					if (action == 1) {
						hero.attack(enemy);
						enemy.attack(hero);
					} else if (action == 2) {

						hero.recovery();
					}

					if (hero.getHp() <= 0) {
						System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.");
						break;
					}

					if (enemy.getHp() <= 0) {
						System.out.println("좀비를 처치했습니다.");
						break;
					}
				}
			}
		}
	}

	public void setMap() {
		setZombie();
	}

	public void setZombie() {
		int zombiesPlaced = 0;
		int bossPlaced = 0;

		while (zombiesPlaced < 3) {
			int position = random.nextInt(MAP_SIZE);
			if (map[position] == null) {
				zombies[zombiesPlaced] = new Zombie(position, 100, 10, 0);
				map[position] = zombies[zombiesPlaced];
				zombiesPlaced++;
			}
		}

		while (bossPlaced < 1) {
			int position = random.nextInt(MAP_SIZE);
			if (map[position] == null) {
				map[position] = boss;
				bossPlaced++;
			}
		}
	}

	public void backMoveAndCreateZombie() {
		if (random.nextInt(100) == 0) {
			int newPos = hero.getPos() - 1;
			hero.setPos(newPos);

			int zombiePos = newPos;
			map[zombiePos] = new Zombie(zombiePos, 100, 10, 0);

			System.out.println("늪에 빠져 돌아갑니다. 그 자리에 좀비가 생성되었습니다!");
		}
	}

	public boolean gameOver() {
		if (hero.getHp() <= 0) {
			System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.");
			return true;
		} else if (hero.getPos() > MAP_SIZE) {
			System.out.println("맵 끝에 도달했습니다. 게임에서 이겼습니다.");
			return true;
		}
		return false;
	}

	public Unit[] getMap() {
		return map;
	}
}
