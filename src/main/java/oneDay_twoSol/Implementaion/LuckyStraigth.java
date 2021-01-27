package oneDay_twoSol.Implementaion;

import java.util.Scanner;

public class LuckyStraigth {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split("");
        int len=str.length;
        int arr[]=new int[len];
        for (int i = 0; i <len ; i++) {
            arr[i]=parse(str[i]);
        }
//        System.out.println(Arrays.toString(arr));
//        logic
        int m=len/2;
        int left_sum=0;
        for (int i = 0; i <m ; i++) {
            left_sum+=arr[i];
        }
        int right_sum=0;
        for (int i = m; i < len; i++) {
            right_sum+=arr[i];
        }
        if(left_sum==right_sum)
        {
            System.out.println("LUCKY");
        }
        else
        {
            System.out.println("READY");
        }
    }
    static int parse(String str)
    {
        return Integer.parseInt(str);
    }
}
