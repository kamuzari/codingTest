package Basic.DataStructure;

import java.io.*;
import java.util.*;

public class Ballon {

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int[] balloons = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                balloons[i] = Integer.parseInt(st.nextToken());

            StringBuilder answer = new StringBuilder();
            answer.append(1).append(' ');

            int cur = 0;
            int next = balloons[0];
            balloons[0] = 0; // 터진 풍선
            for (int i = 0; i < n-1; i++) {
                if (next >= 0) {
                    for (int j = 0; j < next;) {
                        cur++;
                        cur %= n;
                        if (balloons[cur] != 0)
                            j++;
                    }
                } else {
                    for (int j = 0; j < next * -1;) {
                        cur--;
                        while (cur < 0)
                            cur += n;
                        if (balloons[cur] != 0)
                            j++;
                    }
                }

                next = balloons[cur];
                balloons[cur] = 0; // 없는 풍선
                answer.append(cur+1).append(' ');
            }

            System.out.print(answer);
        }
}
