package tony;

import java.util.*;

public class WarmHole {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int tc = Integer.parseInt(sc.nextLine());
        StringBuilder answers = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            start(answers);
        }

        System.out.println(answers);
    }

    static class Node {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void start(StringBuilder answers) {
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        List<Node>[] edges = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(sc.nextLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[v1].add(new Node(v2, cost));
            edges[v2].add(new Node(v1, cost));
        }

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(sc.nextLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[v1].add(new Node(v2, -cost));
        }

        int[] dists = new int[n + 1];
        Arrays.fill(dists, (int) 1e9);
        int startId = 1;
        dists[startId] = 0;

        for (int i = startId; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Node next : edges[j]) {
                    int newCost = dists[j] + next.cost;
                    if (dists[next.v] > newCost) {
                        dists[next.v] = newCost;
                    }
                }
            }
        }

        boolean hasNegativeCycle = false;
        for (int i = 1; i <= n; i++) {
            for (Node next : edges[i]) {
                int newCost = dists[i] + next.cost;
                if (dists[next.v] > newCost) {
                    hasNegativeCycle = true;
                    break;
                }
            }
        }

        String answer = hasNegativeCycle ? "YES" : "NO";
        answers.append(answer).append(System.lineSeparator());
    }

}

