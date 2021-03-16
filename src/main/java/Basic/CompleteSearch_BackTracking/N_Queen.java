package Basic.CompleteSearch_BackTracking;

import java.util.Scanner;

public class N_Queen {
    static int n;
    static int arr[];
    // idx - 각 행 val - 격 열의 위치한 값.
    // 공격하지 못하는 수 행은 상관이 없고 같은 열 또는 대각선의 위치가 다르면 된다.(idx-idx2)!=(val-val2)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[0]=i;
            Pick(1);
        }
        System.out.println(count);
        
    }
    static int count=0;
    static void Pick(int cnt)
    {
        if(cnt==n)
        {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[cnt]=i;
            if(promising(cnt))
            {
                Pick(cnt+1);
            }
        }
    }

    private static boolean promising(int cnt) {
        for (int i = 0; i < cnt; i++) {
            if(arr[cnt]==arr[i])
                return false;
            if(Math.abs(cnt-i)==Math.abs(arr[i]-arr[cnt]))
                return false;
        }
        return true;
    }
}
