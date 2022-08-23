package kakaointern2022;

import java.util.LinkedList;

public class SameSummaryQueue {
    /*
    how : 1.두 개의 큐의 원소의 합이 같으려면 어떻게 해야할까?
    idea:
     1. 작은쪽 합계를 가진 큐에 채워 넣어 준다?

    how 위에 나온 방안에서 최소 횟수를 구하려면 어떻게 해야할까?
    idea : x
    */

	private static final int IMPOSSIBLE = -1;

	public int solution(int[] queue1, int[] queue2) {
		int count = 0;
		LinkedList<Integer> q1 = new LinkedList<>();
		LinkedList<Integer> q2 = new LinkedList<>();

		move(q1, queue1);
		move(q2, queue2);

		long sumA = getSum(q1);
		long sumB = getSum(q2);
		int possibleChance = (q1.size() + q2.size()) * 2;

		while (sumA != sumB) {
			count++;

			if (sumA > sumB) {
				int popVal = q1.poll();
				sumA -= popVal;
				sumB += popVal;
				q2.offer(popVal);
			} else {
				int popVal = q2.poll();
				sumA += popVal;
				sumB -= popVal;
				q1.offer(popVal);
			}

			if (count > possibleChance) {
				return IMPOSSIBLE;
			}

		}

		return count;
	}

	public void move(LinkedList<Integer> dest, int[] src) {
		for (int val : src) {
			dest.offer(val);
		}
	}

	// note: 각 원소의 값이 10^8이고 큐에 길이가 3십만이니 합계를 구할 때 유의해야 함.
	public long getSum(LinkedList<Integer> q) {
		return q.stream().reduce(Integer::sum)
			.orElseGet(() -> 0);
	}
}
