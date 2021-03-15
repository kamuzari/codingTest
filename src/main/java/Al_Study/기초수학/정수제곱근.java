package Al_Study.기초수학;

import java.util.Scanner;

public class 정수제곱근 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       long n=sc.nextLong();
        System.out.println((long) Math.ceil(Math.sqrt(n)));
    }
}
