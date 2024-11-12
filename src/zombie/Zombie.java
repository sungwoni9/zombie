package zombie;

import java.util.Random;

public class Zombie extends Unit {

	private int power;

	public Zombie(int pos, int hp, int maxPower, int shield) {
		super(pos, hp, maxPower, shield);
		random = new Random();
	}

	public void attack(Unit hero) {
		power = random.nextInt(getmaxPower());
		hero.setHp(hero.getHp() - power);

		if (hero.getHp() <= 0) {
			hero.setHp(0);
		}
	}

	public void enhancedAttack(Unit hero) {
		if (random.nextInt(4) == 0) {
			int enhancedDamage = (int) (power * 1.5);
			hero.setHp(hero.getHp() - enhancedDamage);
			System.out.println("좀비가 강화 공격! " + enhancedDamage + "의 데미지를 입혔습니다.");

			if (hero.getHp() <= 0) {
				hero.setHp(0);
			}
		} else {
			attack(hero);
		}
	}

	public void frighten(Unit hero) {
		if (random.nextInt(5) == 0) {
			hero.setMaxPower(Unit.getmaxPower() - 2);
			if (Unit.getmaxPower() < 0) {
				hero.setMaxPower(0);
			}
			System.out.println("좀비가 공포를 유발하여 적의 공격력을 2만큼 감소시켰습니다!");
		}
	}

	public void bloodHeal(Unit unit) {
		if (random.nextInt(3) == 1) {
			int healAmount = power / 3;
			this.setHp(this.getHp() + healAmount);
			System.out.println("좀비가 피의 회복으로 체력을 " + healAmount + "만큼 회복했습니다.");
		}

	}
}
