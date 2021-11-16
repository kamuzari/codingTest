package Programmers.LV2.Delivery;
import java.util.*;

public class Delivery_Floyd {
    static final int INF=(int)1e9;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int n=N;
        int k=K;
        int map[][]=new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            Arrays.fill(map[i],INF);
            map[i][i]=0;
        }
        for(int i=0; i<road.length; i++){
            int v1=road[i][0];
            int v2=road[i][1];
            int time=road[i][2];
            if(map[v1][v2]!=0){
                map[v1][v2]=Math.min(map[v1][v2],time);
                map[v2][v1]=Math.min(map[v2][v1],time);
            }else{
                map[v1][v2]=time;
                map[v2][v1]=time;
            }
        }

        for(int q=1;q<=N; q++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(i==j) continue;
                    map[i][j]=Math.min(map[i][j],map[i][q]+map[q][j]);
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(map[1][i]<=k) answer++;
        }

        return answer;
    }
}
