package AL_CS_STUDY.Weekly_40to50.Weekly41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707_BipartiteGraph {
    static final int RED = 1;
    static final int BLUE = -1;
    private static List<Integer>[] list;
    private static int[] colors;
    private static boolean flag;
    private static StringBuffer answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        answer = new StringBuffer();
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            list = new List[vertex + 1];
            colors = new int[vertex + 1];
            for (int i = 1; i < vertex + 1; i++) {
                list[i] = new LinkedList<>();
            }
            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
                list[to].add(from);
            }
            flag=true;
            answer.append(check(vertex) ? "YES" : "NO").append("\n");
        }
        System.out.println(answer);
    }

    static boolean check(int vertex) {
        for (int i = 1; i < vertex + 1; i++) {
            if (!flag) {
                return false;
            }
            if (colors[i] == 0) {
//                dfs(i, RED);
                flag=bfs(i,RED);
            }
        }
        return true;
    }

    static void dfs(int start, int color) {
        colors[start] = color;
        for (Integer next : list[start]) {
            if (colors[next] == color) {
                flag = false;
                return;
            }
            if (colors[next] == 0) {
                dfs(next, -color);
            }
        }
    }

    static boolean bfs(int start, int color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        colors[start] = color;

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            for (Integer next : list[cur]) {
                if (colors[next] == 0) {
                    q.offer(next);
                    colors[next] = -colors[cur];
                } else if (colors[next] + colors[cur] == 0) {
                    continue;
                }else if(colors[next]+colors[cur]!=0){
                    return false;
                }
            }
        }
        return true;
    }
}
