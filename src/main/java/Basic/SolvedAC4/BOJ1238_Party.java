package Basic.SolvedAC4;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1238_Party {
    static final int INF=(int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int party=Integer.parseInt(st.nextToken());
        int map[][]=new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(map[i],INF);
            map[i][i]=0;
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());
            map[from][to]=dist;
        }
        for (int k = 1; k <=n; k++) {
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n ; j++) {
                    if(i==j) continue;
                    map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        int max=0;
        for (int i = 1; i <=n; i++) {
            int toParty,fromParty;
            toParty=map[i][party];
            fromParty=map[party][i];
            max=Math.max(max,toParty+fromParty);
        }
        System.out.println(max);
    }
}
