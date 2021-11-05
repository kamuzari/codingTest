package tues_thurs_sat._202109._20210916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ9328_Key {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char map[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                char ch[] = br.readLine().toCharArray();
                map[i] = ch.clone();
            }
            Set<Character> keys=new HashSet<>();
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                keys.add(str.charAt(i));
            }
            // 달러 기준으로 주변 위 아래 왼쪽 오른쪽 탐색 후 필요한 키가 있는지 보고
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j]=='*') continue;
                    else if(Character.isUpperCase(map[i][j]) && !keys.contains(Character.toLowerCase(map[i][j]))) {
                        continue;
                    }
                    Bfs(map,i,j);
                }
            }
        }

    }
    static class Pair {
        private int y,x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    private static int Bfs(char[][] map, int i, int j) {
        return 0;
    }
}
