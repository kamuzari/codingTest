package oneDay_twoSol.graphTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kruskal {
    static class Edge  implements Comparable<Edge>{
        private int v1,v2,dist;

        public Edge(int v1, int v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.dist-o.dist==0)
                return this.v1-o.v1;
            return this.dist-o.dist;
        }
    }
    static int parent[];
    static ArrayList<Edge> edges=new ArrayList<>();
    public static int res=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        parent=new int[v+1];
        // init
        for (int i = 1; i < v+1; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < e; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int dist=sc.nextInt();
            edges.add(new Edge(a,b,dist));
        }

        // 크루스칼 : 모든 정점들을  최소비용으로 연결하는 알고리즘 (정점의 개수-1 개의 간선이 생성.)
        Collections.sort(edges);
        for (Edge edge : edges) {
            int dist=edge.dist;
            int v1=edge.v1;
            int v2=edge.v2;
            // 사이클이 이루어 지는지 확인
            if(find(v1)!=find(v2))
            {
                // 사이클이 아니면 합치기
                union(v1,v2);
                res+=dist;
            }
        }
        System.out.println(res);


    }
    // 부모 노드가 같은지 확인
    static int find(int a)
    {
        if(parent[a]==a)
            return a;
        else
            return parent[a]=find(parent[a]);
    }
    // 사이클이 아니면 합치기
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


/*
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
*/
