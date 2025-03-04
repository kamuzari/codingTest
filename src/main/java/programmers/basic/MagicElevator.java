package programmers.basic;

public class MagicElevator {
    /**
     * 95
     * -5 -> 5
     * -90 -> 9
     * <p>
     * 14번
     * <p>
     * +5 -> 5
     * -100 -> 1
     * <p>
     * 6번
     * <p>
     * 50
     * <p>
     * -50 -> 5번
     * <p>
     * <p>
     * +50 -> 5번
     * -100 -> 1번
     * <p>
     * 56
     * <p>
     * +4 -> 4번
     * -60 -> 6번
     * <p>
     * 55
     * <p>
     * +5 -> 5번
     * +40 -> 4번
     * -100 -> 1번
     * <p>
     * -5 -> 5번
     * -50 -> 5번
     * 10번
     */
    public int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int rest = storey % 10;
            storey /= 10;

            if (rest > 5) {
                answer += (10 - rest);
                storey++;
            } else if (rest < 5) {
                answer += rest;
            } else if (rest == 5) {
                int next = storey % 10;

                if (next < 5) {
                    answer += rest;
                } else {
                    answer += (10 - rest);
                    storey++;
                }
            }
        }

        return answer;
    }
}
