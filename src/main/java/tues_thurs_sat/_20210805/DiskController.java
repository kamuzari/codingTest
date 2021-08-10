package tues_thurs_sat._20210805;

import java.util.*;

public class DiskController {
    static class Job {
        private int requestTime, taskTime;

        public Job(int requestTime, int taskTime) {
            this.requestTime = requestTime;
            this.taskTime = taskTime;
        }
    }
    // SJF _ 반환시간의 평균 합.
    public int solution(int[][] jobs) {
        int answer = 0;
        LinkedList<Job> readyQ = new LinkedList<>();
        PriorityQueue<Job> jobQ = new PriorityQueue<>((o1,o2)->{
            return o1.taskTime-o2.taskTime;
        });

        for (int[] job : jobs) {
            readyQ.add(new Job(job[0],job[1]));
        }
        readyQ.sort((o1, o2) -> o1.requestTime-o2.requestTime);

        int cnt=0;
        int time=readyQ.peek().requestTime; // 작업이 들어온 첫 시간.
        while (cnt< jobs.length)
        {
            while (!readyQ.isEmpty() && readyQ.peek().requestTime<=time)
            {
                jobQ.offer(readyQ.poll());
            }
            if(!jobQ.isEmpty())
            {
                Job job = jobQ.poll();
                time+=job.taskTime; // 현재까지의 작업시간
                answer+=time-job.requestTime; // 요청부터 종료까지 걸린 시간. (반환 시간)
                cnt++;
            }
            else
            {
                time++;
            }
        }


        return answer/cnt;
    }
}
