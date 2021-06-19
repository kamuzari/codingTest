package Basic.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrinterQueue {
    static class Node implements Comparable<Node>{
        int idx,importance;

        public Node(int idx, int importance) {
            this.idx = idx;
            this.importance = importance;
        }

        @Override
        public int compareTo(Node node) {
            if(importance== node.importance)
                return idx-node.idx;
            return importance- node.importance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int wonderIdx = Integer.parseInt(st.nextToken());
            Queue<Node> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer t1, Integer t2) {
                    return t2 - t1;
                }
            });

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int prior = Integer.parseInt(st.nextToken());
                q.offer(new Node(i, prior));
                pq.offer(prior);
            }
            int cnt=1;
            while (true)
            {
                Integer peek = pq.peek();
                if(q.peek().importance==peek)
                {
                    if(q.peek().idx==wonderIdx)
                    {
                        break;
                    }
                    q.poll();
                    pq.poll();
                    cnt++;
                }
                else
                {
                    q.offer(q.poll());
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
