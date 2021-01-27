package Wed_aWeek_Study.Al_Study.기초수학;

import java.util.Scanner;

public class 욱제 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long A=sc.nextLong();
        long B=sc.nextLong();
        double M=(double)(B-A)/400;
        System.out.printf("%.6f",1/(1+Math.pow(10,M)));
    }
}
