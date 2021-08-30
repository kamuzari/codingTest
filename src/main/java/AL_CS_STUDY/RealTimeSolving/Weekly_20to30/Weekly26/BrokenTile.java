package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly26;

import java.util.*;
import java.io.*;

public class BrokenTile {
    static int dy[] = {1, 0, 1};
    static int dx[] = {0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char arr[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            boolean v[][] = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == '#' && !v[i][j]) {
                        int cnt = 0;
                        for (int k = 0; k < 3; k++) {
                            int ny = dy[k] + i;
                            int nx = dx[k] + j;
                            if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                                break;
                            if (arr[ny][nx] == '#') {
                                v[ny][nx] = true;
                                cnt++;
                            }
                        }
                        if (cnt == 3) {
                            arr[i][j] = '.';
                            arr[i + 1][j] = '.';
                            arr[i + 1][j + 1] = '.';
                            arr[i][j + 1] = '.';
                        }
                    }

                }
            }
            String answer = "";
            if (check(arr)) {
                answer="YES";
            } else {
                answer="NO";
            }
            sb.append("#" + testCase).append(" " + answer + "\n");
        }
        System.out.println(sb);
    }

    static boolean check(char arr[][]) {
        char NotBroken = '.';
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != NotBroken)
                    return false;
            }
        }
        return true;
    }
}
/*
1
4 5
.##..
.####
.####
.##..*/
