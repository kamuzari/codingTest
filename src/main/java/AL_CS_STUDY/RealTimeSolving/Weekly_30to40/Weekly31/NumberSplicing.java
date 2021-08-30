package AL_CS_STUDY.RealTimeSolving.Weekly_30to40.Weekly31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NumberSplicing {

    static final int N = 4;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static Set<String> set = new LinkedHashSet<>();
    static int arr[] = new int[7];
    static int initY=0,initX=0;
    private static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TESTCASE; t++) {
            set.clear(); // static 캐시... 여러 개 테케 조심.
            int answer = 0;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st=new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < N; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[0]=map[i][j];
                    DFS(i, j, 1);
                }
            }
            answer=set.size();
            sb.append("#").append(t + 1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }

    private static void DFS(int y, int x, int cnt) {
        if (cnt == 7) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(arr).forEach(sb::append);
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny=dy[i]+y;
            int nx=dx[i]+x;
            if(outOfIdx(ny,nx))
                continue;
            arr[cnt]=map[ny][nx];
            DFS(ny,nx,cnt+1);
        }

    }
    public static boolean outOfIdx(int y,int x)
    {
        return y<0 || x<0 || y>=N || x>=N;
    }

}
