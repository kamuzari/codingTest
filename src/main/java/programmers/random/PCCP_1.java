package programmers.random;

public class PCCP_1 {
	public int solution(int[] bandage, int health, int[][] attacks) {
		final int MAX_HEALTH = health;
		// tc 6, 9 fail -> 데미지가 주어진 체력보다 강한 경우 붕대를 다시 감을 수 없음에도 불구하고
		// 회복하는 경우는 가능하면 안됌.
		for (int i = 0; i < attacks.length; i++) {
			int damage = attacks[i][1];
			health -= damage;
			boolean isNotLastIndex = i != attacks.length - 1;
			boolean isLeftHealth = health > 0;
			if (isNotLastIndex && isLeftHealth) {
				int interval = attacks[i + 1][0] - attacks[i][0] - 1;
				boolean isLeftTime = interval > 0;
				if (isLeftTime) {
					health = calculate(bandage, health, interval);
					boolean isGraterThanFullHealth = MAX_HEALTH <= health;
					if (isGraterThanFullHealth) {
						health = MAX_HEALTH;
					}
				}
			}

			boolean isDeath = health <= 0;
			if (isDeath) {
				health = -1;
			}

		}

		return health;
	}

	private int calculate(int[] bandage, int health, int interval) {
		int healingPerSeconds = (interval * bandage[1]);
		health += healingPerSeconds;
		int plusHealing = (interval / bandage[0]) * bandage[2];
		health += plusHealing;

		return health;
	}
}
