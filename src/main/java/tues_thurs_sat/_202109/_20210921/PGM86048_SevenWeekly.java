package tues_thurs_sat._202109._20210921;

import java.util.*;

public class PGM86048_SevenWeekly {
    public static void main(String[] args) {
        int e[] = {1, 4, 2, 3};
        int l[] = {2, 1, 3, 4};
        final PGM86048_SevenWeekly t = new PGM86048_SevenWeekly();
        t.solution(e, l);
    }

    public int[] solution(int[] enter, int[] leave) {
        int n = enter.length;
        int[] answer = new int[n];
        Set<Integer> room = new HashSet<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            room.add(enter[i]);
            for (Integer val : room) {
                answer[val - 1]++;
            }
            answer[enter[i] - 1] = room.size()-1;

            while (idx < n && room.contains(leave[idx])) {
                room.remove(leave[idx++]);
            }
        }
        return answer;
    }
}
