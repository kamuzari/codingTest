package Basic.SolvedAC3.Standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ5430_AC {

    private static boolean isRight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuffer answers = new StringBuffer();
        while (testCase-- > 0) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String substring = str.substring(1, str.length()-1);
            String[] split = substring.split(",");
            LinkedList<Integer> dq = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                dq.offer(Integer.parseInt(split[i]));
            }
            isRight = false;
            boolean isT= commandProcessing(cmd, dq);
            if(!isT){
                answers.append("error\n");
            }else {
                answers.append("[");
                if(!isRight){
                    answers.append(dq.pollFirst());
                }else{
                    answers.append(dq.pollLast());
                }
                while (!dq.isEmpty()) {
                    if(!isRight)
                        answers.append(","+dq.pollFirst());
                    else{
                        answers.append(","+dq.pollLast());
                    }
                }
                answers.append("]").append("\n");
            }
        }
        System.out.println(answers);
    }

    private static boolean commandProcessing(String cmd, LinkedList<Integer> dq) {
        for (int i = 0; i < cmd.length(); i++) {
            char command = cmd.charAt(i);
            switch (command) {
                case 'R':
                    if (!isRight) {
                        isRight = true;
                    } else {
                        isRight = false;
                    }
                    break;
                case 'D':
                    if (dq.isEmpty()) {
                        return false;
                    } else {
                        if (!isRight) {
                            dq.pollFirst();
                        } else if (isRight) {
                            dq.pollLast();
                        }
                    }
                    break;
            }
        }
        return true;
    }
}
