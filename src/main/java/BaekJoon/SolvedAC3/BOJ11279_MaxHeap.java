package BaekJoon.SolvedAC3;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ11279_MaxHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringBuilder answers = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty()) {
                    answers.append(0 + "\n");
                } else {
                    answers.append(pq.poll() + "\n");
                }
            }else{
                pq.offer(input);
            }
        }
        System.out.println(answers);
    }
}
