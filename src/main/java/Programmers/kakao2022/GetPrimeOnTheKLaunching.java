package Programmers.kakao2022;

import java.util.*;

public class GetPrimeOnTheKLaunching {

    /**
     * 제한 사항
     * 1 ≤ n ≤ 1,000,000
     * 3 ≤ k ≤ 10
     * NOTE: long 타입 제한까지 커버 됨..
     * 1. 10진수를 k진수로 바꿔야 함. := 1,000,000의 길이보다 클것으로 예상
        - p 자체는 한글자가 아닐 수 도 있다는 점.227 이런수가 p가 될수 잇음..
        - [ n의 길이 * n-1] O(n^2) 의 길이 마다 체크하면 터지는디...?
     * 2. 조건에 맞는 소수의 개수 구하기.
      hint: String.class split method
    */
    public int solution(int n, int k) {
        int answer = 0;
        String conversion = converseKNotation(n, k);
        String split[] = conversion.split("0");
        for (String num : split) {
            if (num.equals("")) {
                continue;
            }
            if (isPrimeYn(Long.parseLong(num))) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrimeYn(long n) {
        if (n < 2) {
            return false;
        }
        int square = (int) Math.sqrt(n);
        for (int i = 2; i <= square; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * NOTE : 메모리를 잡아먹는 trade-off 백만의 숫자가 3진수로 변할떄!
     */
    public boolean[] buildPrime() {
        boolean primes[] = new boolean[10];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i < 10; i++) {
            if (primes[i]) {
                for (int j = i * i; j < 10; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    public String converseKNotation(int n, int k) {
        StringBuilder answer = new StringBuilder();

        while (n >= k) {
            int rest = n % k;
            answer.append(rest);
            n = n / k;
        }
        if (n != 0) {
            answer.append(n);
        }
        return answer.reverse().toString();
    }
}
