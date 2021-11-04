package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286_AbsHeap {
   static  class Node{
        int org,abs;
        public Node (int input){
            org=input;
            abs=Math.abs(input);
        }
    }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1.abs==o2.abs){
                    return o1.org-o2.org;
                }
                return o1.abs-o2.abs;
            });
            StringBuilder answers = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(br.readLine());
                if (input == 0) {
                    if (pq.isEmpty()) {
                        answers.append(0 + "\n");
                    } else {
                        Node poll = pq.poll();
                        answers.append(poll.org + "\n");
                    }
                }else{
                    pq.offer(new Node(input));
                }
            }
            System.out.println(answers);
        }

}
