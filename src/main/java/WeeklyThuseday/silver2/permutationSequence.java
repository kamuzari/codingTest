package WeeklyThuseday.silver2;

import java.util.Arrays;
import java.util.Scanner;

public class permutationSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int option = sc.nextInt();
        long fact[] = new long[21];
        boolean visited[] = new boolean[21];
        Arrays.fill(fact, 1);
        for (int i = 1; i < 21; i++) {
            fact[i] = fact[i - 1] * i;
        }
        int tmp[] = new int[n];
        if (option == 1) {
            // k번째 순열 찾기
            long k = sc.nextLong();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (!visited[j]) {
                        if (fact[n - 1 - i] < k) {
                            k -= fact[n - i - 1];
                        } else {
                            tmp[i] = j;
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(tmp[i] + " ");
            }
        } else {
            // 그 수 가 몇번째인지 찾기
            for (int i = 0; i < n; i++) {
                tmp[i] = sc.nextInt();
            }
            long ans = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < tmp[i]; j++) {
                    if(visited[i])
                        continue;
                    if (!visited[j]) {
                        ans += fact[n - i - 1];
                    }
                    visited[tmp[i]] = true;
                }
            }
            System.out.println(ans);
        }
    }

}
