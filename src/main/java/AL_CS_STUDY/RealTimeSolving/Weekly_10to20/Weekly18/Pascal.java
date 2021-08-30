package AL_CS_STUDY.RealTimeSolving.Weekly_10to20.Weekly18;

import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb=new StringBuilder();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    }
                }
            }
            sb.append("#"+test_case).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j]==0)
                        break;
                   sb.append(arr[i][j]+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
