package Basic.sumOfIntervals;

import java.util.Scanner;
//https://www.acmicpc.net/submit/11441
public class FindingSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i]=sc.nextInt();
            arr[i]+=arr[i-1];
        }
        int t=sc.nextInt();
        while (t-->0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(arr[b]-arr[a-1]);
        }
    }
}
