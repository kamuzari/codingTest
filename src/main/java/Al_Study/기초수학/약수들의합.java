package Al_Study.기초수학;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 약수들의합 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        ArrayList<Integer> arr=new ArrayList<>();
        do {
            n=sc.nextInt();
            for (int i = 1; i <=n ; i++) {
                if(n%i==0)
                    arr.add(i);
            }
            int sum=0;
            for (int i = 0; i <arr.size()-1 ; i++) {
                sum+=arr.get(i);
            }

           if(sum==n) {
               System.out.print(n + " = ");
               for (int i = 0; i <arr.size()-1 ; i++) {
                   if(i==arr.size()-2)
                   {
                       System.out.print(arr.get(i));
                   }
                   else {
                       System.out.print(arr.get(i)+" + ");
                   }
               }
           }
           else if(n!=-1)
           {
               System.out.print(n+" is NOT perfect.");
           }
            System.out.println();
            arr.clear();
        }
        while(n!=-1);
    }
}
