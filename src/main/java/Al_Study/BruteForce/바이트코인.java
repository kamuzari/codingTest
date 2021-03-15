package Al_Study.BruteForce;

import java.util.*;

public class 바이트코인 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        Long n = transInt(str[0]);
        Long w = transInt(str[1]);
        // 오르기 전의 최소값을 가져가는 것이 메인.
        Long arr[] = new Long[16];
        for (int i = 1; i <=n; i++) {
            arr[i] = sc.nextLong();
        }
        long coin=0;
        for (int i = 1; i <n ; i++) {
            if (arr[i] < arr[i + 1])
            {
                coin=w/arr[i];
                w%=arr[i];
                w+=coin*arr[i+1];
                coin=0;
            }
        }
        System.out.println(w);
    }

    static Long transInt(String str) {
        return Long.parseLong(str);
    }
}
