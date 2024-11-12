package zombie;

import java.util.Random;

abstract public class Unit {
	public int hp;
	public int pos;

	int maxPower;
	public final int MAX_MAP = 15;
	Random random;

	public Unit(int pos, int hp, int maxPower) {
		this.pos = pos;
		this.hp = hp;
		this.maxPower = maxPower;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getPos() {
		return pos;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}

	public int getmaxPower() {
		return maxPower;
	}

	public void move(int pos) {
		if (pos <= MAX_MAP) {
			pos++;
			System.out.println("오른쪽으로 한칸 이동~");
		}
	}

	abstract void attack(Unit unit);

}
