package Basic.CompleteSearch_BackTracking;

import java.util.Scanner;

public class ManipulationLadder {
    static int n, m, h;
    static int map[][];
    static int min=(int)1e9;
    static final int LEFT=1;
    static final int RIGHT=-1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        map = new int[h][n];
        for (int i = 0; i < m; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            map[y][x] = RIGHT;
            map[y][x + 1] = LEFT;
        }
        pick(0,0);
        if(min==(int)1e9)
        {
            System.out.println(-1);
        }
        else
            System.out.println(min);

    }
    static void pick(int cnt,int idx)
    {
        if(cnt ==3 || idx>=h*n)
        {
            if(isTrue())
            {
               min= Math.min(min,cnt);
            }
            return ;
        }

        int r=idx/n;
        int c=idx%n;
        if(c!=n-1 && map[r][c]==0 && map[r][c+1]==0)
        {
            map[r][c]=-1;
            map[r][c+1]=1;
            pick(cnt+1,idx+2); //pick
            map[r][c] =map[r][c+1]=0;
        }
        pick(cnt,idx+1); // nonPick
    }
    static boolean isTrue()
    {
        for (int i = 0; i <n ; i++) {
            int r=0; int c=i;
            do {
               if(map[r][c]== LEFT)
               {
                   c--;
               }
               else if(map[r][c]==RIGHT)
               {
                   c++;
               }
               r++;
           }while (r!=h);
               if(c!=i)
               {
                   return false;
               }
        }
        return true;
    }
}
