package thisCodingTest.Graph.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
ans= 51
*/
public class DarkRoad {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        parent=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
        ArrayList<Node> arrayList=new ArrayList<>();
        int sum=0;
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            sum+=cost;
            arrayList.add(new Node(v1,v2,cost));
        }
        Collections.sort(arrayList);
        int totalCost=0;
        for (Node node : arrayList) {
            if(find(node.v1)!=find(node.v2))
            {
                Union(node.v1,node.v2);
                totalCost+=node.cost;
            }
        }
        System.out.println(sum-totalCost);
    }
    static void Union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a>b)
            parent[b]=a;
        else
            parent[a]=b;
    }
    static int find(int v)
    {
        if(parent[v]==v)
            return v;
        return parent[v]=find(parent[v]);
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
}
