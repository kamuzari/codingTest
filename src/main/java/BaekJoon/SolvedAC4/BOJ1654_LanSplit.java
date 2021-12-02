package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654_LanSplit {

    /*
     * 결과물 := N개의 같은 길이의 랜선이 필요하다
     *
     */
    static int lanCable[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int currentLanCable = Integer.parseInt(st.nextToken());
        int needLenCable = Integer.parseInt(st.nextToken());
        lanCable = new int[currentLanCable];
        for (int i = 0; i < currentLanCable; i++) {
            lanCable[i] = Integer.parseInt(br.readLine());
        }
        long answer = parametricSearch(currentLanCable, needLenCable);
        System.out.println(answer);
    }

    private static long parametricSearch(int currentLanCable, int needLenCable) {
        long answer = 0;
        long start = 1;
        long end = extractMax();
        while (start <= end) {
            long mid = (start + end) >> 1;
            long splitResult = splitLanCable(mid);
            if (splitResult >= needLenCable) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    private static long splitLanCable(long target) {
        long answer = 0;
        for (int i = 0; i < lanCable.length; i++) {
            answer += (lanCable[i] / target);
        }
        return answer;
    }

    private static int extractMax() {
        return Arrays.stream(lanCable).max().orElseThrow(() -> new RuntimeException("error"));
    }

}
