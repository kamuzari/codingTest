package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberList {

	static class Node {
		private Map<Character, Node> childs = new HashMap<>();
		private boolean isLast = false;

		public Node() {
		}

		public Map<Character, Node> getChilds() {
			return childs;
		}

		public void activeIsLast() {
			this.isLast = true;
		}
	}

	static class Trie {
		private Node root = new Node();

		public boolean add(String word) {
			Node current = this.root;
			for (char key : word.toCharArray()) {
				if (current.isLast) {
					return false;
				}

				current = current.getChilds().computeIfAbsent(key, (c -> new Node()));
			}
			current.activeIsLast();

			if (current.getChilds().size() >= 1) {
				return false;
			}

			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(reader.readLine());
		StringBuilder answer = new StringBuilder();

		while (testCase-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			Trie trie = new Trie();
			boolean isConsistent = false;
			List<String> phoneNumbers = new ArrayList<>();
			for (int i = 0; i < n; i++) {

				String phoneNumber = reader.readLine();
				phoneNumbers.add(phoneNumber);

				// 중간에 브레이크 하면.. 입력이 이미 주어졌는데.. 그다음 입력이 들어가게 되고 파싱도 정수가 아닌 문자열이 될 수 있고 트라이 자료구조에 없던 개 생기고 이상해짐..
				// 이상해짐..
				// isConsistent = trie.add(phoneNumber);
				// if (!isConsistent) {
				// 	break;
				// }
			}

			for (String phoneNumber : phoneNumbers) {
				isConsistent = trie.add(phoneNumber);
				if(!isConsistent){
					break;
				}
			}

			if (isConsistent) {
				answer.append("YES");
			} else {
				answer.append("NO");
			}

			answer.append("\n");
		}

		System.out.println(answer);
	}
}
/**
 * 또다른 방법은 문자열 정렬
 * 정렬을 하게 되면 최대한 비슷한 문자열끼리 인접해 있고 그 주의 인 -1, +1번째에 prefix가 있는지 비교하면됨
 * 숫자면 1111,9999,11111아렇게 정렬되어 있지만 문자열이면 1111,111111,9999이렇게 정렬되어 있음..
 */
/**
 * 반례 케이스 : 길이가 긴게 먼저오고 짧은 경우 현재 last를 활성화시킨 철자에서 자식이 있으면 현재 word가 접두사임.
 * 4
 * 2
 * 1111111111
 * 1111111112
 * 2
 * 11111111111
 * 1111111111
 * 2
 * 1111111111
 * 1
 * 2
 * 1111111
 * 0111111
 * answer:
 * YES
 * NO
 * NO
 * YES
 */