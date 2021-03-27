package tues_thurs_sat.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
// https://www.acmicpc.net/problem/1987
public class Alphabet {
    static int n,m;
    static char ch[][];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static Map<Character,Integer> map=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        ch=new char[n][m];
        for (int i = 0; i < n; i++) {
            String s=br.readLine();
            ch[i]=s.toCharArray();
        }
        map.put(ch[0][0],1);
        dfs(0,0);
        System.out.println(max+1);
    }
    static int cnt=0;
    static int max=-1;
    static void dfs(int y,int x)
    {
        max=Math.max(cnt,max);

        for (int i = 0; i < 4; i++) {
            int ny=dy[i]+y;
            int nx=dx[i]+x;
            if(ny>=0 && nx>=0 && ny<n && nx<m)
            {
                if(!map.containsKey(ch[ny][nx]))
                {
                    map.put(ch[ny][nx],1);
                    cnt++;
                    dfs(ny,nx);
                    cnt--;
                    map.remove(ch[ny][nx]);
                }
            }
        }
    }
}
