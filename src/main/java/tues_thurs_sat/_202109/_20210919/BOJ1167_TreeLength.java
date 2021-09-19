package tues_thurs_sat._202109._20210919;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1167_TreeLength {

    private static int maxLen;
    private static int pivotNode;
    private static boolean[] v;

    static class Node{
        private int vertex,weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    static List<Node> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list=new List[n+1];
        for (int i = 1; i < n + 1; i++) {
            list[i]=new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                int weight=Integer.parseInt(st.nextToken());
                list[vertex].add(new Node(next,weight));
            }
        }
        v=new boolean[n+1];
        dfs(1,0);

        v=new boolean[n+1];
        dfs(pivotNode,0);

        System.out.println(maxLen);
    }

    public static void dfs(int vertex,int length)
    {
        if(length> maxLen){
            maxLen =length;
            pivotNode =vertex;
        }
        v[vertex]=true;

        for (Node next : list[vertex]) {
            if(!v[next.vertex])
            {
                v[next.vertex]=true;
                dfs(next.vertex, length+next.weight);
            }
        }
    }
}
