package WeeklyThuseday.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class coinZero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<Integer> profit=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            profit.add(sc.nextInt() );
        }
        Collections.sort(profit);
        Collections.reverse(profit);
        int cnt=0;
        int i=0;
        while (k!=0)
        {
            int temp=profit.get(i);
            if(k/temp>0)
            {
                int rest=k/temp;
                cnt+=rest;
                k-=temp*rest;
            }
            i++;
        }
        System.out.println(cnt);
    }
}
