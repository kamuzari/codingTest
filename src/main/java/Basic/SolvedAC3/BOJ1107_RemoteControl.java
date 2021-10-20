package Basic.SolvedAC3;

import java.io.*;
import java.util.StringTokenizer;

/*
완전탐색? +
*/
import java.util.*;

public class BOJ1107_RemoteControl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean button[] = new boolean[10];
        Arrays.fill(button, true);
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                final int brokenButton = Integer.parseInt(st.nextToken());
                button[brokenButton] = false;
            }
        }
        int target = n;
        int answer = Math.abs(100 - target);
        for (int i = 0; i <= 999_999; i++) {
            final String str = String.valueOf(i);
            int numberClick = str.length();
            boolean isBroken = false;

            for (int j = 0; j < numberClick; j++) {
                if (!button[str.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }
            if (isBroken) continue;
            else {
                final int plusClick = Math.abs(target - i);
                int min = plusClick + numberClick;
                answer = Math.min(answer, min);
            }
        }
        System.out.println(answer);
    }
}
