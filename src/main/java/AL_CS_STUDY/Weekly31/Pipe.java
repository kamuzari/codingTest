package AL_CS_STUDY.Weekly31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/17070
public class Pipe {
    static int n;
    static int map[][];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n=Integer.parseInt(br.readLine());
        map=new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        pipeMove(0,1,0);
        System.out.println(cnt);
    }

    private static void pipeMove(int y, int x, int dir) {
        if(y==n-1 && x==n-1 && map[y][x]!=1)
        {
            cnt++;
            return;
        }

        if(dir==0)
        {
            if(!outOfTheIndex(y,x+1) && map[y][x+1]==0)
                pipeMove(y,x+1,0);
            if(!outOfTheIndex(y+1,x+1)&& map[y][x+1]==0 && map[y+1][x]==0 && map[y+1][x+1]==0)
                pipeMove(y+1,x+1,2);
        }
        else if(dir==1)
        {
            if(!outOfTheIndex(y+1,x) && map[y+1][x]==0)
                pipeMove(y+1,x,1);
            if(!outOfTheIndex(y+1,x+1)&& map[y][x+1]==0 && map[y+1][x]==0 && map[y+1][x+1]==0)
                pipeMove(y+1,x+1,2);
        }
        else if(dir==2)
        {
            if(!outOfTheIndex(y,x+1) && map[y][x+1]==0)
                pipeMove(y,x+1,0);
            if(!outOfTheIndex(y+1,x) && map[y+1][x]==0)
                pipeMove(y+1,x,1);
            if(!outOfTheIndex(y+1,x+1)&& map[y][x+1]==0 && map[y+1][x]==0 && map[y+1][x+1]==0)
                pipeMove(y+1,x+1,2);
        }

    }
    static boolean outOfTheIndex(int y,int x)
    {
        return (y<0 || x<0 || y>=n || x>=n);
    }
}
