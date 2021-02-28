package oneDay_twoSol.Implementation2.Group;

import java.util.Scanner;

public class digitsSequenceWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        int number=Integer.parseInt(str);
        int res = 0;
        int num = 9;
        for (int i = 1; i < n; i++) {
            res += i * num;
            num *= 10;
        }
        int Last = ( int)(number-Math.pow(10,n-1)+1)*n;
        res+=Last;
        System.out.println(res);

    }
}
