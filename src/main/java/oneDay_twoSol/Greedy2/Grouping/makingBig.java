package oneDay_twoSol.Greedy2.Grouping;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class makingBig {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        char ch[]=str.toCharArray();
        Deque<Integer> dq=new LinkedList<>();
        dq.offer(ch[0]-'0');
        for (int i = 1; i < ch.length; i++) {
            while (k>0 && !dq.isEmpty() && dq.getLast() <ch[i]-'0')
            {
                dq.removeLast();
                k--;
            }
            dq.add(ch[i]-'0');
        }
        StringBuilder sb=new StringBuilder();
        while (dq.size()>k)
        {
            sb.append(dq.removeFirst());
        }
        System.out.println(sb);





    }
}
// 897321
