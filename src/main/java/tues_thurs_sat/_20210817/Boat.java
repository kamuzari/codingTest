package tues_thurs_sat._20210817;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Boat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        LinkedList<Integer> dq = new LinkedList<Integer>();
        Arrays.sort(people);
        for (int person : people) {
            dq.offer(person);
        }
        while (!dq.isEmpty()) {
            Integer Max = dq.pollLast();
            if (!dq.isEmpty() && Max + dq.peekFirst() <= limit) {
                dq.pollFirst();
            }
            answer++;
        }
        return answer;
    }
}
