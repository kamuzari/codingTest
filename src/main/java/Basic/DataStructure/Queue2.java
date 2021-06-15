package Basic.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Queue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String cmd[] = new String[n];
        for (int i = 0; i < n; i++) {
            cmd[i] = br.readLine();
        }
        solution(cmd, new StringBuilder());
    }

    /*
    ## CAUTION
    pop(), {front,back - peek()}: 큐가 비어있는지 확인을 꼭 해야한다.
    */
    public static void solution(String cmd[], StringBuilder sb) {
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < cmd.length; i++) {
            String command[] = cmd[i].split(" ");

            if (command[0].equals("push")) {
                q.offer(Integer.parseInt(command[1]));
            } else {
                String s = command[0];
                if (s.equals("pop")) {
                    if (q.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(q.poll() + "\n");
                    }
                } else if (s.equals("size")) {
                    sb.append(q.size() + "\n");
                } else if (s.equals("empty")) {
                    if (q.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                } else if (s.equals("front")) {
                    if (q.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(q.peekFirst() + "\n");
                    }
                } else if (s.equals("back")) {
                    if (q.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(q.peekLast() + "\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
