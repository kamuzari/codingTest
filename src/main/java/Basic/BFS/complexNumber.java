package Basic.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class complexNumber {
    static int n,map[][];
    static boolean visited[][];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static ArrayList<Integer> houseNumber=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        sc.nextLine();
        map=new int[n][n];
        visited=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str[]=sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        int complexCnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j]==1)
                {
                    dfs(i,j);
                    complexCnt++;
                    houseNumber.add(houseCnt);
                }
                houseCnt=0;
            }
        }
        System.out.println(complexCnt);
        Collections.sort(houseNumber);
        for (Integer i : houseNumber) {
            System.out.println(i);
        }
    }
    static int houseCnt=0;
    static void dfs(int y,int x)
    {
        houseCnt++;
        visited[y][x]=true;
        for (int i = 0; i < 4; i++) {
            int ny=dy[i]+y;
            int nx=dx[i]+x;
            if(ny>=n || nx >=n || ny<0 || nx<0 || visited[ny][nx] || map[ny][nx]!=1)
                continue;

            dfs(ny,nx);
        }
    }
}
