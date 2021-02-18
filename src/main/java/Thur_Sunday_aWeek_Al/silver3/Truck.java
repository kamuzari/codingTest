package Thur_Sunday_aWeek_Al.silver3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Truck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        int l=sc.nextInt();
        Queue<Integer> bridge=new LinkedList<>();
        int truck[]=new int[n];
        for (int i = 0; i < n; i++) {
            truck[i]=sc.nextInt();
        }
        int curWeight=0;
        int cnt=0;
        for (int i = 0; i < n; i++) {
            while (true)
            {
                if(bridge.size()==w)
                    curWeight-=bridge.poll();
                if(curWeight+truck[i]<=l)
                    break;
                bridge.add(0);
                cnt++;
            }
            bridge.add(truck[i]);
            curWeight+=truck[i];
            cnt++;

        }
        System.out.println(cnt+w);
    }
}
// 7 4 5 6 | 1 2 3| 3| 4| 5| 6| 6| 7| 8|