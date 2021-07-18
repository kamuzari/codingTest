package AL_CS_STUDY.Weekly29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ToiletConvention {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        List<Node>[]line=new List[m];
        for (int i = 0; i < m; i++) {
            line[i]=new LinkedList<>();
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int d=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            line[i%m].add(new Node(i,i%m,d,h));
        }
        int answer=0;
        for (int i = 0; i < m; i++) {
            if(line[i].isEmpty()) break;
            pq.offer(line[i].remove(0));
        }
        while (!pq.isEmpty())
        {
            answer++;
            Node head = pq.poll();
            System.out.println(head);
            if(head.idx==k)
            {
                System.out.println(answer-1);
                break;
            }
            if(!line[head.line].isEmpty())
                pq.offer(line[head.line].remove(0));
        }
    }
    static class Node implements Comparable<Node>{
        int idx,line,d,h;

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", line=" + line +
                    ", d=" + d +
                    ", h=" + h +
                    '}';
        }

        public Node(int idx, int line, int d, int h) {
            this.idx = idx;
            this.line=line;
            this.d = d;
            this.h = h;
        }

        @Override
        public int compareTo(Node o) {
            if(o.d-d==0)
            {
                if(o.h-h==0) {
                    return line - o.line;
                }
                return o.h-h;
            }
            return o.d-d;
        }
    }

}

