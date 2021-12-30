package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ22254_ProcessConsultantHooSeuk {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int limetedTime = Integer.parseInt(st.nextToken());
        Integer runtimes[] = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            runtimes[i] = Integer.parseInt(st.nextToken());
        }
        int answer = possibleK(runtimes, n, limetedTime);
        System.out.println(answer);
    }

    public static int possibleK(Integer[] runtimes, int n, int limitedTime) {
        int possibleProcessNumber = n;
        int s = 1;
        int e = n-1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (isPossibleK(mid, runtimes, limitedTime)) {
                possibleProcessNumber = Math.min(possibleProcessNumber, mid);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return possibleProcessNumber;
    }

    private static boolean isPossibleK(int mid, Integer[] runtimes, int limitedTime) {

        PriorityQueue<Integer> factories = new PriorityQueue<>();
        for (int i = 0; i < mid; i++) {
            factories.offer(0);
        }
        for (int i = 0; i < runtimes.length; i++) {
            Integer runtime = runtimes[i];
            Integer curFactory = factories.poll();
            int endTime = curFactory + runtime;
            factories.offer(endTime);
        }
        int endMaxTime = 0;
        while (!factories.isEmpty()) {
            Integer endTime = factories.poll();
            endMaxTime = Math.max(endMaxTime, endTime);
        }
        return endMaxTime <= limitedTime;
    }

}
