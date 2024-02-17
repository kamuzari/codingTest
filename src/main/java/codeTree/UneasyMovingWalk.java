package codeTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class UneasyMovingWalk {
	static int n, k;
	static int[] state;
	// 무빙워크가 2개 있는데 어느쪽을 타는지는 어떻게 알 수 있지? - 밑칸은 안쓰는 것 같다
	static int auto = 1;

	static class Person implements Comparable<Person> {
		int id, pos;

		public Person(int pos) {
			this.id = auto++;
			this.pos = pos;
		}

		public Person(int id, int dummy) {
			this.id = id;
		}

		public void updatePos(int val) {
			this.pos = val;
		}

		public boolean equals(Object ob) {
			Person o = (Person)ob;
			return id == o.id;
		}

		public int hashCode() {
			return Objects.hash(id);
		}

		public int compareTo(Person p) {
			return p.pos - pos;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		n = toInt(input[0]);
		k = toInt(input[1]);
		input = sc.nextLine().split(" ");
		state = new int[n * 2];
		for (int i = 0; i < n * 2; i++) {
			state[i] = toInt(input[i]);
		}

		/**
		 1. 무빙 워크 회전
		 2. 무빙워크에 사람이 타고 있는 사람을 -> 한칸 이동(앞에 사람이 있거나 혹은 안전성이 0인경우 제자리)
		 3. 1번칸에 사람이 없고 안전성이 0이 아니라면 과정 종료
		 */

		LinkedList<Integer> mvs = new LinkedList<>();
		IntStream.range(0, n * 2).forEach(mvs::add);
		TreeSet<Person> persons = new TreeSet<>();

		int cycle = 0;
		while (true) {
			// 무빙워크 회전
			mvs.addFirst(mvs.pollLast());
			int first = mvs.peek();
			// System.out.println("맨 앞칸"+first);
			// 무빙워크 활성화 된 목록
			Set<Integer> actives = new HashSet<>();
			for (int i = 0; i < n - 1; i++) {
				actives.add(mvs.get(i));
			}

			// System.out.println("활성화 된 무빙워크: "+actives);
			// 자동으로 내린 사람 선별

			// System.out.println("탑승 하고 있는 사람");
			// for(Person p : persons){
			//     System.out.println(p.id +", "+ p.pos);
			//  }

			// 사람 다음으로 이동시키기 -> 1,2,3, 연속적으로 사람있을 때 3번 부터 체크해야함 그래야 모두가 2,3,4로 진행가능함.
			// 다음으로 이동시키는 데 안전성 0인것 체크
			for (Person p : persons) {
				int next = (p.pos + 1) % n;
				if (state[next] != 0 && isExistPerson(persons, next)) {
					p.updatePos(next);
					state[next]--;
				}
			}

			boolean isBoarding = state[first] != 0 && isExistPerson(persons, first);
			if (isBoarding) {
				state[first]--;
				persons.add(new Person(first));
			}
			// System.out.println("state 상태"+Arrays.toString(state)+"\n");
			int zero = (int)Arrays.stream(state).filter(val -> val == 0).count();
			boolean isExit = zero >= k;
			if (isExit) {
				break;
			}

			cycle++;
		}

		System.out.println(cycle == 0 ? 1 : cycle);
	}

	static boolean isExistPerson(Set<Person> persons, int pos) {
		for (Person p : persons) {
			if (pos == p.pos) {
				return false;
			}
		}

		return true;
	}

	static boolean isExit(int zeroCount) {
		return zeroCount >= k;
	}

	static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
