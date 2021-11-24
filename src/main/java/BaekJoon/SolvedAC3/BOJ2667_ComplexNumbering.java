package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2667_ComplexNumbering {

    private static char[][] map;
    private static boolean[][] v;
    private static int n;
    private static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        v = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            map[i]=ch.clone();
        }
        List<Integer> answers=new ArrayList<>();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if(map[i][j]=='1' && !v[i][j]){
                    cnt=0;
                    dfs(i,j);
                    answers.add(cnt);
                }
            }
        }
        int initAnswer = answers.size();
        System.out.println(initAnswer);
        if(initAnswer!=0) {
            answers.sort((a,b)->a-b);
            answers.forEach(System.out::println);
        }
    }
    private static int dy[]={-1,1,0,0};
    private static int dx[]={0,0,-1,1};
    private static void dfs(int y, int x) {
        v[y][x]=true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int ny=dy[i]+y;
            int nx=dx[i]+x;
            if(indexOutOf(ny,nx)) continue;
            if(v[ny][nx]) continue;
            if(map[ny][nx]=='0') continue;
            dfs(ny,nx);
        }
    }

    private static boolean indexOutOf(int ny, int nx) {
        return ny<0 || nx<0 || ny>n-1 || nx>n-1;
    }
}
