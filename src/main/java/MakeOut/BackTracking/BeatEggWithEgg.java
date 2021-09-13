package MakeOut.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BeatEggWithEgg {

    private static int n;
    private static int[][] durabilityAndWeight;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        durabilityAndWeight = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            durabilityAndWeight[i][0] = Integer.parseInt(st.nextToken());
            durabilityAndWeight[i][1] = Integer.parseInt(st.nextToken());
        }

        hit(0);
        System.out.println(answer);
    }

    public static void hit(int curEgg) {
        if (curEgg == n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (durabilityAndWeight[i][0] <= 0) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        if (durabilityAndWeight[curEgg][0] <= 0) {
            hit(curEgg + 1);
        } else {

            boolean flag=false;
            for (int i = 0; i < n; i++) {
                if (i == curEgg || durabilityAndWeight[i][0] <= 0) {
                    continue;
                }
                flag=true;
                durabilityAndWeight[i][0] -= durabilityAndWeight[curEgg][1];
                durabilityAndWeight[curEgg][0] -= durabilityAndWeight[i][1];
                hit(curEgg + 1);
                durabilityAndWeight[i][0] += durabilityAndWeight[curEgg][1];
                durabilityAndWeight[curEgg][0] += durabilityAndWeight[i][1];
            }
            if(!flag){
                hit(curEgg+1);
            }
        }
    }
}
