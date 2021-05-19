package AL_CS_STUDY.RealTimeSolving.Weekly21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SimpleUnzip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {

            int n = Integer.parseInt(br.readLine());
            char[] c = new char[n]; //알파벳을 저장
            int[] num = new int[n]; // 알파벳 개수를 저장


            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                c[i] = st.nextToken().charAt(0);
                num[i] = Integer.parseInt(st.nextToken());
            }


            System.out.println("#"+tc);
            int cnt=0; // 출력 횟수
            for(int i=0; i<n; i++) {
                for(int j=0; j<num[i]; j++) {
                    System.out.print(c[i]);
                    cnt++;
                    if(cnt == 10) {
                        System.out.println();
                        cnt = 0;
                    }
                }

            }
            System.out.println();

        }
    }
}
