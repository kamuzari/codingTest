package BaekJoon.tony.binarysearch;

import java.util.Scanner;
import java.util.StringTokenizer;

public class DragonDungeon {

	private static int roomCount;
	private static int initPower;
	private static long[][] commands;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		roomCount = Integer.parseInt(st.nextToken());
		initPower = Integer.parseInt(st.nextToken());
		commands = new long[roomCount][3];

		for (int i = 0; i < roomCount; i++) {
			st = new StringTokenizer(sc.nextLine());
			commands[i][0] = Long.parseLong(st.nextToken());
			commands[i][1] = Long.parseLong(st.nextToken());
			commands[i][2] = Long.parseLong(st.nextToken());
		}

		long s = 0L;
		long e = Long.MAX_VALUE;
		long answer = Long.MAX_VALUE;
		while (s <= e) {
			long promiseHP = (s + e) >> 1;
			if (isPossible(promiseHP)) {
				answer = Math.min(answer, promiseHP);
				e = promiseHP - 1;
			} else {
				s = promiseHP + 1;
			}
		}

		System.out.println(answer);
	}

	static class Knight {
		long maxHP;
		long hp;
		long power;

		public Knight(long hp, long power) {
			this.maxHP = hp;
			this.hp = hp;
			this.power = power;
		}

		public void hitByMonster(long power) {
			this.hp -= power;
		}

		public void powerUp(long power) {
			this.power += power;
		}

		public void heal(long heal) {
			this.hp += heal;

			if (maxHP < this.hp) {
				this.hp = maxHP;
			}

		}

		public boolean isDie() {
			return this.hp <= 0L;
		}
	}

	private static boolean isPossible(long promiseHP) {
		Knight knight = new Knight(promiseHP, initPower);
		for (int i = 0; i < roomCount; i++) {
			long command = commands[i][0];
			if (command == 1) {
				long monsterPower = commands[i][1];
				long monsterHp = commands[i][2];
				long hitCountByKnight = monsterHp / knight.power;

				long rest = monsterHp % knight.power;
				if (rest != 0) {
					hitCountByKnight++;
				}

				long damage = (hitCountByKnight - 1) * monsterPower;
				knight.hitByMonster(damage);

				if (knight.isDie()) {
					return false;
				}
			} else if (command == 2) {
				long powerUp = commands[i][1];
				long chargingHp = commands[i][2];
				knight.powerUp(powerUp);
				knight.heal(chargingHp);
			}
		}

		return !knight.isDie();
	}
}
