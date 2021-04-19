package AL_CS_STUDY.Weekly17.TreeDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeAndQuary {
    static int n,r,q;
    static boolean visited[];
    static int dp[];
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        visited=new boolean[n+1];
        for (int i = 0; i < n-1; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
//        for (int i = 0; i < n+1; i++) {
//            System.out.println("["+i+"] -> "+list.get(i));
//        }

        dp=new int[n+1];
        Arrays.fill(dp,1);
        dfs(r);

        for (int i = 0; i < q; i++) {
            int a=Integer.parseInt(br.readLine());
            System.out.println(dp[a]);
        }


    }
    private static int dfs(int r) {
        if(visited[r])
            return dp[r];
        visited[r]=true;

        for (Integer val : list.get(r)) {
            if(visited[val])
                continue;
            dp[r]+=dfs(val);

        }
        return dp[r];
    }
}
