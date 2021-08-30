package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly26;

import java.io.*;
import java.util.*;

public class OMock {
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= t; testCase++) {
            String answer = "";
            int n = Integer.parseInt(br.readLine());
            char arr[][] = new char[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), "");
                String s = st.nextToken();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
//            Arrays.stream(arr).forEach(System.out::println);
            boolean flag=false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 'o'&& checking(n, arr, i, j)) {
                        System.out.println(i+" "+j);
                        flag=true;
                    }
                }
                if(flag)
                    break;
            }
            if(flag)
                answer="YES";
            else
                answer="NO";
            sb.append("#" + testCase).append(" " + answer + "\n");
        }
        System.out.println(sb);
    }

    private static boolean checking(int n, char[][] arr, int i, int j) {
        for (int dir = 0; dir < 8; dir++) {
            for (int cnt  = 1; cnt <5 ; cnt++) {
                int ny= i +dy[dir]*cnt;
                int nx= j +dx[dir]*cnt;
                if(ny<0 || nx<0 || ny>= n || nx>= n)
                    break;
                else if(arr[ny][nx]!='o')
                    break;
               if(cnt==4)
                   return true;
            }
        }
        return false;
    }

}
