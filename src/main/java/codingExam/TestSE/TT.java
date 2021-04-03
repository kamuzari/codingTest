package codingExam.TestSE;

import java.util.Scanner;

public class TT {
    static int pan[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pan = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pan[i] = sc.nextInt();
        }
        int arr[] = new int[100001];
        for (int i = 0; i < n; i++) {
            arr[i] = i + pan[i];
        }
        int q=-1;
        boolean check[]=new boolean[n];
        for (int i = 0; i < n; i++) {
            int cur=i;
            int next=arr[i];

            int temp=0;
            while (cur<next && !check[cur])
            {
                check[cur]=true;
                temp+=1;
                cur=arr[i];
                next=arr[cur];
            }
            q=Math.max(q,temp);
        }
        System.out.println(q+1);
    }
}
