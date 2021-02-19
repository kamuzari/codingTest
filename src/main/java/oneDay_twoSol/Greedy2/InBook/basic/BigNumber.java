package oneDay_twoSol.Greedy2.InBook.basic;

import java.util.Arrays;
import java.util.Scanner;

public class BigNumber {
    static int arr[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt(); // 배열의 값 개수
        arr=new int[n];
        int m=sc.nextInt(); // 연산횐수
        int k=sc.nextInt(); // 연속제한 횟수

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int first=arr[n-1];
        int second=arr[n-2];
        int cnt=0;
        int ans=0;
        int criteria=first;
        while (m-->0)
        {
            if(cnt==k)
            {
                criteria=second;
                ans+=criteria;
                criteria=first;
                cnt=0;
                continue;
            }
            ans+=criteria;
            cnt++;
        }

        System.out.println(ans);


    }
}
/*
5 8 3
2 4 5 4 6
* */