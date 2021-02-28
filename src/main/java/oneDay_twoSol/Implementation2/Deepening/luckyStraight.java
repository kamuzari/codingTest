package oneDay_twoSol.Implementation2.Deepening;

import java.util.Scanner;

public class luckyStraight {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split("");
        int len=str.length;
        int sum=0;
        for (int i = 0; i <len/2; i++) {
            sum += Integer.parseInt(str[i]);
        }
        for (int i = len/2; i < len; i++) {
            sum -= Integer.parseInt(str[i]);
        }
        if(sum==0)
        {
            System.out.println("LUCKY");
        }
        else
        {
            System.out.println("READY");
        }

    }
}
