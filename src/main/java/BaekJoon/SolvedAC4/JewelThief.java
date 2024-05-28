package BaekJoon.SolvedAC4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JewelThief {
	static class Bag implements Comparable<Bag> {
		private int limit;

		public Bag(int limit) {
			this.limit = limit;
		}

		@Override
		public int compareTo(Bag o) {
			return limit - o.limit;
		}
	}

	static class Jewely implements Comparable<Jewely> {
		private int weight;
		private int value;

		public Jewely(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Jewely o) {
			if (o.weight == weight) {
				return o.value - value;
			}
			return weight - o.weight;
		}
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(reader.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		PriorityQueue<Jewely> jewelies = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.nextLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewelies.add(new Jewely(weight, value));
		}

		List<Bag> bags = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			bags.add(new Bag(Integer.parseInt(reader.nextLine())));
		}

		Collections.sort(bags);
		long answer = 0L;

		PriorityQueue<Integer> values = new PriorityQueue<>(Collections.reverseOrder());
		for (Bag bag : bags) {
			while (!jewelies.isEmpty()) {
				Jewely top = jewelies.peek();
				if (top.weight <= bag.limit) {
					values.offer(jewelies.poll().value);
				} else {
					break;
				}
			}

			if (values.isEmpty()) {
				continue;
			}

			answer += values.poll();
		}

		System.out.println(answer);
	}

	/**
	 * review:
	 *   1-try: 가방 수용량을 내림차순, 보석 가치 내림차순, 무게 내림차순
	 *     - 많이 들수 있는 가방부터 시작하면 만약 가치가 높은데 무게가 엄청 클 경우, 나머지 가방에는 어차피 안들어가니 미리 제거하자는 생각으로 구현함
	 *     - 그런데 반례가 있음.
	 *     3개의 보석 [ {4,4}, {3,3} ,{5,1}], 가방 = [5,4,3]
	 *     위 로직기반으로 낸 결과는 첫번쨰 가방(5)가 1번쨰를, 두번쨰 가방(4) 2번째, 세번째 가방(3) 아무것도 선택하지 못함 그래서 7이 도출됨
	 *     알맞은 결과는 첫번쨰 가방(5)가 3번쨰를, 두번쨰 가방(4) 1번째, 세번째 가방(3) 2번째 택하며 결과가 8이되어야 함
	 *  -> 그렇기 때문에 가방을 낮은 무게에서부터 선택 내가 수용할 수 있는 보석을 모두 담는 중간 통에 넣고 그중 가장 가치가 높은 것을 선별
	 *    이렇게 하면 무게가 낮은 가방부터 높은 가방 까지 순회하며 보석을 모두 담는 중간통은 언제든지 가능한 후보들로만 꾸려진다. 결국 n^2이 아닌 n 으로서의 시간복잡도를 가지므로 해결이됨.
	 */
}
