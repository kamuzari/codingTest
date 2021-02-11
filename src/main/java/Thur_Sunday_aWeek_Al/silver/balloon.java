package Thur_Sunday_aWeek_Al.silver;

import java.util.Scanner;

public class balloon {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[1000001];
        int cnt=0;
        for(int i=0;i<n;i++){
//            System.out.println(Arrays.toString(arr));
            int in=sc.nextInt();
            if(arr[in+1]==0){
                arr[in]++;
                cnt++;
                continue;
            }
            arr[in+1]--;
            arr[in]++;
        }
        System.out.println(cnt);
    }
}
