package Al_Study.set0_APPENDIX_별찍기;

import java.util.Scanner;

public class Star_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int temp=n;
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <temp-1 ; j++) {
                System.out.print(" ");
            }
            temp--;

            for (int j = 0; j <2*i-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
