package oneDay_twoSol.Greedy2.InBook.Deepening;

import java.util.Scanner;

public class Best_Choosing_BowlingBall {
    public static int n, m;
    // 1부터 10까지의 무게를 담을 수 있는 배열
    public static int[] arr = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[x] += 1;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            n-=arr[i]; // a가 i번째 공을 선택했을 때 나머지 공을 선택할 경우의 수가 n에 저장.
            result+=arr[i]*n;
        }
        System.out.println(result);

    }
}
