package oneDay_twoSol.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2437
public class TLE_Scale {
    static int n;
    static ArrayList<Integer> arr=new ArrayList<>();
    static boolean flag;
    static int target;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int sum=0;
        for (int i = 0; i <n ; i++) {
            arr.add(sc.nextInt());
            sum+=arr.get(i);
        }
        Collections.sort(arr);
//        System.out.println(arr);
        for (int i = 1; i <sum ; i++) {
            flag=false;
            target=i;
           dfs(0,0);
           if(!flag)
           {
               System.out.println(i);
               break;
           }
        }
    }
    static void dfs(int i, int sum)
    {
        if(i==n || flag==true)
        {
            return ;
        }
        if(sum+arr.get(i)==target)
        {
            flag=true;
            return;
        }
        if(i<n)
        {
            dfs(i+1,sum);
            dfs(i+1,sum+arr.get(i));
        }
    }

}
