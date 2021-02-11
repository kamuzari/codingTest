package oneDay_twoSol.graphTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Urban_divisionPlan {
    static int parent[];
    public static int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
    public static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a<b)
            parent[b]=a;
        else
            parent[a]=b;
    }
    static class edges implements Comparable<edges>{
        private int v1,v2,dist;

        public edges(int v1, int v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

        @Override
        public int compareTo(edges o) {
            return this.dist-o.dist;
        }

        @Override
        public String toString() {
            return "edges{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", dist=" + dist +
                    '}';
        }
    }
    static ArrayList<edges> edgeList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        parent=new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < m; i++) {
            edgeList.add(new edges(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        int keepCost=0;
        Collections.sort(edgeList);
//        System.out.println(edgeList);
        int last=0;
        for (edges edge : edgeList) {
            if(find(edge.v1)!=find(edge.v2))
            {
                union(edge.v1,edge.v2);
                keepCost+=edge.dist;
                last=edge.dist;
            }
        }
        System.out.println(keepCost-last);
    }
}
/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
*/
