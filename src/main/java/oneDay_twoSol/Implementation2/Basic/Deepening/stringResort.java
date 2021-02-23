package oneDay_twoSol.Implementation2.Basic.Deepening;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 페이스북 (문자열 재정렬)
public class stringResort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split("");
        Arrays.sort(str, Comparator.reverseOrder());
        System.out.println(Arrays.toString(str));
        int sum = 0;
        int idx = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            int a = str[i].charAt(0) - '0';
            if (a >= 10) {
                idx=i+1;
                break;
            } else
                sum += a;
        }
        Arrays.sort(str,0,idx);
        for (int i = 0; i < idx; i++) {
            System.out.print(str[i]);
        }
        System.out.print(sum);
    }
}
/*
K1KA5CB7
AJKDLSI412K4JSJ9D
* */