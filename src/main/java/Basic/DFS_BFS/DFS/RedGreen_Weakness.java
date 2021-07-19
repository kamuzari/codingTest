package Basic.DFS_BFS.DFS;

import java.util.Scanner;

public class RedGreen_Weakness {
    static int n;
    static int map[][];
    static boolean visisted[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0 ,- 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        map=new int[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[]=sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                char ch=str[j].charAt(0);
                if(ch=='R')
                {
                    map[i][j]=1;
                }
                else if(ch=='B')
                {
                    map[i][j]=0;
                }
                else
                {
                    map[i][j]=-1;
                }
            }
        }

        int cnt=0;
        for (int k = 0; k < 2; k++) {
            visisted=new boolean[n][n];
            if(k==1)
            {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(map[i][j]==-1)
                        {
                            map[i][j]=1;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visisted[i][j])
                    {
                        DFS(i,j,map[i][j]);
                        cnt++;
                    }
                }
            }
            System.out.print(cnt+" ");
            cnt=0;
        }

    }
    static void DFS(int y,int x,int criteria)
    {
        visisted[y][x]=true;
        for (int i = 0; i < 4; i++) {
           int ny=dy[i]+y;
           int nx=dx[i]+x;
           if(ny>=0 && nx>=0 && ny<n && nx<n && !visisted[ny][nx])
           {
                if(map[ny][nx]==criteria)
                {
                    DFS(ny,nx,criteria);
                }
           }
        }
    }

}
