package WeeklyThuseday.Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드합체놀이 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        int n=Integer.parseInt(str[0]); // 카드의 개수
        int m=Integer.parseInt(str[1]); // 합체하는 수의 제한.
        PriorityQueue <Long> pq=new PriorityQueue<>();
        long arr[][]=new long[n][2];
        String str2[]=sc.nextLine().split(" ");
        for (int i = 0; i <n ; i++) {
            pq.add(parse(str2[i]));
//            System.out.println(Arrays.toString(arr[i]));
        }


        //logic - 가장 작은 수를 두개를 뽑아서 더하고 OverWrite
        // 4 2 3 1 -> 4 3 3 3 -> 4 3 6 6 ==>

        // 합체는 m번 수행.
        while (m-->0)
        {
            long x=pq.poll(); long y=pq.poll();
            long sum=x+y;
            x=sum;
            y=sum;
            pq.add(x); pq.add(y);
        }
        long ans=0;
        while (!pq.isEmpty())
        {
            ans+=pq.poll();
        }
        System.out.println(ans);
    }

    public static Long parse(String str)
    {
        return Long.parseLong(str);
    }

}
