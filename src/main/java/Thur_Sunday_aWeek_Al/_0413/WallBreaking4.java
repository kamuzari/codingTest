package Thur_Sunday_aWeek_Al._0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WallBreaking4 {
    static int n,m,map[][],renewal[][];
    static HashMap<Integer,Integer> hashMap=new LinkedHashMap<>();
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static int AreaIndex=0;
    static int cnt=0;
//    static boolean visited[];  ** 초기화 하는 과정에서 TLE **
    static class node{
        private int y,x;

        public node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        Queue<node> q=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str[]=br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j]==1) {
                    map[i][j]=-1;
                    q.add(new node(i,j));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0)
                {
                    AreaIndex++;
                    dfs(i,j);
                    hashMap.put(AreaIndex,cnt);
                    cnt=0;
                }
            }
        }


//        System.out.println(hashMap);
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        renewal=new int[n][m];
        while (!q.isEmpty())
        {
//            visited=new boolean[AreaIndex+1];
            node cur=q.poll();
            Set<Integer>set=new LinkedHashSet<>();
            int sum=1;
            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx]!=-1)
                {
//                    if(!visited[map[ny][nx]])
//                    {
//                        sum+=hashMap.get(map[ny][nx]);
//                        visited[map[ny][nx]]=true;
//                    }
                    set.add(map[ny][nx]);
                }
            }
            for (Integer val : set) {
                sum+=hashMap.get(val);
            }
            renewal[cur.y][cur.x]=sum%10;
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(renewal[i]));
//        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
               sb.append(renewal[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);



    }
    static void dfs(int y,int x)
    {
        cnt++;
        map[y][x]=AreaIndex;
        for (int i = 0; i < 4; i++) {
            int ny=dy[i]+y;
            int nx=dx[i]+x;
            if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx]==0)
            {
                dfs(ny,nx);
            }
        }
    }

}
