package Basic.Sorting.SortingPS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
// https://programmers.co.kr/learn/courses/30/lessons/42889
public class FalsePercentage {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        System.out.println(solution(4, new int[]{4,4,4,4,4}));
    }

    public static int[] solution(int N, int[] stages) {
        int stageStep[] = new int[N + 2];
        for (int stage : stages) {
            stageStep[stage]++;
        }
        List<Stage> list = new LinkedList<>();
        int totalPlayer = stages.length;
        for (int i = 1; i <= N; i++) {
            double falsePercentage = (double) stageStep[i] / totalPlayer;
            totalPlayer -= stageStep[i];
            list.add(new Stage(i, falsePercentage));
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int idx = 0;

        return list.stream().mapToInt(value -> value.idx).toArray();
    }

    static class Stage implements Comparable<Stage> {
        private int idx;
        private double failPercentage;

        public Stage(int idx, double failPercentage) {
            this.idx = idx;
            this.failPercentage = failPercentage;
        }

        @Override
        public int compareTo(Stage o) {
           if(o.failPercentage>failPercentage)
               return 1;
           else if(o.failPercentage<failPercentage)
               return -1;
           return 0;
        }
    }
}
