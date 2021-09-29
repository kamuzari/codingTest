package tues_thurs_sat._202109._20210928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
남택의 갯수를 i라고 하고 남 보다 2개 이상 무조건 많아야 하므로
*/
public class BOJ14568_yeonPC {
    static final int TEAK = 0;
    static final int YOUNG = 1;
    static final int NAM = 2;
    static Set<Set<Integer>> set = new HashSet<>();
    static int candys[] = new int[3];
    static int target, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        target = n;
//        permutation(0);
        for (int i = 2; i <= n - 2; i += 2) {
            answer += (n - i - 2) / 2;
        }
        System.out.println(answer);
    }

    static void permutation(int cnt) {
        if (cnt == target) {
            if (check()) {
                int[] clone = candys.clone();
                Set<Integer> temp = new HashSet<>();
                for (int i = 0; i < clone.length; i++) {
                    temp.add(i);
                }
                boolean flag = true;
                for (Set<Integer> set : set) {
                    if (set.containsAll(temp)) {
                        return;
                    }
                }
                set.add(temp);
                answer++;
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            candys[i]++;
            permutation(cnt + 1);
            candys[i]--;
        }
    }

    static boolean check() {
        if (candys[NAM] - candys[YOUNG] < 2)
            return false;
        if (candys[TEAK] == 0 || candys[YOUNG] == 0 || candys[NAM] == 0)
            return false;
        if (candys[TEAK] % 2 != 0)
            return false;
        return true;
    }
}
