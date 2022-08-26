package programmers.Kits.Heap;

import java.util.*;

public class DiskController {
    static class job {
        private int time,work;

        public job(int time, int work) {
            this.time = time;
            this.work = work;
        }
    }
    public static void main(String[] args) {
        int a[][]={{0,3},{1,9},{2,6}};
        System.out.println(solution(a));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        LinkedList<job> ready=new LinkedList<>();
        PriorityQueue<job> pq=new PriorityQueue<>(new Comparator<job>() {
            @Override
            public int compare(job a, job b) {
                return a.work-b.work;
            }
        });
        for (int[] job : jobs) {
            ready.offer(new job(job[0],job[1]));
        }
        ready.sort(new Comparator<job>() {
            @Override
            public int compare(job a, job b) {
                return a.time-b.time;
            }
        });

        int cnt=0;
        int t=ready.peek().time;
        while (cnt<jobs.length)
        {
            while (!ready.isEmpty() && ready.peek().time<=t)
            {
                pq.offer(ready.pollFirst());
            }
            if(!pq.isEmpty())
            {
                job cur = pq.poll();
                t+=cur.work;
                answer+=t-cur.time;
                cnt++;
            }
            else
            {
                t++;
            }
        }
        return answer/ jobs.length;

    }

}
