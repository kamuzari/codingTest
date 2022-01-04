package Programmers.LV3;

import java.util.*;

public class DiskController {
    class Job {
        private int requestTime, executeTime;

        public Job(int requestTime, int executeTime) {
            this.requestTime = requestTime;
            this.executeTime = executeTime;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        LinkedList<Job> readyQ = new LinkedList<>();
        enQueueReadyQ(jobs, readyQ);
        PriorityQueue<Job> jobQ = new PriorityQueue<>((o1,o2)->{return o1.executeTime -o2.executeTime;}); // 실행 시간 오름차순
        readyQ.sort((o1, o2) -> o1.requestTime-o2.requestTime); //요청 시긴 오름차순

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
                time+=job.executeTime; // 현재까지의 작업시간
                answer+=time-job.requestTime; // 요청부터 종료까지 걸린 시간.
                cnt++;
            }
            else
            {
                time++;
            }
        }
        return answer/cnt;
    }

    private void enQueueReadyQ(int[][] jobs, LinkedList<Job> readyQ) {
        for (int[] job : jobs) {
            readyQ.add(new Job(job[0],job[1]));
        }
    }
}
