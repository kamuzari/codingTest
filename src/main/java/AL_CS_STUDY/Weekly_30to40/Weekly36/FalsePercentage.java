package AL_CS_STUDY.Weekly_30to40.Weekly36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FalsePercentage {
    class Stage implements Comparable<Stage>{
        private int idx;
        private double percentage;

        public Stage(int idx, double percentage) {
            this.idx = idx;
            this.percentage = percentage;
        }


        @Override
        public int compareTo(Stage o) {
            if(o.percentage>this.percentage)
                return 1;
            else if(o.percentage<this.percentage)
                return -1;
            else
                return this.idx-o.idx;
        }
    }
    public int[] solution(int N,int[] stages)
    {
        int step[]=new int[N+2];
        for (int stage : stages) {
            step[stage]++;
        }
        List<Stage> results=new ArrayList<>();
        int totalPlayer=stages.length;

        for (int i = 1; i <= N; i++) {
            double percentage = (double) step[i] / totalPlayer;
            totalPlayer-=step[i];
            results.add(new Stage(i,percentage));
        }

        Collections.sort(results);
        System.out.println(results);
        return results.stream().mapToInt(stage -> stage.idx).toArray();
    }
}
