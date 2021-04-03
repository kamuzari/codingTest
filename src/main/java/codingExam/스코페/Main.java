package codingExam.스코페;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long n = sc.nextInt();
            long m = sc.nextLong();
          /*
          n과 m의 보유 자산 골고루 써본다
          n>=5 m>=7
          else
            n이 5개 이상 있고 m
          * */
            long cnt = 0;
            long ans = n / 5;
            long ans2 = (n + m) / 12;
            cnt = ans <= ans2 ? ans : ans2;
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
