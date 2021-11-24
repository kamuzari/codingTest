package BaekJoon.SolvedAC3;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ21733_KahiProcess {
    static class Node implements Comparable<Node>{
        private int id, restExecTime, priority;

        public Node(int id, int restExecTime, int priority) {
            this.id = id;
            this.restExecTime = restExecTime;
            this.priority = priority;
        }
        public boolean isEndProcess(){
            return this.restExecTime==1;
        }

        @Override
        public int compareTo(Node comp){
            if(this.priority==comp.priority){
                return this.id- comp.id;
            }
            return comp.priority-this.priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int exeTime = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());
            pq.offer(new Node(idx, exeTime, priority));
        }
        StringBuilder answers = new StringBuilder();
        while (t-- > 0) {
            if (pq.isEmpty()) break;

            Node cur = pq.poll();
            answers.append(cur.id + "\n");
            if(cur.isEndProcess()) continue;
            pq.offer(new Node(cur.id,cur.restExecTime-1,cur.priority-1));
        }
        System.out.println(answers);
    }
}
