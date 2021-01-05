package Alone.bruteForce;

import java.util.Scanner;

public class divideSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // 가장 작은 생성자  구하기
        // ex 256 -> 245+(2+4+5)
        int n=sc.nextInt();
        System.out.println(newSearch(n));

    }
    public static int newSearch(int n)
    {
        int ans=0;

        int sum=0; //생성자 확인용 변수

        for (int i = 0; i <n ; i++) {
            String str=Integer.toString(i);
            String s[]=str.split("");
            // 자리수 꺼내기

            sum=i; // orginal value

            for (int j = 0; j <s.length ; j++) {
                sum+=Integer.parseInt(s[j]);
            }
            if(sum==n)
            {
                ans=i;
                break;
            }
            sum=0;
        }
        return ans;
    }
}
