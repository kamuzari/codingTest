package oneDay_twoSol.Greedy2.InBook.Deepening;

import java.util.Arrays;
import java.util.Scanner;

public class Choosing_BowlingBall {
    static int arr[];
    static int n;
    static int temp[];

    // 서도 다른 무게를 가지게 선택하는 경우의 수.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        temp = new int[2];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        comb(0, 0);

        System.out.println(cnt);
    }
/*
5 3
1 3 2 3 2

8 5
1 5 4 3 2 4 5 2
*/
    static int cnt=0;
    public static void comb(int depth, int idx) {
        if (depth == 2) {
//            System.out.println(Arrays.toString(temp));
            cnt++;
            return;
        }
        for (int i = idx; i < n; i++) {
            if (depth != 0) {
                if(temp[depth-1]==arr[i])
                    continue;
                else
                    temp[depth]=arr[i];
            } else {
                temp[depth] = arr[i];
            }
            comb(depth + 1, i + 1);
        }
    }
}
