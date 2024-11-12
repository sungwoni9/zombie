package zombie;

import java.util.Random;

abstract public class Unit {
	public static int hp;
	public int pos;
	static int maxPower;
	private int shield;
	Random random = new Random();

	public Unit(int pos, int hp, int maxPower, int shield) {
		this.pos = pos;
		Unit.hp = hp;
		Unit.maxPower = maxPower;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getPos() {
		return pos;
	}

	public void setHp(int hp) {
		Unit.hp = hp;
	}

	public int getHp() {
		return hp;
	}

	public static int getmaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		Unit.maxPower = maxPower;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	abstract void attack(Unit unit);

	abstract void bloodHeal(Unit unit);

}
