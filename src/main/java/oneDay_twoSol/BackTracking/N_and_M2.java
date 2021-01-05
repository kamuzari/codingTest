package oneDay_twoSol.BackTracking;

import java.util.Scanner;

public class N_and_M2 {

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
        go2(0); // cnt는 뽑은 개수.
    }

/*
1 2
1 3
1 4
2 3
2 4
3 4

***** 앞에있는 숫자가 뒤에있는 숫자보다 가장 작은 핵심이다.!
*/
    //조합
    // 순서가 없 중복 없는 순열
    static void go2(int depth) {
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
                if(depth==0)
                    go2(depth+1);
                if(depth>0 && arr[depth]>arr[depth-1]) // 뽑은 숫자중에 먼저 뽑안던 숫자보다는 커야한다!.
                     go2(depth + 1);
                visited[i] = false;
            }
        }
    }

}
