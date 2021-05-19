package WeeklyThuseday.silver2;

import java.util.Scanner;

public class travelOfSANGGEUN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while (T-->0)
        {
            int ans=0;
            int n=sc.nextInt();
            int m=sc.nextInt();
            for (int i = 0; i < m; i++) {
                sc.nextInt();
                sc.nextInt();
            }
            System.out.println(n-1);
        }
    }
}
