package Alone;

import java.util.*;

public class Test3 {

    public static void main(String[] args) {
        int arr[][] = {{1, 3}, {1, 4}, {3, 5}, {5, 4}};
        int n = 5;
        int res[]=solution(n, arr);
        System.out.println(Arrays.toString(res));
    }

    static int passDegree[];
    static ArrayList<ArrayList<Integer>> adjList;

    public static int[] solution(int n, int[][] quests) {
        int[] answer = {};
        adjList = new ArrayList<>();
        passDegree = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < quests.length; i++) {
            int a = quests[i][0];
            int b = quests[i][1];
            adjList.get(a).add(b);
            passDegree[b]++;
        }
        return topologysort(n);
    }

    public static int[] topologysort(int v) {
        ArrayList<Integer> ans = new ArrayList<>(); // 결과 출력 (순서)
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i < v + 1; i++) {
            if (passDegree[i] == 0)
                q.add(i);
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
        int k=0; int arr[]=new int[ans.size()];
        for (Integer an : ans) {
            arr[k++]=an;
        }
        return arr;
    }
}
