package Wed_aWeek_Study.Al_Study.기초수학2;

import java.util.Scanner;
// 앞자리가 9일 때는 자리수가 증가해야하는 경우를 생각.

public class 반올림 {
    static int arr[]={10,100,1000,10000,100000,1000000,10000000,100000000};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            int k=Integer.parseInt(sc.nextLine());
            int temp=0;
            for (int i = 0; i <arr.length ; i++) {
                if(arr[i]<k)
                {
                    temp=k%arr[i];// 자리수,
                    k-=temp;
                    float t=(float)temp/arr[i];
                    temp=Math.round(t)*arr[i];
                    k+=temp;
                }
                else
                {
                    System.out.println(k);
                    break;
                }
            }
        }
    }

}
