package Basic.Sorting.SortingPS;

import java.io.*;
import java.util.PriorityQueue;
//https://www.acmicpc.net/problem/1715
public class CardSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int val=Integer.parseInt(br.readLine());
            pq.offer(val);
        }
        int answer=0;
        while (pq.size()!=1)
        {
            Integer value1 = pq.poll();
            Integer value2 = pq.poll();
            int sum=value1+value2;
            answer+=sum ;
            pq.offer(sum);
        }
        System.out.println(answer);

    }
}
