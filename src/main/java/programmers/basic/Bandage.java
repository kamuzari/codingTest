package programmers.basic;

public class Bandage {
	public int solution(int[] bandage, int health, int[][] attacks) {
		final int MAX_HEALTH = health;

		for (int i = 0; i < attacks.length; i++) {
			int damage = attacks[i][1];
			health -= damage;

			if (i != attacks.length - 1 && health > 0) {
				int interval = attacks[i + 1][0] - attacks[i][0] - 1;
				boolean isLeftTime = interval > 0;
				if (isLeftTime) {
					int healingPerSeconds = (interval * bandage[1]);
					health += healingPerSeconds;
					int plusHealing = (interval / bandage[0]) * bandage[2];
					health += plusHealing;
					if (MAX_HEALTH <= health) {
						health = MAX_HEALTH;
					}
				}
			}

			if (health <= 0) {
				health = -1;
			}

		}

		return health;
	}
}
