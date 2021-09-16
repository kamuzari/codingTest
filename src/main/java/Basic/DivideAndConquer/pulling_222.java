package Basic.DivideAndConquer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pulling_222 {

    private static int[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        making(n);
        System.out.println(map[0][0]);
    }

    public static void making(int cnt)
    {
        if(cnt==1) {
            return;
        }

        for (int i = 0; i < cnt; i+=2) {
            for (int j = 0; j <cnt ; j+=2) {
                int temp[]={map[i][j],map[i][j+1],map[i+1][j],map[i+1][j+1]};
                Arrays.sort(temp);
                map[i/2][j/2]=temp[2];
            }
        }
        making(cnt/2);
    }

}
