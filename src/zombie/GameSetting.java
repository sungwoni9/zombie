package zombie;

import java.util.Random;
import java.util.Scanner;

public class GameSetting {
	int currentPos = 0;
	private final int MAP_SIZE = 20;
	private Unit[] map;

	private Scanner scanner;
	private Random random;

	private Hero hero;
	private Boss boss;

	public GameSetting() {
		map = new Unit[MAP_SIZE];
		random = new Random();
		scanner = new Scanner(System.in);
		hero = new Hero(currentPos, 500, 50, 5);
		boss = new Boss(10, 10, 10, 10);
	}

	public void run() {
		setMap();
		printMap();
		while (!gameOver()) {
			gamePlay();
		}
	}

	public void printMap() {
		System.out.println("==== 맵 상태 ====");
		for (int i = 0; i < MAP_SIZE; i++) {
			if (map[i] != null) {
				if (map[i] instanceof Hero) {
					System.out.print("🏃 ");
				} else if (map[i] instanceof Boss) {
					System.out.print("🐲 ");
				} else if (map[i] instanceof Zombie) {
					System.out.print("🧟 ");
				}
			} else {
				System.out.print("⬜ ");
			}
		}
		System.out.println();
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
			System.out.println("전투 시작!");

			if (enemy instanceof Boss) {
				Boss boss = (Boss) enemy;

				while (true) {
					System.out.print("공격하기(1), 포션 마시기(2): ");
					int action = scanner.nextInt();

					if (action == 1) {
						hero.attack(boss);
						boss.attack(hero);
					} else if (action == 2) {
						hero.recovery();
					}

					if (hero.getHp() <= 0) {
						System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.");
						return;
					}

					if (boss.getHp() <= 0) {
						System.out.println("보스를 처치했습니다!");
						map[hero.getPos()] = null;
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
						return;
					}

					if (enemy.getHp() <= 0) {
						System.out.println("좀비를 처치했습니다.");
						map[hero.getPos()] = null;
						break;
					}
				}
			}
		}
	}

	public void setMap() {
		map[hero.getPos()] = hero;
		setZombie();
	}

	public void setZombie() {
		int zombiesPlaced = 0;
		int bossPlaced = 0;

		while (zombiesPlaced < 3) {
			int position = random.nextInt(MAP_SIZE);
			if (map[position] == null) {
				map[position] = new Zombie(position, 10, 10, 0); 
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
			map[zombiePos] = new Boss(zombiePos, 100, 10, 0);

			System.out.println("늪에 빠져 돌아갑니다. 그 자리에 좀비가 생성되었습니다!");
		}
	}

	public boolean gameOver() {
		if (hero.getHp() <= 0) {
			System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.");
			return true;
		} else if (hero.getPos() >= MAP_SIZE) {
			System.out.println("맵 끝에 도달했습니다. 게임에서 이겼습니다.");
			return true;
		}
		return false;
	}

	public Unit[] getMap() {
		return map;
	}
}
