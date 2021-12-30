package Programmers.LV2;

public class LeastCommonMultiplesOfN {

    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    public int gcd(int a, int b) {
        int n1 = Math.max(a, b);
        int n2 = Math.min(a, b);
        while (n2 != 0) {
            int r = n1 % n2;
            n1 = n2;
            n2 = r;
        }
        return n1;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
