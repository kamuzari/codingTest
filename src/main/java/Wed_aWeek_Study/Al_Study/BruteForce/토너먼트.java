package Wed_aWeek_Study.Al_Study.BruteForce;

import java.util.Scanner;

public class 토너먼트 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");

        int n=Integer.parseInt(str[0]);
        int kim=Integer.parseInt(str[1]);
        int lim=Integer.parseInt(str[2]);

        int cnt=0;
        while (kim!=lim)
        {
            kim= (int) Math.round((double)kim/2);
            lim=(int)Math.round((double)lim/2);
            cnt++;
        }
        System.out.println(cnt);
        sc.close();

    }
}
