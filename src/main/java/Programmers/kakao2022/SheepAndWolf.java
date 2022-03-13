package Programmers.kakao2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SheepAndWolf {

    /**
     * 최대한 많은 수의 양을 모아서 다시 루트 노드로 돌아오게 하기. idea : 완전탐색 := 백트래킹 NOTE : 0 -> 1 -> 4 := 왼쪽 서브트리에서 방문하지
     * 않는 곳들은 모두 늑대를 거쳐가야해서 다른 서브트리로 가는 로직이 이해가 안됨. := 현재 거점에서 다시 루트로 올라가 방문하고 8 -> 7 -> 9 갔다가 다시 4
     * -> 6 -> 5 로 가는 아이디어가 없음 hint : SheepAndWolf.img , 단방향 LIST,
     */
    static final int SHEEP = 0;
    static final int PARENT = 0;
    static final int CHILD = 1;

    static int maxCnt;
    static Map<Integer, List<Integer>> map;

    public int solution(int[] info, int[][] edges) {
        maxCnt = 0;
        map = new HashMap<>();
        for (int[] e : edges) {
            if (!map.containsKey(e[PARENT])) {
                map.put(e[PARENT], new ArrayList<>());
            }
            map.get(e[PARENT]).add(e[CHILD]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(SHEEP); // root 부터 경로 시작
        dfs(0, 0, 0, list, info);
        return maxCnt;
    }

    public void dfs(int current, int sheep, int wolf, List<Integer> list, int[] info) {
        if (info[current] == SHEEP) {
            sheep++;
        } else {
            wolf++;
        }

        if (sheep <= wolf) {
            return;
        }

        maxCnt = Math.max(maxCnt, sheep);
        List<Integer> nextNodes = new ArrayList<>(list);
        if (map.containsKey(current)) {
            nextNodes.addAll(map.get(current));
        }
        Integer currentNode = Integer.valueOf(current); // NOTE := remove 함수 오버로딩 주의 (index 형 및 객체형)
        nextNodes.remove(currentNode);

        for (Integer next : nextNodes) {
            dfs(next, sheep, wolf, nextNodes, info);
        }
        return;
    }
}
