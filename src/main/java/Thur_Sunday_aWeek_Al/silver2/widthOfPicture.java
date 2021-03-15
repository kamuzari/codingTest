package Thur_Sunday_aWeek_Al.silver2;

import java.util.ArrayList;
import java.util.Scanner;

public class widthOfPicture {
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static ArrayList<Integer> arr=new ArrayList<>();
    static int paper[][];
    static boolean visisted[][];
    static int n,m;
    static int width=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        paper=new int[n][m];
        visisted=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paper[i][j]=sc.nextInt();
            }
        }

        // logic
        int cnt=0;
        int max=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(paper[i][j]==1&&!visisted[i][j]) { // 종이에 그림이 있어야 하고 (1) && 방문하지 않았다면
                    dfs(i, j);
                    if(width!=0)
                    {
                        if(max<width)
                        {
                            max=width;
                        }
                        cnt++;
                    }
                    width=0;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
    static void dfs(int y,int x)
    {
        visisted[y][x]=true;
        width+=1;
        for (int i = 0; i < 4; i++) {
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny>=0 && nx >=0 && ny<n && nx<m) // outOfIndex
            {
                if(paper[ny][nx]==1&&!visisted[ny][nx])
                    dfs(ny,nx);
            }
        }
    }
}
