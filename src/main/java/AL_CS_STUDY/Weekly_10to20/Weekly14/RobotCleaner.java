package AL_CS_STUDY.Weekly_10to20.Weekly14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner {
    static int n,m;
    static int map[][];
    static boolean visited[][];
    static class Node{
        int y,x,dir;

        public Node(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
    static int dy[]={-1,0,1,0};
    static int dx[]={0,1,0,-1};
    static int robotY,robotX,robotDir;
    static int cnt=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        st=new StringTokenizer(br.readLine());
        robotY=Integer.parseInt(st.nextToken());
        robotX=Integer.parseInt(st.nextToken());
        robotDir=Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(robotY,robotX,robotDir);
        System.out.println(cnt);
    }
    //                  0  1  2  3
    // 현재 방향에서 왼쪽 북 동 남 서
    // 청소를 할 수 있는 대로 모두 다하고 return을 하고  (함수가 모두 종료)-> 뒤로 물러서면서 청소하지 못한 곳을 순회.
    static void dfs(int y,int x,int dir)
    {
        map[y][x]=2;
        for (int i = 0; i < 4; i++) {
            dir=(dir+3)%4;
            int ny=dy[dir]+y;
            int nx=dx[dir]+x;
            // 청소할 수 있는 쪽..
            if(ny>=0 && nx >=0 && ny<n && nx <m && map[ny][nx]==0)
            {
                cnt++;
                dfs(ny,nx,dir);
                return;
            }
            // return 을 하는 이유는 로봇 청소기가 청소 되었으므로
            //  그 곳을 뒤로 가도 지나온 길 이므로 청소할 필요가 전혀 없다.
            // 이미 앞에서 왼쪽 청소하고 왼쪽 왼쪽 왼쪽.. 탐색하여 청소할 수 있는 공간을 다 탐색했기 때문이다.
        }

        // 청소를 모두 마치거나 청소할 곳이 없는 곳.
        int back=(dir+2)%4;
        int backY=dy[back]+y;
        int backX=dx[back]+x;
        if(backX>=0 && backY>=0 && backY<n && backX<m && map[backY][backX]!=1)
        {
            dfs(backY,backX,dir); // 바라보는 방향은 유지 한 칸 후진.
//             다 후진 하고 돌와서 다른 곳도 탐색해서 청소를 할지 말지 결정.
        }


    }
}
