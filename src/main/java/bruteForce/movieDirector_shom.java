package bruteForce;

import java.util.Scanner;

public class movieDirector_shom {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int cnt=1;
        int num=666;
        while(cnt != n) {
            num++;

            // int형인 num을 String으로 변환한 뒤, "666"이란 문자열이 있는지 검사
            if(String.valueOf(num).contains("666")) {
                cnt++;
            }
        }
        System.out.println(num);
    }
}
