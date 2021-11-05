package Programmers.ProgrammersKit.SummerIntern;

import java.util.LinkedHashSet;
import java.util.Set;

public class PrimeMaking {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        //System.out.println(solution(nums));
        int nums2[] = {1,2,7,6,4};

        System.out.println(solution(nums2));
    }

    static boolean prime[];
    static Set<Integer> set = new LinkedHashSet<>();
    static int n, CNT;

    public static int solution(int[] nums) {
        int answer = -1;
        n = nums.length;
        Eratosthenes();
        pick(0, 0, nums);
        if (CNT != 0)
            return CNT;
        return answer;
    }

    static void pick(int cnt, int idx, int[] arr) {
        if (cnt == 3) {
            int sum = 0;
            System.out.println(set);
            for (Integer val : set) {
                sum += val;
            }
            if (!prime[sum])
                CNT++;
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                pick(cnt + 1, i + 1, arr);
                set.remove(arr[i]);
            }
        }

    }

    static void Eratosthenes() {
        prime = new boolean[50_001];

        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= 50_000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 50_000; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}
