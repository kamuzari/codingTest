package AL_CS_STUDY.Weekly_30to40.Weekly31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baaaaaaaaaduk2_Easy {

    private static int n;
    private static int m;
    private static int[][] map;
//    private static int pick[]=new int[2];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static int answer=0;

    static class Node{
        private int y,x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);
        System.out.println(answer);

    }
    static void comb(int cnt,int idx)
    {
        if(cnt==2)
        {
//            System.out.println(Arrays.toString(pick));
            boolean v[][]=new boolean[n][m];
            int blackDieCnt=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j]==2 && !v[i][j])
                    {
                        blackDieCnt+=bfs(i,j,v);
                    }
                }
            }
            answer=Math.max(blackDieCnt,answer);
            return;
        }
        for (int i = idx; i < n*m; i++) {
            int r=i/m;
            int c=i%m;
            if(map[r][c]==0)
            {
//                pick[cnt]=i;
                map[r][c]=1;
                comb(cnt+1,i+1);
                map[r][c]=0;
            }
        }
    }

    private static int bfs(int y, int x,boolean v[][]) {

        LinkedList<Node> q=new LinkedList<>();

        int cnt=1;
        q.offer(new Node(y,x));
        v[y][x]=true;
        boolean blackIsDied=true;

        while (!q.isEmpty())
        {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {

                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny<0 || nx<0 || ny>=n || nx>=m || v[ny][nx])
                    continue;
                if(map[ny][nx]==0)
                    blackIsDied=false;
                else if(map[ny][nx]==2)
                {
                    q.offer(new Node(ny,nx));
                    v[ny][nx]=true;
                    cnt++;
                }

            }
        }
        if(blackIsDied)
            return cnt;
        else
            return 0;
    }
}
