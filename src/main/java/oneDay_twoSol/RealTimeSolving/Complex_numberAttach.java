package oneDay_twoSol.RealTimeSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Complex_numberAttach {
    static int square[][];
    static boolean visited[][];
    static int n;
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static int area; // 각 단지별 넓이 측정
    static ArrayList<Integer> complex; // 각 단지 넓이 기록
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        square=new int[n][n];
        visited=new boolean[n][n];
        complex=new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i <n ; i++) {
            String str[]=sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                square[i][j]=Integer.parseInt(str[j]);
            }
        }
        area=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(square[i][j]==1&& !visited[i][j])
                {
                    dfs(i,j);
                    complex.add(area);
                    area=0;
                }
            }
        }
        System.out.println(complex.size());
        Collections.sort(complex);
        for(int val:complex)
        {
            System.out.println(val);
        }
    }
    static void dfs(int y,int x)
    {
        visited[y][x]=true;
        area++;
        for (int i = 0; i < 4; i++) {
            int tempY=y+dy[i];
            int tempX=x+dx[i];
            if(0<=tempX && tempX<n &&0<=tempY && tempY<n &&!visited[tempY][tempX])
            {
                if(square[tempY][tempX]==1)
                    dfs(tempY,tempX);
            }
        }
    }

}
