package oneDay_twoSol.RealTimeSolving;

import java.util.Arrays;
import java.util.Scanner;

public class RGB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int house[][]=new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                house[i][j]=sc.nextInt();
            }
        }
        int d[][]=new int[n][3];
        for (int i = 0; i <3 ; i++) {
            d[0][i]=house[0][i];
        }

        for(int i=1;i<n;i++){
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + house[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + house[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + house[i][2];
        }
        for (int i = 0; i < n; i++) {
            System.out.println(  Arrays.toString(d[i]));
        }
        System.out.println(Math.min(Math.min(d[n-1][0],d[n-1][1]),d[n-1][2]));

    }
}
