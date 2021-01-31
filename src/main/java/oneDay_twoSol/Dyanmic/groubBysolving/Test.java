package oneDay_twoSol.Dyanmic.groubBysolving;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sequence[]=new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i]=sc.nextInt();
        }
        int sum = 0,max=0;
        for (int i = 0; i < n; i++) {
            sum+=sequence[i];
            if(sum>max)
            {
                max=sum;
            }
            else if(sum<0)
                sum=0;
        }
        System.out.println(max);

    }
}
