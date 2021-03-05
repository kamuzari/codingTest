package oneDay_twoSol.DFS_BFS2.Theory.Deep;

import java.util.*;

public class specialCitySearch_BFS {
    static int n, m, k, x;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        int dist[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList.get(a).add(b);
        }
        Arrays.fill(dist,(int)1e9);

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : adjList.get(cur)) {
                if (dist[i] == (int) 1e9) {
                    dist[i] = dist[cur] + 1;
                    q.offer(i);
                }
            }
        }
        System.out.println(Arrays.toString(dist));

    }
}
