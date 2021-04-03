package codingExam.TestSE.스코페;

import java.util.Scanner;

public class two {
    static int n, arr[], visited[];
    static int oneCnt = -1;
    static int oneFirst = -1;
    static int oneLast;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new int[n];
        sc.nextLine();
        oneCnt = 0;
        String str[] = sc.nextLine().split("");
        for (int i = 0; i < n; i++) {
            int i1 = Integer.parseInt(str[i]);
            if (i1 == 1)
                oneCnt++;
            if (oneFirst == -1 && oneCnt != 0)
                oneFirst = i;
            if (i1 != 0)
                oneLast = i;

            arr[i] = i1;
        }
//        System.out.println(oneFirst);
//        System.out.println(oneLast);
        pick(0, oneFirst);
        System.out.println(CNT);
    }

    static int CNT = 0;

    static void pick(int cnt, int idx) {

        if (idx == oneLast) {
            CNT++;
            return;
        }
        //11001
        for (int i = idx; i < n; i++) {
            if (cnt == 0 && i != oneFirst)
                return;
            if (arr[i] == 1 && visited[i] == 0 && Math.abs(idx - i) <= 2) {
                visited[i] = 1;
                pick(cnt + 1, i);
                visited[i] = 0;
            }

        }
    }
}

//3
//        100
//        1

// 반례 0이여야 함.
/*
3
11001
*/