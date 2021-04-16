package thisCodingTest.Graph.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2887

public class PlanetTunnel {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        parent=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
        ArrayList<location> x=new ArrayList<>();
        ArrayList<location> y=new ArrayList<>();
        ArrayList<location> z=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            x.add(new location(a,i));
            y.add(new location(b,i));
            z.add(new location(c,i));
        }
        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(z);
        ArrayList<Node> arrayList=new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            arrayList.add(new Node(x.get(i).idx,x.get(i+1).idx,x.get(i+1).dot-x.get(i).dot));
            arrayList.add(new Node(y.get(i).idx,y.get(i+1).idx,y.get(i+1).dot-y.get(i).dot));
            arrayList.add(new Node(z.get(i).idx,z.get(i+1).idx,z.get(i+1).dot-z.get(i).dot));
        }
        Collections.sort(arrayList);
        int cost=0;
        for (Node node : arrayList) {
            if(find(node.v1)!=find(node.v2))
            {
                Union(node.v1,node.v2);
                cost+=node.cost;
            }
        }
        System.out.println(cost);



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
    static class location implements Comparable<location>
    {
        int dot, idx;

        public location(int dot, int idx) {
            this.dot = dot;
            this.idx = idx;
        }


        @Override
        public int compareTo(location location) {
            return dot-location.dot;
        }
    }
}
/*
5
11 -15 -15
14 -5 -15
-1 -1 -5
10 -4 -1
19 -4 19

ans 4
*/