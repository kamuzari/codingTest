package AL_CS_STUDY.Weekly_40to50.Weekly41;

import java.util.*;
import java.io.*;

public class BOJ8980_Parcel {
    static class Node implements Comparable<Node> {
        private int s, e, boxNum;

        public Node(int s, int e, int boxNum) {
            this.s = s;
            this.e = e;
            this.boxNum = boxNum;
        }

        @Override
        public int compareTo(Node comp) {
            if (this.e == comp.e) {
                return this.s - comp.s;
            }
            return this.e - comp.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int town = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());
        int taskNum = Integer.parseInt(br.readLine());

        Node deliveries[] = new Node[taskNum];
        for (int i = 0; i < taskNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            deliveries[i] = new Node(s, e, weight);
        }
        Arrays.sort(deliveries);
        int w[] = new int[town + 1];
        Arrays.fill(w, capacity);
        int answer = 0;
        for (int i = 0; i < taskNum; i++) {
            final Node cur = deliveries[i];

            int maxBox = Integer.MAX_VALUE;

            for (int j = cur.s; j < cur.e; j++) {
                maxBox = Math.min(maxBox, w[j]);
            }

            if (maxBox >= cur.boxNum) {
                for (int j = cur.s; j < cur.e; j++) {
                    w[j]-=cur.boxNum;
                }
                answer+=cur.boxNum;
            }else{
                for (int j = cur.s; j < cur.e; j++) {
                    w[j]-=maxBox;
                }
                answer+=maxBox;
            }
        }
        System.out.println(answer);


    }
}
