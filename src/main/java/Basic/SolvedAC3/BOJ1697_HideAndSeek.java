package Basic.SolvedAC3;

import java.io.*;
import java.util.*;

public class BOJ1697_HideAndSeek {

    public static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = solution(n, k);
        System.out.println(answer);
    }

    static int dx[] = {-1, 1, 2};

    public static int solution(int n, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int dist[] = new int[100_001];
        q.offer(n);
        Arrays.fill(dist, INF);
        dist[n] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == k) {
                break;
            }
            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if (i == 2) {
                    nx = dx[i] * cur;
                } else {
                    nx = dx[i] + cur;
                }
                if (nx < 0 || nx > 100_000) continue;
                if (dist[nx] < dist[cur] + 1) continue;
                dist[nx] = dist[cur] + 1;
                q.offer(nx);
            }
        }
        return dist[k];
    }
}

