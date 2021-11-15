package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ16928_SnakeAndLadderGame {
    static class Node {
        private int x, dist;

        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }

    private static int n, m;
    private static Map<Integer, Integer> movePositions = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            movePositions.put(key, val);
        }
        int answer = solve();
        System.out.println(answer);
    }

    static int solve() {
        int answer = Integer.MAX_VALUE;
        LinkedList<Node> q = new LinkedList<>();
        boolean v[] = new boolean[101];
        q.offer(new Node(1, 0));

        v[1] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == 100) {
                return cur.dist;
            }
            for (int cnt = 1; cnt <= 6; cnt++) {
                int nx = cnt + cur.x;
                if (nx > 100) continue;
                if (v[nx]) continue;
                v[nx] = true;
                if (movePositions.containsKey(nx)) {
                    Integer newNx = movePositions.get(nx);
                    if(v[newNx]) continue;
                    q.offer(new Node(newNx, cur.dist + 1));
                    v[newNx] = true;
                }else { // else 안하면 46% 틀림 왜그러지 ..? == ** 반드시 사다리나 뱀을 타야하는 건가???
                    /*
                    반드시 타야한다는 의미 인것 같다..
                    도착한 칸이 사다리면, 사다리를 타고 위로 올라간다. 뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다. 즉, 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고, 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.
                    */
                    q.offer(new Node(nx, cur.dist + 1));
                }
            }
        }
        return answer;
    }
}
