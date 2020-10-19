package Recursion;

import java.util.Scanner;

public class starStamp {
    static StringBuilder sb=new StringBuilder();
    /*
    작은 별찍기 기준 1,1 의 대하여 공백을 출력하는 것을 인지한 후
    입력이 9였을 경우. 작은 별찍기 9개 기준 1,1이 공백이다.
    재귀는 점화식을 만들어 놓으면 코드로 옮기기 쉽다.
        점화식의 규칙을 찾는 연습이 필요하다.
      */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        stamp(n);
        System.out.println(sb.toString());
    }
    public static void stamp(int n)
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                star(i,j);
            }
            sb.append("\n");
//            System.out.println();
        }
    }
    public static void star(int x,int y)
    {
        while (true)
        {
            if(x==0)
                break;
            if(x%3==1 && y%3==1) {
//                System.out.print(" ");
                sb.append(" ");
                return;
            }
            x/=3;
            y/=3;
        }
        sb.append("*");
//        System.out.print("*");
    }
}
