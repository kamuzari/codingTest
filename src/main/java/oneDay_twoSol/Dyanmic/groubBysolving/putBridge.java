package oneDay_twoSol.Dyanmic.groubBysolving;

import java.util.Scanner;

public class putBridge {
    static int west[],east[];
    static int n,m;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();

        while (T-->0)
        {
            cnt=0;
            n=sc.nextInt(); // west
            m=sc.nextInt(); // east
//            combination(m,n,0);
            int pascal[][]=new int[m+1][m+1];
            for (int i = 0; i <m+1 ; i++) {
                for (int j = 0; j <i+1 ; j++) {
                    if(j==0 || i==j)
                        pascal[i][j]=1;
                    else
                    {
                        pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
                    }
                }
            }
            System.out.println(pascal[m][n]);
            /*
            1
            1 1
            1 2 1
            1 3 3 1
            */
        }
    }
    static void combination(int n,int r,int idx)
    {
        if(r==0)
        {
            cnt++;
            return;
        }
        for (int i = idx; i <m; i++) {
            combination(n,r-1,i+1);
        }
    }


}
