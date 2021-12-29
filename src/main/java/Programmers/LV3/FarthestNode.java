package Programmers.LV3;

import java.util.*;

/*
 * 문제 : 가장 먼 노드
 * Link : https://programmers.co.kr/learn/courses/30/lessons/49189
 * 풀이 전략 : 다익스트라
 * 사용 자료구조 : 인접리스트
 * 알고리즘과 자료구조 선택 이유
 * := 정해진 노드 기준으로 가장 먼 노드를 구하는 다익스트라(가장 짧은 거리)의 반대로 구현함.
 * 시간 복잡도 := edgeSize log VertexSize
 */
public class FarthestNode {

    ArrayList<Integer> adjList[];
    static final int NOT_EXIST_FARTHEST_NODE = -1;

    public int solution(int n, int edge[][]) {
        int[] dist = initVariable(n);
        insertAdjListFronEdges(edge);
        int[] distanceTable = bfs(dist); // main logic
        int answer = Integer.MIN_VALUE;
        // 1번에서 가장 먼 노드 개수 구하기
        answer = getFarthestNode(distanceTable, answer);

        if (answer == NOT_EXIST_FARTHEST_NODE) {
            return -1;
        } else {
            return answer;
        }
    }

    private int[] initVariable(int n) {
        adjList = new ArrayList[n + 1];
        int dist[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
            dist[i] = -1;
        }
        return dist;
    }

    private void insertAdjListFronEdges(int[][] edge) {
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            adjList[a].add(b);
            adjList[b].add(a);
        }
    }

    private int[] bfs(int[] distTable) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        distTable[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : adjList[cur]) {
                if (distTable[next] == -1) {
                    distTable[next] = distTable[cur] + 1;
                    q.offer(next);
                } else if (distTable[next] > distTable[cur] + 1) {
                    distTable[next] = distTable[cur] + 1;
                    q.offer(next);
                }
            }
        }
        return distTable;
    }

    private int getFarthestNode(int[] distanceTable, int answer) {
        for (int i = 1; i < distanceTable.length; i++) {
            if (answer < distanceTable[i]) {
                answer = 0;
                answer++;
                answer = distanceTable[i];
            } else if (answer == distanceTable[i]) {
                answer++;
            }
        }
        return answer;
    }
}
