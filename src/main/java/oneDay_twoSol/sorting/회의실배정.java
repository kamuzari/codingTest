package oneDay_twoSol.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class 회의실배정 {
    static int max = 0;
    static int cnt = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        room arr[] = new room[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[] = sc.nextLine().split(" ");
            int s = Parse(str[0]);
            int e = Parse(str[1]);
            arr[i] = new room(s, e);
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].start + " " + arr[i].end);
        }
        cnt = 0;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i].start >= end) // 끝나는 시간에 바로 시작할 수 있음.
            {
                end = arr[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }


    static class room implements Comparable<room> {
        private int start;
        private int end;

        public room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(room o) {
            // 끝나는 시간을 기준으로 정렬하는데 있어 오름차순으로 정렬하고
            // 첫번째 수에서 작은 내림차순으로 하여 빨리 시작하고 빨리 끝나는 것들만 선택하는 것이다.
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static int Parse(String str) {
        return Integer.parseInt(str);
    }
}
