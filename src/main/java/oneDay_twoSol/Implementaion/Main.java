package oneDay_twoSol.Implementaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,r,c,d;
    static int arr[][];
    static int rs=1;
    static int moveY[] = {-1,0,1,0};
    static int moveX[] = {0,1,0,-1};
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int val = Integer.parseInt(st.nextToken());
                if(val == 1)
                    val=-1;
                arr[i][j] = val;
            }
        }
        clean(r,c,d);
        System.out.println(rs);
    }

    public static void clean(int i, int j, int dir) {
        arr[i][j] = 1;

        for(int d=0; d<4; d++) {
            dir = (dir+3)%4;
            int newX = j + moveX[dir];
            int newY = i + moveY[dir];

            if(0<=newX && newX<M && 0<=newY && newY<N && arr[newY][newX]==0) {
                rs++;
                clean(newY, newX, dir);
                return;
            }
        }

        int back = (dir+2)%4;
        int backX = j + moveX[back];
        int backY = i + moveY[back];

        if(0<=backX && backX<M && 0<=backY && backY<N && arr[backY][backX]!=-1)
            clean(backY,backX,dir);
    }

}