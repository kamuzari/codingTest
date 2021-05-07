package kakaoInternship;

public class BridgeCross {
    public static void main(String[] args) {
        int st[] = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int st2[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int k = 3;
        System.out.println(solution(st2,k));
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int stone : stones) {
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }

        if(max==min)
            return min;
        while (min < max) {

            int mid = (max + min) / 2;

            if (isCross(stones, k, mid)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min-1;
    }

    private static boolean isCross(int[] stones, int k, int number) {
        int passCnt = 0;
        for (int stone : stones) {
            if (stone - number < 0) {
                passCnt++;
            } else {
                passCnt = 0;
            }
            if (passCnt == k)
                return false;
        }
        return true;
    }
}
