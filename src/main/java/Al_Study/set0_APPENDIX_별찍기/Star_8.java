package Al_Study.set0_APPENDIX_별찍기;

import java.util.Scanner;

public class Star_8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        n=2*n-1;
//        int n=n;
        for (int i = 1; i <=n/2 ; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j <= n - 2 * i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
        }
        for (int i = n/2+1; i >=0 ; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j <= n - 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

}
