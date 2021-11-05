package Programmers.ProgrammersKit.Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class islandConnect {

    public static void main(String[] args) {

    }
    static class Node implements Comparable<Node>{
        private int v1,v2,cost;

        public Node(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return cost-node.cost;
        }
    }
    static int parent[];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
        ArrayList<Node> list=new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            int a=costs[i][0];
            int b=costs[i][1];
            int w=costs[i][2];
            list.add(new Node(a,b,w));
        }
        Collections.sort(list);
        for (Node node : list) {
            if(find(node.v1)!=find(node.v2))
            {
                union(node.v1,node.v2);
                answer+=node.cost;
            }
        }

        return answer;
    }
    static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a>b)
        {
            parent[b]=a;
        }
        else
            parent[a]=b;
    }
    static int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
}
