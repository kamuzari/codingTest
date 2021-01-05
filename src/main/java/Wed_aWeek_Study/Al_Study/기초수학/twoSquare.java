package Wed_aWeek_Study.Al_Study.기초수학;

import java.util.Scanner;

public class twoSquare {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double d=(double) n;
        boolean flag=false;
        while (d!=1)
        {
            d=d/2;
            if(d==(int)d)
                flag=true;
            else
            {
                flag=false;
                break;
            }
        }
        if(d==1)
            System.out.println("1");
        else if(!flag)
            System.out.println("0");
    }
}
