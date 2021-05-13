package tues_thurs_sat._0514;


import java.util.ArrayList;

public class AllZeroMaking {
    static ArrayList<Integer>[] list;
    static long[] check;
    static boolean[] v;
    static long answer=0;
    public long solution(int[] a, int[][] edges) {
        list=new ArrayList[a.length];
        v=new boolean[a.length];
        check=new long[a.length];

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
        dfs(0,a);
        return answer;
    }

    private void dfs(int cur, int[] a) {
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
            if(check[cur]!=0)
                answer=-1;
        }
    }
}
