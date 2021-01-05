package Alone.AlgorithmFoundation.Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal_Test {
    static class edge_Set implements Comparable<edge_Set>{
        private int v1;
        private int v2;
        private  int weight;

        public edge_Set(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(edge_Set o) {
            if(this.weight>o.weight)
            {
                return 1;
            }
            else if(this.weight==o.weight)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "edge_Set{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", weight=" + weight +
                    '}';
        }
    }

    static ArrayList<edge_Set> arr;
    static ArrayList<edge_Set> F=new ArrayList<>();
    static int parent[];
    public static void main(String[] args) {
        arr=new ArrayList<>();
        arr.add(new edge_Set(1,4,4));
        arr.add(new edge_Set(1,2,6));
        arr.add(new edge_Set(2,3,5));
        arr.add(new edge_Set(2,4,3));
        arr.add(new edge_Set(2,5,7));
        arr.add(new edge_Set(2,6,8));
        arr.add(new edge_Set(3,6,8));
        arr.add(new edge_Set(4,5,9));
        arr.add(new edge_Set(5,6,11));

        parent=new int[7];
        for (int i = 1; i < parent.length; i++) {
            parent[i]=i;
        }

        Collections.sort(arr);

        int sum=0;  // weight 값 정렬.

        for (int i = 0; i <arr.size() ; i++) {
            edge_Set edgeSet=arr.get(i);
            if(!check(edgeSet.v1, edgeSet.v2))
            {
                F.add(edgeSet);
                sum+=edgeSet.weight;
                union(edgeSet.v1,edgeSet.v2);
            }
        }

        for (int i = 0; i <F.size(); i++) {
            System.out.println(F.get(i).toString());
        }
        System.out.println("sum -> "+sum);
    }
    public static int find(int x)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return find(parent[x]);
    }
    public static void union(int x,int y)
    {
        x=find(x);
        y=find(y);
        if(x!=y)
        {
            if(y>=x)
                parent[y]=x;
            else
                parent[x]=y;

        }
    }
    public static boolean check(int x,int y)
    {
        x=find(x);
        y=find(y);
        if(x==y)
            return true;
        return false;
    }
}
