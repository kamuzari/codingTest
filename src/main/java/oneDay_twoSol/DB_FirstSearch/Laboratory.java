package oneDay_twoSol.DB_FirstSearch;

import java.util.Scanner;

public class Laboratory {
    // 모든 경우의 수를 전부 봐야한다 64C3 의 조합의 경우의 수 == 41,664 으로 완전탐색을 하는데 무리없다.
    static int n,m,middle_result;
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static int map[][];
    static int temp[][];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map=new int[n][m];
        temp=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        dfs(0);
        System.out.println(middle_result);


    }
    static void infection(int y,int x)
    {
        // dfs 전이.
        for (int i = 0; i <4 ; i++) {
            int tempY=y+dy[i];
            int tempX=x+dx[i];
            if(tempX>=0 && tempY>=0&& tempY<n && tempX<m)
            {
                if(temp[tempY][tempX]==0) {
                    temp[tempY][tempX] = 2;
                    infection(tempY,tempX);
                }
            }
        }
    }
    static int zeroCount()
    {
        int zero_cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(temp[i][j]==0)
                    zero_cnt++;
            }

        }
        return zero_cnt;
    }
    static void dfs(int cnt)  // cnt는 울타리의 개수.
    {
        if(cnt==3) // 울타리를 모두 세웠으면 전염 시켜서 전염을 최소 막을수 있는지 0을 하나하나세워보며 0을 최대가 되는 값을 구한다.
        {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j]=map[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(temp[i][j]==2)
                    {
                        infection(i,j);
                    }
                }
            }
            middle_result=Math.max(middle_result,zeroCount());
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0) // 벽도 아니고 전염되있는 구역이 아닌 빈공간이면 벽을 세워본다.
                {
                    map[i][j]=1;
                    cnt++;
                    dfs(cnt);
                    map[i][j]=0;
                    cnt--;
                }
            }
        }
    }
}
