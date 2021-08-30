package AL_CS_STUDY.Weekly_30to40.Weekly33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayRotate4 {

    private static int[][] originalArray;
    private static int n;
    private static int m;
    private static int k;
    private static int orders[];
    private static boolean v[];
    private static Node[] rotations;
    private static int min;

    static class Node {
        private int y, x, s;

        public Node(int y, int x, int s) {
            this.y = y;
            this.x = x;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        originalArray = new int[n + 1][m + 1];
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                originalArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotations = new Node[k];
        orders = new int[k];
        v = new boolean[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            rotations[i] = new Node(y, x, s);
        }
        pick(0);

        System.out.println(min);
    }

    private static void pick(int cnt) {
        if (k == cnt) {
            int temp[][] = new int[n + 1][m + 1];
            for (int i = 0; i < n + 1; i++) {
                temp[i] = originalArray[i].clone();
            }

            for (int i = 0; i < k; i++) {
                int orderNumber = orders[i];
                Node cur = rotations[orderNumber];
//                rotate(cur.y,cur.x,cur.s,temp);
                int ly, lx, ry, rx;
                ly = cur.y - cur.s;
                lx = cur.x - cur.s;
                ry = cur.y + cur.s;
                rx = cur.x + cur.s;
                rotate(ly, lx, ry, rx, temp);
            }
            for (int i = 1; i < n + 1; i++) {
                int sum = Arrays.stream(temp[i]).reduce(Integer::sum).orElseThrow((RuntimeException::new));
                min = Math.min(sum, min);
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!v[i]) {
                v[i] = true;
                orders[cnt] = i;
                pick(cnt + 1);
                v[i] = false;
            }
        }
    }

    private static void rotate(int sr, int sc, int er, int ec, int[][] arr) {
        int depth = 0;

        while (true) {
            int nsr = sr + depth, nsc = sc + depth;
            int ner = er - depth, nec = ec - depth;
            if (nsr >= ner || nsc >= nec)
                break;

            int val = arr[nsr][nsc];
            for (int i = nsr; i < ner; i++) {
                arr[i][nsc] = arr[i + 1][nsc];
            }

            for (int i = nsc; i < nec; i++) {
                arr[ner][i] = arr[ner][i + 1];
            }

            for (int i = ner; i > nsr; i--) {
                arr[i][nec] = arr[i - 1][nec];
            }

            for (int i = nec; i > nsc + 1; i--) {
                arr[nsr][i] = arr[nsr][i - 1];
            }
            arr[nsr][nsc + 1] = val;
            depth++;
        }
    }
}


