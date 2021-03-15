package oneDay_twoSol.BackTracking;

import java.util.Scanner;

public class N_and_M {
    static int n, m;

    static boolean visited[]; // 방문 체크
    static int arr[]; // 뽑은 숫자 넣기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        arr = new int[n];
        visited = new boolean[n];
        // Logic
        go(0); // cnt는 뽑은 개수.
    }
    //순열!
    // 재귀적으로 함수가 시작되면서 깊이를 증가시키고 다시 돌아와 for문을 돌면서 하나 뽑은 숫자 뒤에 하나 더 뽑으며 깊이와 우리가 뽑아야할 m개와 같아진다면 모두 선택한 것이다.
    static void go(int depth) {
        if (depth == m) {
            for (int k : arr) {
                if (k != 0)
                    System.out.print(k + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                go(depth + 1);
                visited[i] = false;
            }
        }
    }



}
