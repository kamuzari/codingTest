package oneDay_twoSol.graphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class topologySort {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    ;
    static int[] passDegree;
    static int v, e;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        passDegree = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList.get(a).add(b);
            passDegree[b] += 1;
        }
        topologysort();

    }
    // 위상 정렬 : 방향 그래프의 모든 노드를 방향성에 거스르지 않도록 순서대로 나열하는 것.
    // 사이클이 존재하면 모든 정점을 방문하기 전에 사이클이 형성 된것임.
    public static void topologysort() {
        ArrayList<Integer> ans = new ArrayList<>(); // 결과 출력 (순서)
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < v + 1; i++) {
            if (passDegree[i] == 0)
                q.add(i); // 진입 차수가 0인 것을 담고
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for (Integer i : adjList.get(cur)) {
                passDegree[i] -= 1;
                if (passDegree[i] == 0) // 진입 차수가 0인 것만 큐에 추가.
                    q.offer(i);
            }
        }
        // 사이클이 일어나지 않는 정점들 만을 결과리스트에 추가.
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
    /*
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
    */

}
