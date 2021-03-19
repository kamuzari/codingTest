package Basic.CompleteSearch_BackTracking;

import java.util.Scanner;

public class LadderOperation {
    static int ladder[][];
    static int n,m,h;
    static final int LEFT=-1;
    static final int RIGHT=1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        h=sc.nextInt();
        ladder=new int[h][n];
        for (int i = 0; i < m; i++) {
            int y=sc.nextInt()-1;
            int x=sc.nextInt()-1;
            ladder[y][x]=RIGHT;
            ladder[y][x+1]=LEFT;
        }

        pick(0,0);
        if(min>3)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(min);
        }


    }
    static int min=1_000_000_000;
    static void pick(int cnt,int idx) {

        if (cnt > 3) {
            return;
        }
        if (cnt == 3 || idx >= h * n) {
            if(isvalid())
            {
                min=Math.min(min,cnt);
            }
            return;
        }
        int y = idx / n;
        int x = idx % n;

        if(x<n-1 && ladder[y][x]==0 && ladder[y][x+1]==0) {
            ladder[y][x]=RIGHT;
            ladder[y][x+1]=LEFT;
            pick(cnt + 1, idx + 2);
            ladder[y][x]=ladder[y][x+1]=0;
        }
        pick(cnt,idx+1);
    }
    static boolean isvalid()
    {
        for (int j  = 0; j <n ; j++) {
            int col=j;
            for (int i = 0; i <h ; i++) {
                if(ladder[i][col]==RIGHT)
                    col++;
                else if(ladder[i][col]==LEFT)
                    col--;
            }
            if(col!=j)
                return false;
        }
        return true;
    }
}
