package oneDay_twoSol.Dyanmic.Inbook;

import java.util.Scanner;

public class integerTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int triangle[][]=new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            String str[]=sc.nextLine().split(" ");
            for (int j = 1; j < str.length+1; j++) {
                triangle[i][j]=Integer.parseInt(str[j-1]);
            }
        }
//        for (int i = 0; i < n+1; i++) {
//            System.out.println(Arrays.toString(triangle[i]));
//        }
        for (int i = n-1; i >0 ; i--) {
            for (int j = 1; j <n ; j++) {
                triangle[i][j]=triangle[i][j]+Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
//        System.out.println("===============");
//        for (int i = 0; i < n+1; i++) {
//            System.out.println(Arrays.toString(triangle[i]));
//        }
        System.out.println(triangle[1][1]);


    }
}
