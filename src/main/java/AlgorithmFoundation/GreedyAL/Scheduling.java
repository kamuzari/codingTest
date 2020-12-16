package AlgorithmFoundation.GreedyAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Scheduling  {
    static class Job implements Comparable<Job>{
        private int job_number;
        private int deadline;
        private int profit;

        @Override
        public String toString() {
            return "Job{" +
                    "job_number=" + job_number +
                    ", deadline=" + deadline +
                    ", profit=" + profit +
                    '}';
        }

        public Job(int job_number, int deadline, int profit) {
            this.job_number = job_number;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            if(this.profit>o.profit)
                return -1;
            else if(this.profit == o.profit)
                return 0;
            else
                return 1;
        }
    }
    static ArrayList<Job> arr;
    static ArrayList<Job> J;
    public static void main(String[] args) {
        int n=7;
        arr=new ArrayList<>();
        arr.add(new Job(7,2,10));
        arr.add(new Job(6,3,15));
        arr.add(new Job(5,1,20));
        arr.add(new Job(4,3,25));
        arr.add(new Job(3,1,30));
        arr.add(new Job(2,1,35));
        arr.add(new Job(1,3,40));

        J=new ArrayList<>();
        Collections.sort(arr);
        for (Job j:arr
             ) {
            System.out.println(j.toString());
        }
        System.out.println("");
        int []arr2 = new int[4];
        for(Job job : arr) {
            if(arr2[job.deadline-1] == 0) {
                // 이미 작업을 한 것으로 체크 합니다.
                System.out.println(job.toString());

                arr2[job.deadline-1] = 1;
                J.add(job);
            }
        }
        System.out.println(Arrays.toString(arr2));
    }

    public static void Scheduling(int n,ArrayList<Job> deadline,ArrayList<Job> J)
    {
        J.add(deadline.get(0));

        for (int i = 0; i <deadline.size(); i++) {
            Job job=J.get(i);
            {

            }
        }

    }

}
