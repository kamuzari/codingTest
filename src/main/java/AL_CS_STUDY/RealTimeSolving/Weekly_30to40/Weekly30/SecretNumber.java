package AL_CS_STUDY.RealTimeSolving.Weekly_30to40.Weekly30;

import java.io.*;
import java.util.StringTokenizer;

public class SecretNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            String answer = st.nextToken();
            for (int j = 0; j < answer.length() - 1; j++) {
                if(j<0)
                    j=0;
                char now = answer.charAt(j);
                char next = answer.charAt(j + 1);
                if (now == next) {
                    answer=answer.substring(0,j)+answer.substring(j+2);
                    j-=2;
                }
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
/*
10
10 1238099084
16 4100112380990844
26 12380990844100112380990844
42 123809908444100112380990844100112380990844
55 1238099084441001123809908441001321238099084432180990844
60 123809908444100145351123809908441001321238099084432180990844
71 12380990844410013218099084441001123809908441001321238099084432180990844
99 123809908444100180990844410013211238099084410013212380990844123809908441238099084410013232180990844
82 1238099084441001410011238099084412380990844100132123809908441238099084432180990844
58 0899809812380990844100132123809908441238099084432180990844

. . * . .
. . * . .
. * . . *
. * . . .
. * . . .
*/