package tues_thurs_sat._202104._20200403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class laserBeamWhere {
    static int dy[]={-1,0,1,0};
    static int dx[]={0,1,0,-1};
    static int n;
    static int map[][],visited[][];
    static int mirror;
    static int Ly,Lx;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int T=Integer.parseInt(st.nextToken());
        while (T-->0)
        {
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            map=new int[n+2][n+2];
            visited=new int[n+2][n+2];
            mirror=Integer.parseInt(st.nextToken());
            for (int i = 0; i < mirror; i++) {
                st=new StringTokenizer(br.readLine());
                int y=Integer.parseInt(st.nextToken());
                int x=Integer.parseInt(st.nextToken());
                map[y][x]=-1;
            }
            st=new StringTokenizer(br.readLine());
            Ly=Integer.parseInt(st.nextToken());
            Lx=Integer.parseInt(st.nextToken());
            // 레이저 가공.
            int dir=0;
            if(Ly==0 || Ly==n+1)
            {
                if(Ly==0)
                    dir=2;
                else
                    dir=0;
            }
            else
            {
                if(Lx==0)
                    dir=1;
                else
                    dir=3;
            }
            laserBeam(Ly,Lx,dir);
        }
    }
    static void laserBeam(int y,int x,int dir)
    {
        while (true)
        {
            int ny=y+dy[dir];
            int nx=x+dx[dir];
            if(ny>0 && nx>0 && ny<n+1 && nx<n+1)
            {
                if(map[ny][nx]==-1)
                {
                    dir=(dir+1)%4;
                }
            }
            else {
                System.out.println(ny+" "+ nx);
                break;
            }
            y=ny;
            x=nx;
        }
    }
}
