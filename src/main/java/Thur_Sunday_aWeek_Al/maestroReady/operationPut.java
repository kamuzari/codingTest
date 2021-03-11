package Thur_Sunday_aWeek_Al.maestroReady;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class operationPut {
    static int n,op[],arr[];
    static ArrayList<Integer> operationValue=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        op=new int[4];
        for (int i = 0; i < 4; i++) {
            op[i]=sc.nextInt();
        }
            dfs(1,arr[0]);
        Collections.sort(operationValue);
        System.out.println(operationValue.get(operationValue.size()-1));
        System.out.println(operationValue.get(0));

    }
    static void dfs(int cnt,int sum)
    {
        for (int i = 0; i < 4; i++) {
            if(op[i]!=0)
            {
                --op[i];
                switch (i)
                {
                    case 0:
                        dfs(cnt+1,sum+arr[cnt]);
                        break;
                    case 1:
                        dfs(cnt+1,sum-arr[cnt]);
                        break;
                    case 2:
                        dfs(cnt+1,sum*arr[cnt]);
                        break;
                    case 3:
                        dfs(cnt+1,sum/arr[cnt]);
                        break;
                }
                ++op[i];
            }
        }
        if(cnt==n)
        {
            operationValue.add(sum);
            return;
        }
    }
}
