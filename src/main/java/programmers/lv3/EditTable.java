package programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class EditTable {
	public static void main(String[] args) {
		EditTable editTable = new EditTable();
		System.out.println(Arrays.toString(editTable.solution(new String[] {
			"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice",
			"UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta",
			"UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik",
			"UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"
		})));

		System.out.println(Arrays.toString(editTable.solution(new String[] {
			"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1",
			"MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"
		})));
	}

	/**
	 merget r1 c1 r2 c2의
	 - 두개의 칸 중 셀값을 갖고 있으면 그 값을 가짐
	 - 두개 모두 값을 가지고 있으면 (r1,c1) 의 값을 가짐. - 앞의 출열한 칸의 값으로 통일
	 - r1.c1  와 r2 c2 중 어느 위치를 선택하여도 병합된 셀로 접근함.
	 - 입출력1 : merge (1,2)-"menu" , (1,3)-"null" -> [(1,2),(1,3)] - "menu"
	 merge (1,3) - "menu", (1,4)-"null" -> [(1,2),(1,3),(1,4)] - "menu"
	 unmerge (1,4) - (1,2)-"null", (1,3)-"null", (1,4)-"menu" := 병합 모두 해제됨과 통시 unmerge에 출연한 값만
	 - core:자료구조 및 모델링를 잘 사용해야 하는 문제인듯
	 */

	class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public boolean equals(Object o) {
			if (this == o)
				return true;

			if (o == null || this.getClass() != o.getClass()) {
				return false;
			}

			Node other = (Node)o;

			return this.y == other.y && this.x == other.x;
		}

		public int hashCode() {
			return Objects.hash(this.y, this.x);
		}
	}

	public String[] solution(String[] commands) {
		List<String> answer = new ArrayList<>();
		String[][] map = new String[51][51]; // 값 저장
		Map<Node, List<Node>> status = new LinkedHashMap<>(); //병합 정보
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], "");
			for (int j = 0; j < map[0].length; j++) {
				status.put(new Node(i, j), new ArrayList<>());
			}

		}

		for (String cmd : commands) {
			String str[] = cmd.split(" ");

			switch (str[0]) {
				case "UPDATE":
					if (str.length == 4) {
						// UPDATE ${r} ${c} ${value}
						int r = Integer.parseInt(str[1]);
						int c = Integer.parseInt(str[2]);
						map[r][c] = str[3];
						for (Node node : status.get(new Node(r, c))) {
							map[node.y][node.x] = map[r][c];
						}

					} else {
						// UPDATE ${before} ${after}
						String before = str[1];
						String after = str[2];
						for (int i = 0; i < map.length; i++) {
							for (int j = 0; j < map[0].length; j++) {
								if (map[i][j].equals(before)) {
									map[i][j] = after;
								}
							}
						}
					}
					break;
				case "MERGE":
					int r1 = Integer.parseInt(str[1]);
					int c1 = Integer.parseInt(str[2]);
					int r2 = Integer.parseInt(str[3]);
					int c2 = Integer.parseInt(str[4]);

					String val1 = map[r1][c1];
					String val2 = map[r2][c2];
					String val = "";
					if (!val1.isEmpty() && !val2.isEmpty()) {
						val = map[r2][c2] = map[r1][c1];
					} else if (val1.isEmpty() && !val2.isEmpty()) {
						val = map[r1][c1] = map[r2][c2];
					} else if (!val1.isEmpty() && val2.isEmpty()) {
						val = map[r2][c2] = map[r1][c1];
					} else {
						// System.out.println("둘다 읎네?");
					}

					Set<Node> relations = new HashSet<>();

					List<Node> nodes1 = status.get(new Node(r1, c1));
					for (Node prev : nodes1) {
						relations.add(new Node(prev.y, prev.x));
					}

					List<Node> nodes = status.get(new Node(r2, c2));
					for (Node prev : nodes) {
						relations.add(new Node(prev.y, prev.x));
					}

					relations.add(new Node(r1, c1));
					relations.add(new Node(r2, c2));

					for (Node node : relations) {
						status.put(node, relations.stream().collect(Collectors.toList()));
						map[node.y][node.x] = val;
					}

					break;
				case "UNMERGE":
					int r = Integer.parseInt(str[1]);
					int c = Integer.parseInt(str[2]);

					String value = map[r][c];
					for (Node node : status.get(new Node(r, c))) {
						status.put(node, new ArrayList<>());
						map[node.y][node.x] = "";
					}

					map[r][c] = value;

					break;
				case "PRINT":
					int y = Integer.parseInt(str[1]);
					int x = Integer.parseInt(str[2]);
					if (map[y][x].isEmpty()) {
						answer.add("EMPTY");
					} else {
						answer.add(map[y][x]);
					}
					break;
			}
		}
		return answer.toArray(String[]::new);

	}
}
