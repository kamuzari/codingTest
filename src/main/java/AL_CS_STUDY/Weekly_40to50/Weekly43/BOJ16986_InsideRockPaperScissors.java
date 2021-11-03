package AL_CS_STUDY.Weekly_40to50.Weekly43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16986_InsideRockPaperScissors {
    static final int JIWOO = 1;
    static final int GYEONGHEE = 2;
    static final int MINHO = 3;
    private static int n;
    private static int[][] a;
    private static int k;
    private static int[][] people;
    static int handIdx[],winCnt[];
    static boolean v[];
    static final int WIN = 2,LOSE=0,DRAW=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n+1][n+1];
        v=new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        people = new int[3+1][20];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) {
            people[GYEONGHEE][i] = Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) {
            people[MINHO][i] = Integer.parseInt(st.nextToken());
        }
        pick(0);
        System.out.println(0);
    }

    static void pick(int cnt) {
        if (cnt == n) {
            winCnt=new int[3+1]; // 이긴 횟수 cnt
            handIdx=new int[3+1]; // 각 사용자별 내는 순서 IDX 기록
            if (check(JIWOO, GYEONGHEE)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (v[i]) continue;
            v[i]=true;
            people[JIWOO][cnt]=i;
            pick(cnt + 1);
            people[JIWOO][cnt]=0;
            v[i]=false;
        }
    }

    private static boolean check(int p1, int p2) {

        // 기저 사례 조건
        if(winCnt[JIWOO]>=k){
            return true;
        }

        if(handIdx[JIWOO]>=n || winCnt[GYEONGHEE]>=k || winCnt[MINHO]>=k){
            return false;
        }
        // =========
        int next=0;
        for (int i = 1; i <= 3; i++) {
            if(i!=p1 && i!=p2) next=i;
        }

        int result=a[people[p1][handIdx[p1]]][people[p2][handIdx[p2]]];
        // 내야하는 순번 증가
        handIdx[p1]++;
        handIdx[p2]++;

        if(result== WIN){
            winCnt[p1]++;
            if(check(p1,next)) return true;
        }else if(result==LOSE){
            winCnt[p2]++;
            if(check(p2,next)) return true;
        }else if(result==DRAW){
            if(p1>p2){
                winCnt[p1]++;
                if(check(p1,next)) return true;
            }else if(p1<p2){
                winCnt[p2]++;
                if(check(p2,next)) return true;
            }
        }

        return false;
    }
}
