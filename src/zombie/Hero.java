package zombie;

public class Hero extends Unit {

	int shield;
	int power;

	public Hero(int pos, int hp, int power, int shield) {
		super(pos, hp, power, shield);
	}

	public int setShield(int shield) {
		return this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	void attack(Unit zombie) {
		String enemy = "";

		if (zombie instanceof Boss) {
			enemy = "좀비킹";
		} else {
			enemy = "좀비";
		}

		int power = random.nextInt(maxPower);
		int damage = power;

		if (zombie instanceof Boss && shield > 0) {
			damage -= shield;
			if (damage < 0) {
				damage = 0;
			}
		}

		if (random.nextInt(3) == 1) {
			damage *= 2;
			System.out.println("회전 회오리!!!");
		}

		zombie.setHp(zombie.getHp() - damage);

		System.out.printf("영웅이 %d의 공격력으로 공격 :  영웅 hp : %d\n", damage, enemy, zombie.getHp());
	}

	public void bloodHeal() {
		if (random.nextInt(3) == 1)
			this.setHp(this.getHp() + power / 3);
	}

	public void heal() {
		
	}

	void bloodHeal(Unit unit) {
		if (random.nextInt(3) == 1)
		    this.setHp(this.getHp() + 100);
		}

}
