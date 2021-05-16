package WeeklyThurseday.Random2;

import java.util.Scanner;

/*
1. 벽을 세우고
2. 감염시킨다.
*/
public class Laboratory {

    static int n;
    static int m;
    static int middle_ans;
    static int[][] map;
    static int[][] tempMap;

    // 행 열 좌표 (이동 배열)
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt(); m=sc.nextInt();
        map =new int[n][m];
        tempMap =new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        middle_ans=0;
        int wall_cnt=0;
        dfs(wall_cnt);
        System.out.println(middle_ans);
    }
    public static void infection(int y,int x)
    {
        for (int i = 0; i < 4; i++) {
            int ty=dy[i]+y;
            int tx=dx[i]+x;
            if(ty>=0 && tx>=0 && ty<n && tx<m)
            {
                if(tempMap[ty][tx]==0)
                {
                    tempMap[ty][tx]=2;
                    infection(ty,tx);
                }
            }
        }
    }
    public static int stableAreaCheck()
    {
        int stable=0;
        for (int i = 0; i<n ; i++) {
            for (int j = 0; j < m; j++) {
                if(tempMap[i][j]==0)
                    stable++;
            }
        }
        return stable;
    }
    public static void dfs(int cnt)
    {
        if(cnt==3)
        {
            //  벽을 세우면 감영 시켜서 안전영역 체크
            for (int i = 0; i < n; i++) {
                tempMap[i]=map[i].clone();
            }
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <m ; j++) {
                    if(tempMap[i][j]==2)
                        infection(i,j);
                }
            }
            middle_ans=Math.max(middle_ans,stableAreaCheck());
            return;
        }
        // 벽 세유기
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0)
                {
                    map[i][j]=1; // 벽 세우고
                    dfs(cnt+1); // 호출
                    map[i][j]=0; // 벽 제거
                }
            }
        }
    }
}
