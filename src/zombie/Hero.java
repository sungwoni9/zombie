package zombie;

public class Hero extends Unit {

	int shield;

	public Hero(int pos, int hp, int maxPower, int shield) {
		super(pos, hp, maxPower, shield);
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	@Override
	void attack(Unit zombie) {
		String enemy = zombie instanceof Boss ? "좀비킹" : "좀비";

		int power = maxPower;
		int damage = power;

		if (zombie instanceof Boss && shield > 0) {
			damage -= shield;
			if (damage < 0) {
				damage = 0;
			}
		}


		zombie.setHp(zombie.getHp() - damage);
		System.out.printf("영웅이 %d의 공격력으로 %s를 공격 : 현재 %s의 hp : %d\n", damage, enemy, enemy, zombie.getHp());
	}

	public void recovery() {
		int healAmount = 100;
		this.setHp(this.getHp() + healAmount);
		System.out.printf("영웅이 %d만큼 체력을 회복했습니다. 현재 hp: %d\n", healAmount, this.getHp());
	}

	void rechargeEnergy() {
		int rechargeAmount = 20;
		this.setHp(this.getHp() + rechargeAmount);
		System.out.printf("영웅이 기력을 회복하여 %d의 체력이 증가했습니다. 현재 hp: %d\n", rechargeAmount, this.getHp());
	}

	void bloodHeal(Unit zombie) {
		if (random.nextInt(3) == 1) {
			int power = random.nextInt(maxPower);
			int healAmount = power / 3;
			this.setHp(this.getHp() + healAmount);
			System.out.printf("영웅이 피의 회복으로 체력을 %d만큼 회복했습니다. 현재 hp: %d\n", healAmount, this.getHp());
		}
	}
}
