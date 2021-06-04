package Alone.review._210604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IcyBreaking {
    static int n, s, p;
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        list=new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(p,-1,0);
        answer.sort((o1, o2) -> o1-o2);
        System.out.println(n-1-answer.get(0)-answer.get(1));

    }
    static ArrayList<Integer> answer=new ArrayList<>();
    static void dfs(int cur,int parent,int cnt)
    {
        if(1<=cur && cur<=s)
        {
            answer.add(cnt);
            return;
        }

        for (int i = 0; i < list[cur].size(); i++) {
            int next=list[cur].get(i);
            if(next!=parent)
            {
                dfs(next,cur,cnt+1);
            }
        }
    }
}
