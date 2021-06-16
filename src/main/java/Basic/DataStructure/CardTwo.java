package Basic.DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CardTwo {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Queue<Integer> q=new LinkedList<Integer>();

        int n=sc.nextInt();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int i=1;
        while(q.size()!=1)
        {
            if(i%2==1)
            {
                q.poll();
                i++;
            }
            else
            {
                q.add(q.poll());
                i++;
            }
        }

        System.out.println(q.peek());
    }
}