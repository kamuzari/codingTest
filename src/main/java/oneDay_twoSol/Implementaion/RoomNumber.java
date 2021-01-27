package oneDay_twoSol.Implementaion;

import java.util.Scanner;

public class RoomNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split("");
        int len = str.length;
        int cnt = 0;
        int arr[] = new int[10];
        for (int i = 0; i < len; i++) {
            int idx = Integer.parseInt(str[i]);
            arr[idx]++; // 계수 정렬 처럼
        }
        int max=0;
        int index=0;
        for (int i = 0; i <arr.length ; i++) {
            if(i!=6 && i!=9)
                max=Math.max(arr[i],max);
        }
//        System.out.println(max);
        int ans=Math.max((int)Math.round((double)(arr[6]+arr[9])/2),max);

        System.out.println(ans);
    }

    }
