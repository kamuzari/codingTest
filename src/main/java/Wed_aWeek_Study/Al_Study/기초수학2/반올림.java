package Wed_aWeek_Study.Al_Study.기초수학2;

import java.util.Scanner;
// 앞자리가 9일 때는 자리수가 증가해야하는 경우를 생각.

public class 반올림 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String str[] = sc.nextLine().split("");
           // System.out.println(str.length);
            int k = Integer.parseInt(str[0]);
            boolean check;
            // 1자리수.
            if(str.length==1) { // 1자릿수
                check = roundCheck(k);
                if (check) {
                    System.out.println(10);
                } else {
                    System.out.println(k);
                }
            }
            else{
                // 맨 앞의자리를 반올림했을때 10이면.올림처리 유의
            }
        }
    }

    public static boolean roundCheck(int t) {
        if (t > 5) {
            return true;
        }
        return false;
    }
}
