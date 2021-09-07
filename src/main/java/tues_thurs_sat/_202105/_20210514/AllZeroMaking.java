package tues_thurs_sat._202105._20210514;


import java.util.ArrayList;

public class AllZeroMaking {
    public static void main(String[] args) {
        int e[][]={
                {0,1},{3,4},{2,3},{0,3}
        };
        int a[]={-5,0,2,1,2};
        System.out.println(solution(a,e));
    }
    static ArrayList<Integer>[] list;
    static long[] check;
    static boolean[] v;
    static long answer;
    public static long solution(int[] a, int[][] edges) {
        long A[]=new long[a.length];
        for (int i = 0; i < a.length; i++) {
            A[i]=a[i];
        }
        list=new ArrayList[a.length];
        v=new boolean[a.length];
        check=new long[a.length];
        answer=0;
        for (int i = 0; i < a.length; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from=edges[i][0];
            int to=edges[i][1];
            list[from].add(to);
            list[to].add(from);
        }
        v[0]=true;
        dfs(0,A);
        return answer;
    }

    private static void dfs(int cur, long[] a) {
        for (int i = 0; i < list[cur].size(); i++) {
            if(!v[list[cur].get(i)])
            {
                v[list[cur].get(i)]=true;
                dfs(list[cur].get(i),a);
                check[cur]=check[cur]+check[list[cur].get(i)];
                answer=answer+Math.abs(check[list[cur].get(i)]);
            }
        }
        check[cur]=check[cur]+a[cur];
        if(cur==0)
        {
            if(check[0]!=0)
                answer=-1;
        }
    }
}
