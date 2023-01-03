package programmers.lv2;

import java.util.LinkedList;
import java.util.Stack;

public class CourierBox {
	public static void main(String[] args) {
		CourierBox courierBox = new CourierBox();
		int i = courierBox.solution_refactor(new int[] {4, 3, 1, 2, 5});
		System.out.println(i);
	}

	public int solution(int[] order) {
		int answer = 0;
		int n = order.length;
		Stack<Integer> containers = new Stack<>();

		int cur = 1;
		int i = 0;
		while (true) {
			if (!containers.isEmpty() && containers.peek() == order[i]) {
				containers.pop();
				answer++;
				i++;
				continue;
			}

			if (i >= n || cur > n) {
				break;
			}

			if (cur == order[i]) {
				cur++;
				i++;
				answer++;
				continue;
			}

			containers.push(cur);
			cur++;

		}

		return answer;
	}

	public int solution_refactor(int[] order) {

		int n = order.length;
		LinkedList<Integer> orders = new LinkedList<>();
		Stack<Integer> containers = new Stack<>();
		int cnt = 0;

		for (int index = 0; index < n; index++) {
			containers.push(index+1);

			while (!containers.isEmpty()) {
				if (containers.peek() == order[cnt]) {
					orders.add(containers.pop());
					cnt++;
				} else {
					break;
				}
			}
		}

		return orders.size();
	}
}
