package oneDay_twoSol.Greedy2.InBook.Deepening;

import java.util.Scanner;

public class multiplicationAndPlue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split("");
        int len=str.length;
        int arr[]=new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        long ans=0;
        int a=arr[0]*arr[1];
        int b=arr[0]+arr[1];
        ans+= Math.max(a, b);
        for (int i = 2; i < len; i++) {
            long tempA=ans+arr[i];
            long tempB=ans*arr[i];
            ans= Math.max(tempA, tempB);
        }
        System.out.println(ans);
    }
}
