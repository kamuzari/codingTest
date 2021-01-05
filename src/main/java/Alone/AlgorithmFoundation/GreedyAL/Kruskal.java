package Alone.AlgorithmFoundation.GreedyAL;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
    static int parent[];
    static ArrayList<edgeSet> eSet;
    static ArrayList<edgeSet> F;
    static class edgeSet implements Comparable<edgeSet>{
        private int v1;
        private int v2;
        private int cost;

        public edgeSet(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "edgeSet{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(edgeSet o) {
            if(this.cost>o.cost)
                return 1;
            else if(this.cost<o.cost)
                return -1;
            else
                return 0;
        }
    }
    public static int find(int x)
    {
        if(parent[x]==x)
            return x;
        return find(parent[x]);
    }
    public static void union(int x,int y)
    {
        x=find(x);
        y=find(y);

        if(x!=y)
        {
            if(y>x)
                parent[y]=x;
            else
                parent[x]=y;
        }
    }

    public static boolean cycle_check(int x,int y)
    {
        x=find(x);
        y=find(y);

        if(x==y)
            return true;
        return false;
    }


    public static void main(String[] args) {
        eSet =new ArrayList<>();
        eSet.add(new edgeSet(1,2,1));
        eSet.add(new edgeSet(3,5,2));
        eSet.add(new edgeSet(2,3,4));
        eSet.add(new edgeSet(1,3,3));
        eSet.add(new edgeSet(2,4,6));
        eSet.add(new edgeSet(4,5,5));
        Collections.sort(eSet);

        F=new ArrayList<>();

        kruskal(6,6,eSet,F);

    }
    public static void kruskal(int n,int m,ArrayList<edgeSet> arr,ArrayList<edgeSet> F)
    {
        parent=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            parent[i]=i;
        }
        int sum=0;
        for (int i = 0; i <arr.size() ; i++) {
            edgeSet e=arr.get(i);
            boolean bool=cycle_check(e.v1,e.v2);
            if(!bool)
            {
                F.add(e);
                sum+=e.cost;
                union(e.v1,e.v2);
            }
        }
        for (int i = 0; i <F.size(); i++) {
            System.out.println(F.get(i).toString());
        }
        System.out.println("sum -> "+sum);
    }

}
