package oneDay_twoSol.graphTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class planetTunnel {
    static class Edge implements Comparable<Edge>{
        private int v1,v2,dist;

        public Edge(int v1, int v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist-o.dist;
        }
    }
    static class Position implements Comparable<Position>
    {
        private int x,y;

        public Position( int x,int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if(this.x==o.x)
                return this.y -o.y;
            return x-o.x;
        }
    }
    static int n,parent[];
    static ArrayList<Edge>edges=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         n=sc.nextInt();
        parent=new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i]=i;
        }
        ArrayList<Position>x=new ArrayList<>();
        ArrayList<Position>y=new ArrayList<>();
        ArrayList<Position>z=new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            x.add(new Position(sc.nextInt(),i));
            y.add(new Position(sc.nextInt(),i));
            z.add(new Position(sc.nextInt(),i));
        }
        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(z);

        for (int i = 0; i < n-1; i++) {
            edges.add(new Edge(x.get(i).y,x.get(i+1).y,x.get(i+1).x-x.get(i).x));
            edges.add(new Edge(y.get(i).y,y.get(i+1).y,y.get(i+1).x-y.get(i).x));
            edges.add(new Edge(z.get(i).y,z.get(i+1).y,z.get(i+1).x-z.get(i).x));
        }
        int res=0;
        Collections.sort(edges);
        for (Edge edge : edges) {
            int v1=edge.v1;
            int v2=edge.v2;
            int dist=edge.dist;
            if(find(v1)!=find(v2))
            {
                union(v1,v2);
                res+=dist;
            }
        }
        System.out.println(res);
    }
    static int find(int a)
    {
        if(a==parent[a])
            return parent[a];
        return parent[a]=find(parent[a]);
    }
    static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a<b)
            parent[b]=a;
        else
            parent[a]=b;
    }

}
