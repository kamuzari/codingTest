package tues_thurs_sat._20210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
ref . https://patrickryoo.tistory.com/entry/BOJ-2239%EB%B2%88-%EC%8A%A4%EB%8F%84%EC%BF%A0-%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9-JAVA

*/
public class Sudoku2 {
    static int map[][];
    static ArrayList<node> zero=new ArrayList<node>();
    static class node
    {
        private int y,x;

        public node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[];
        map=new int[9][9];
        for (int i = 0; i < 9; i++) {
            s=br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j]=Integer.parseInt(s[j]);
                if(map[i][j]==0)
                    zero.add(new node(i,j));
            }
        }
        dfs(0);

    }
    static void dfs(int cnt)
    {
        if(cnt==zero.size())
        {
            for (int i = 0; i <9; i++) {
                for (int j = 0; j <9 ; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }
        node cur = zero.get(cnt);
        for (int i = 1; i <= 9; i++) {
            if(map[cur.y][cur.x]==0 && check(cur,i))
            {
                map[cur.y][cur.x]=i;
                dfs(cnt+1);
                map[cur.y][cur.x]=0;
            }

        }
    }
    static boolean check(node cur,int target)
    {
        for (int i = 0; i <9 ; i++) {
            if( map[cur.y][i]==target)
                return false;
            if(map[i][cur.x]==target)
                return false;
        }
        int ny=(cur.y/3)*3;
        int nx=(cur.x/3)*3;
        for (int i = ny; i <ny+3 ; i++) {
            for (int j = nx; j <nx+3 ; j++) {
                if(map[i][j]==target)
                    return false;
            }
        }
        return true;
    }
}
