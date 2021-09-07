package tues_thurs_sat._202104._20210417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17490
public class Building_bridgeToLLamho {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        Node dist[]=new Node[n+1];
        st=new StringTokenizer(br.readLine());
        boolean graph[][]=new boolean[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            dist[i]=new Node(i,Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(dist);

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a][b]=true;
            graph[b][a]=true;
        }
    }
    static class Node implements Comparable<Node>{
        private int number,dist;

        public Node(int number, int dist) {
            this.number = number;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {
            return dist-node.dist;
        }
    }
}
