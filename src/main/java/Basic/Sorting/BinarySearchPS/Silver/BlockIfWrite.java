package Basic.Sorting.BinarySearchPS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BlockIfWrite {
    private static int N;
    private static int M;

    static class Node {
        private String name;
        private int val;

        public Node(String name, int val) {
            this.name = name;
            this.val = val;
        }
    }

    static List<Node> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Node(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < M; i++) {
            int ability = Integer.parseInt(br.readLine());
            sb.append(list.get(binarySearch(ability)).name).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int binarySearch(int ability) {
        int s = 0;
        int e = list.size()-1;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (ability <= list.get(mid).val) {
                e = mid-1;
            } else {
                s = mid + 1;
            }
        }
        return e+1;
    }
}
