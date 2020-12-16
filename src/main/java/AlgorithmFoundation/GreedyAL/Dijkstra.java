package AlgorithmFoundation.GreedyAL;

import java.util.ArrayList;

public class Dijkstra {
    static class Edge_Set{
        private int v1;
        private int v2;
        int cost;

        public Edge_Set(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge_Set{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", cost=" + cost +
                    '}';
        }
    }
    static final int infi=9999999;
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge_Set> arr=new ArrayList<>();
        int w[][]={
                {},
                {0,0,7,4,6,1},
                {0,infi,0,infi,infi,infi},
                {0,infi,2,0,5,infi},
                {0,infi,3,infi,0,infi},
                {0,infi,infi,infi,1,0}
        };
        dijkstra(v,w,arr);
    }
    public static void dijkstra(int n,int [][]w,ArrayList<Edge_Set> setOfEdge)
    {
        int vnear=0;
        int touch[]=new int[n+1];
        int length[]=new int[n+1];

        for (int i = 2; i <=n ; i++) {
            touch[i]=1;
            length[i]=w[1][i];
        }
        for (int i = 1; i <n ; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 2; j <=n ; j++) {
                if(min>length[j] && length[j]>0)
                {
                    min=length[j];
                    vnear=j;
                }
            }
            System.out.println(touch[vnear] +" -> "+vnear);
            int sum=0;
            for (int j = 2; j <=n ; j++) {
                boolean bool=w[vnear][j]+length[vnear]<length[j];
                if(bool)
                {
                    length[j]=w[vnear][j]+length[vnear];
                    touch[j]=vnear;
                }
            }
            sum+=length[vnear];
            length[vnear]=-1;
        }
    }


}
