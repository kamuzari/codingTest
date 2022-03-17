package BaekJoon.SolvedAC4.NAndM_Series;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NAndM2 {

    private static int n;
    private static int m;
    private static int[] arr;
    private static StringBuilder answers = new StringBuilder();
    private static Set<Set<Integer>> sets = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
//        pick(0, m, new LinkedHashSet<>());
        pick2(1, m, 0, new LinkedHashSet<>());
        System.out.println(answers);
    }

    private static void pick(int depth, int targetDepth, Set<Integer> results) {
        if (depth == targetDepth) {
            for (Set<Integer> set : sets) {
                if (set.containsAll(results)) {
                    return;
                }
            }
            sets.add(new HashSet<>(results));
            for (Integer result : results) {
                answers.append(result + " ");
            }
            answers.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            int pickValue = arr[i];
            if (results.contains(pickValue)) {
                continue;
            }
            results.add(pickValue);
            pick(depth + 1, targetDepth, results);
            results.remove(pickValue);
        }
    }

    /**
      *todo : 메모리 줄이기
     * result : 배열 메모리 따로 생성 x, 시간 감소 (결과 값 중복체크 이중 hashSet 로직을 제외함)
     * reason : 이중 해쉬 로직 지운 이유 := 순열이 아닌 조합으로 로직 변경 (메소드 매개변수 추가)
      */
    private static void pick2(int idx, int m, int depth, Set<Integer> results) {
        if (depth == m) {
            for (Integer val : results) {
                answers.append(val).append(" ");
            }
            answers.append("\n");
            return;
        }
        for (int num = idx; num <= n; num++) {
            if (results.add(num)) {
                pick2(num + 1, m, depth + 1, results);
                results.remove(num);
            }
        }
    }

}
