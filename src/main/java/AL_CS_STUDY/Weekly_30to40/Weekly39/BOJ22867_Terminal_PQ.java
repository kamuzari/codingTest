package AL_CS_STUDY.Weekly_30to40.Weekly39;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ22867_Terminal_PQ {
    static class Node implements Comparable<Node> {
        int in, out;

        public Node(int in, int out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public int compareTo(Node o) {
            if (o.in == this.in) {
                return out - o.out;
            }
            return this.in - o.in;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + in +
                    ", end=" + out +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        LinkedList<Node> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            final int start = toInteger(st.nextToken());
            final int end = toInteger(st.nextToken());
            list.offer(new Node(start, end));
        }
//        System.out.println(list);
        Collections.sort(list);
        if (!list.isEmpty()) {
            pq.offer(list.get(0).out);
        }
        int answer = 1;
        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()<=list.get(i).in)
                pq.poll();
            pq.offer(list.get(i).out);
            answer=Math.max(answer,pq.size());
        }
        System.out.println(answer);
    }

    public static int toInteger(String str) {
        final Pattern p = Pattern.compile("([0-9])+");
        Matcher matcher = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return Integer.parseInt(sb.toString());
    }
}
