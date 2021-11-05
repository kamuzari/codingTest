package Programmers.ProgrammersKit.CompleteSearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PraciceTest {
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(arr)));
    }

    static int one[] = {1, 2, 3, 4, 5};
    static int two[] = {2, 1, 2, 3, 2, 4, 2, 5};
    static int three[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static int[] solution(int[] answers) {

        int oneLen = one.length;
        int twoLen = two.length;
        int threeLen = three.length;

        int p1, p2, p3;
        p1 = p2 = p3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (one[i % oneLen] == answers[i])
                p1++;

            if (two[i % twoLen] == answers[i])
                p2++;

            if (three[i % threeLen] == answers[i])
                p3++;
        }

        int max = Math.max(p1, Math.max(p2, p3));
        ArrayList<Integer> arr = new ArrayList<>();
        if (max == p1) arr.add(1);
        if (max == p2) arr.add(2);
        if (max == p3) arr.add(3);
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        arr.clear();
        return answer;
    }
}
