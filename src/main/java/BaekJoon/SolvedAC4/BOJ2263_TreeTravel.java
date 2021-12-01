package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2263_TreeTravel {

    static int inOrder[];
    static int postOrder[];
    /*
     * 중위 순회와 후위 순회를 보고 전위 순회에 나타내어질 노드를 출력.
     */
    static int preOrder[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        // 전위 순회 채우기
        getPreOrder(0, n - 1, 0, n - 1);
        for (int nodeNumber : preOrder) {
            System.out.print(nodeNumber + " ");
        }
    }

    static int idx = 0;

    public static void getPreOrder(int is, int ie, int ps, int pe) {

        if (is > ie || ps > pe) {
            return;
        }

        preOrder[idx++] = postOrder[pe];

        int inOrderRootIdx = 0;
        for (int i = is; i <= ie; i++) {
            if (inOrder[i] == postOrder[pe]) {
                inOrderRootIdx = i;
                break;
            }
        }

        getPreOrder(is, inOrderRootIdx - 1, ps, (ps + inOrderRootIdx) - is - 1);
        getPreOrder(inOrderRootIdx + 1, ie, (ps + inOrderRootIdx) - is, pe - 1);
    }
}
