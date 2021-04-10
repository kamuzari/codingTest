package tues_thurs_sat._20210410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class companyCulture {
    static int cnt[];
    static ArrayList<ArrayList<Integer>> arrayList=new ArrayList<>();
    static ArrayList<Integer> list[];
    static int ans[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ans=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            arrayList.add(new ArrayList<>());
        }
        st=new StringTokenizer(br.readLine());
        cnt=new int[n+1];
        
        for (int i = 0; i < n; i++) {
            int a=Integer.parseInt(st.nextToken());
            if(a!=-1)
                arrayList.get(a).add(i+1);
        }
       /*while (m-->0)
       {
           st=new StringTokenizer(br.readLine());
           int a=Integer.parseInt(st.nextToken());
           int b=Integer.parseInt(st.nextToken());

           PriorityQueue<Integer> q=new PriorityQueue<>();
           q.add(a);
            while (!q.isEmpty())
            {
                int vertax=q.poll();
                cnt[vertax]+=b;
                for (Integer integer : arrayList.get(vertax)) {
                    q.add(integer);
                }
            }

//           System.out.println(Arrays.toString(cnt));
       }*/

        while (m-->0)
        {
            st=new StringTokenizer(br.readLine());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            cnt[v]+=w;
        }
        for (int i = 2; i < n+1; i++) {
            if(cnt[i]>0)
                dfs(i,cnt[i]);
        }
        for (int i = 1; i < n+1; i++) {
            System.out.print(ans[i]+" ");
        }

        
    }
    static void dfs(int n,int k)
    {
        ans[n]+=k;
        for (int i : arrayList.get(n)) {
            dfs(i,k);
        }

    }

}
