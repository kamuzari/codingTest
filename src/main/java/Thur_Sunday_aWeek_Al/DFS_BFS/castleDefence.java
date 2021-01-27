package Thur_Sunday_aWeek_Al.DFS_BFS;

import java.util.Scanner;

public class castleDefence {
    static int n,m,d;
    static boolean visited[][];
    static boolean board[][];
    static int dx[]={1,-1,0,0,-1,1,1,-1};
    static int dy[]={0,0,-1,1,-1,1,-1,1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        d=sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                int input=sc.nextInt();
                if(input==1)
                {
                    board[i][j]=true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                if(!visited[i][j])
                {
                    dfs(i,j);
                }
            }
        }




    }
    public static void dfs(int x,int y) // 행 렬
    {
        visited[x][y]=true;

        for (int i = 0; i <8 ; i++) {
            int tempX=x+dx[i];
            int tempY=y+dy[i];
            if(tempX>=0 && tempX<n && tempY>=0 && tempY<n && !visited[tempX][tempY])
            {

                // true 이면 적이 잇는거다
                if(!board[x][y])
                {
                    dfs(tempX,tempY);
                }
                else {
                    for (int j = 0; j <d ; j++) {
                        for (int k = 0; k <8 ; k++) {

                        }
                    }
                }
            }
        }
    }
}
