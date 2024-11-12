package zombie;

public class Boss extends Unit {
	int shield;
	int power;
	private boolean isAngry;

	public Boss(int pos, int hp, int maxHp, int shield) {
		super(pos, hp, maxHp, shield);
		this.isAngry = false;
	}

	public void attack(Unit hero) {
		power = random.nextInt(maxPower);
		int damage = power;

		if (isAngry) {
			damage *= 2;
			System.out.println("보스가 화가 나서 공격력이 두 배로 증가했습니다!");
		}

		if (random.nextInt(3) == 1) {
			damage *= 3;
			System.out.println("보스가 회오리 공격을 사용했습니다!");
		}

		hero.setHp(hero.getHp() - damage);
		System.out.printf("보스가 %d의 공격력으로 공격 : 현재 Hero hp : %d\n", damage, hero.getHp());

		if (hero.getHp() <= 50 && !isAngry) {
			isAngry = true;
			System.out.println("보스가 화가 나서 분노상태에 들어갑니다!");
		}
	}

	public void bloodHeal(Zombie Boss) {

	}

	public void surpriseAttack(Unit hero) {
		if (random.nextInt(5) == 0) {
			int surpriseDamage = random.nextInt(50) + 20;
			hero.setHp(hero.getHp() - surpriseDamage);
			System.out.printf("보스가 기습 공격! %d의 피해를 입혔습니다. 현재 Hero hp: %d\n", surpriseDamage, hero.getHp());
		}
	}

	public void releaseDestructionRay(Unit hero) {
		if (random.nextInt(5) == 0) {
			int rayDamage = random.nextInt(100) + 50;
			hero.setHp(hero.getHp() - rayDamage);
			System.out.printf("보스가 파괴의 광선을 발사! %d의 피해를 입혔습니다. 현재 Hero hp: %d\n", rayDamage, hero.getHp());
		}
	}

	void bloodHeal(Unit unit) {
		if (random.nextInt(2) == 1) {
			int healAmount = power / 3;
			this.setHp(this.getHp() + healAmount);
			System.out.printf("보스가 %d만큼 회복되었습니다. 현재 HP: %d\n", healAmount, this.getHp());
		}

	}
}
