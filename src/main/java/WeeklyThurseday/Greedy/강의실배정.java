package WeeklyThurseday.Greedy;

import java.util.*;

public class 강의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++)
            arr[i] = new Pair(sc.nextInt(),sc.nextInt());
        Arrays.sort(arr);
        pq.add(arr[0].e);
        for(int i=1;i<n;i++){
            // 새로운 시작시간이 pq의 빨리끝나는 시간보다 같거나 크다면 기존 강의실 이용
            if(pq.peek()<=arr[i].s)
                pq.poll();
            pq.add(arr[i].e);
        }
        System.out.println(pq.size());

    }

    static class Pair implements Comparable<Pair>{
        private int s;
        private int e;

        public Pair(int s
                , int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.s>o.s)
                return 1;
            else if(o.s>this.s)
                return -1;
            else
            {
                if(this.e>o.e)
                    return 1;
                else if(this.e<o.e)
                    return -1;
                else
                    return 0;
            }
        }
    }
}
