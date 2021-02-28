package oneDay_twoSol.Implementation2.Group;

import java.util.Scanner;

public class Date {
    public static void main(String[] args) {
        int e,s,m;
        Scanner sc=new Scanner(System.in);
        e=sc.nextInt();
        s=sc.nextInt();
        m=sc.nextInt();
        int y=1;
        while (true) {
            if((y-e)%15==0 && (y-s)%28==0 && (y-m)%19==0)
            {
                System.out.println(y);
                break;
            }
            y++;
        }

    }
}
