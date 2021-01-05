package Wed_aWeek_Study.Al_Study.기초수학3;

import java.util.Arrays;
import java.util.Scanner;

public class 가로수 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int gap[]=new int[n-1];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
            if(i>0)
            {
                gap[i-1]= (arr[i]-arr[i-1]);
            }
        }
        System.out.println(Arrays.toString(gap));

        // 최종 간격 == 최대공약수.
        for (int i = 0; i <gap.length-1; i++) {
            gap[i+1]=gcd(gap[i],gap[i+1]);
        }
        System.out.println(Arrays.toString(gap));
        int diff = gap[gap.length - 1];
        System.out.println((arr[n - 1] - arr[0])/diff-(n-1));
    }

    public static int gcd(int a,int b)
    {
        while(b>0)
        {
            int temp=a;
            a=b;
            b=temp%b;
        }
        return a;
    }
}
