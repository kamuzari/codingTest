package Basic.TreeDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15681_TraaAndQuery {

    private static int[] parents;
    private static int[] volumes;
    private static List<Integer>[] list;
    private static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        volumes = new int[n + 1];
        list = new List[n + 1];
        tree = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        makeTree(root, -1);
        Arrays.fill(volumes, 1);
        cntSubTreeNodes(root);
        StringBuffer sb = new StringBuffer();
        while (q-- > 0) {
            int query = Integer.parseInt(br.readLine());
            int answer = volumes[query];
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void makeTree(int cur, int parent) {
        for (Integer next : list[cur]) {
            if (next != parent) {
                tree[cur].add(next);
                parents[next] = cur;
                makeTree(next, cur);
            }
        }
    }

    public static void cntSubTreeNodes(int cur) {
        for (Integer next : tree[cur]) {
            cntSubTreeNodes(next);
            volumes[cur] += volumes[next];
        }
    }
}
