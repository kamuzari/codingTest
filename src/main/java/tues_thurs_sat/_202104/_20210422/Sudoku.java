package tues_thurs_sat._202104._20210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sudoku {
    static int map[][]=new int[9][9];
    static int zero;
    static class node{
        private int y,x;

        public node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[];
        for (int i = 0; i < 9; i++) {
            s=br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j]=Integer.parseInt(s[j]);
                if(map[i][j]==0)
                    zero++;
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(map[i][j]==0) {
                    dfs(new node(i, j));
                }
            }
        }
    }
    static void dfs(node cur)
    {
        for (int i = 1; i <=9 ; i++) {
            if(check(cur,i))
            {
                map[cur.y][cur.x]=i;
                zero--;
                if(zero==0) {
                    print();
                    System.exit(0);
                }
                outer:
                for (int j = 0; j <9; j++) {
                    for (int k = 0; k < 9; k++) {
                        if(map[j][k]==0)
                        {
                            dfs(new node(j,k));
                            break outer;
                        }
                    }
                }
                map[cur.y][cur.x]=0;
                zero++;
            }
        }
     return;
    }
    static boolean check(node cur,int number)
    {
        for (int i = 0; i < 9; i++) {
            if(map[cur.y][i]==number)
                return false;
            if(map[i][cur.x]==number)
                return false;
        }

        int ny=(cur.y/3)*3;
        int nx=(cur.x/3)*3;
        for (int i = ny; i <ny+3 ; i++) {
            for (int j = nx; j <nx+3 ; j++) {
                if(map[i][j]==number)
                    return false;
            }
        }
        return true;
    }


    static void print()
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
