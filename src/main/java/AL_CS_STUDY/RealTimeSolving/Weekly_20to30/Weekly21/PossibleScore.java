package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PossibleScore {
    static int T;
    static int N;
    static boolean[] visited;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        int t = 1;
        while(T-- >0) {
            N = Integer.parseInt(br.readLine());
            map = new int[N];
            visited = new boolean[10001];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            int res = 0;

            visited[0] = true;
            for (int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
                max += map[i];

                for (int j = max; j >= 0; j--) {
                    if(visited[j])
                        visited[j + map[i]] = true;
                }
                visited[map[i]] = true;
            }
            for (int i = 0; i <= max; i++) {
                if(visited[i]) res++;
            }
            System.out.printf("#%d %d\n",t++,res);
        }
    }
}
