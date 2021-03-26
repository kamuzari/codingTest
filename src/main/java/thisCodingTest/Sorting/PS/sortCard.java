package thisCodingTest.Sorting.PS;

import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1715
public class sortCard {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        PriorityQueue <Integer> pq=new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
            pq.add(arr[i]);
        }
        // 그 뒤에도 정렬.
        int sum=0;
        int ans=0;
        while (pq.size()>1)
        {
            int a=pq.poll();
            int b=pq.poll();
            sum=a+b;
            ans+=sum;
            pq.offer(sum);
        }
        if(ans==0)
        {
            System.out.println(sum);
        }
        else
            System.out.println(ans);

    }
}
