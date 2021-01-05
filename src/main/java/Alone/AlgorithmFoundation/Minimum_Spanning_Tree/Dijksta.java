package Alone.AlgorithmFoundation.Minimum_Spanning_Tree;

public class Dijksta {
    static int weight[];
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
    public static void main(String[] args) {
        int v=5;
        int w[][]={
                {},
                {0,0,7,4,6,1},
                {0,0,0,0,0,0},
                {0,0,2,0,5,0},
                {0,0,3,0,0,0},
                {0,0,0,0,1,0}
        };
        dijkstra(v,w);
    }

    public static void dijkstra(int n, int [][]w)
    {
        int sum=0;
        int from[]=new int [n+1];
        int dist[]=new int [n+1];

        for (int i = 2; i <from.length ; i++) {
            from[i]=1;
            dist[i]=w[1][i];
        }
        // 총 vertax -1 번 loop
        int vnear=0;
        for (int i = 1; i <n ; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 2; j <=n ; j++) {
                if(min>dist[j] && dist[j]>0 )
                {
                    min=dist[j];
                    vnear=j;
                }
            }
            // array이에 추가
            System.out.println(from[vnear]+" -> "+vnear);
            int k=0;
            for (int j = 2; j <=n ; j++) {
                if(w[vnear][j]!=0&&dist[vnear]+w[vnear][j]<dist[j])
                {
                    dist[j]=dist[vnear]+w[vnear][j];
                    from[j]=vnear;
                }
            }
            sum+=dist[vnear];
            dist[vnear]=-1;
        }
        System.out.println("1에서 부터의 short Path : "+sum);
    }
}
