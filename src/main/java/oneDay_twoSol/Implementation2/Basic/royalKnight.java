package oneDay_twoSol.Implementation2.Basic;

import java.util.Scanner;

public class royalKnight {
    static int board[][] = new int[8][8];
    static int dy[] = {-1, 1, -1, 1, -2, -2, 2, 2};
    static int dx[] = {-2, -2, 2, 2, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split("");
        int a=(str[0].charAt(0)-'0'-49);
        int b=Integer.parseInt(str[1])-1;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        int cnt=0;
        for (int i = 0; i < 8; i++) {

            int ny=b+dy[i];
            int nx=a+dx[i];
            if(ny>=0 && ny<8 && nx>=0 && nx<8)
            {
                cnt++;
            }
        }
        System.out.println("cnt = " + cnt);
    }
}
