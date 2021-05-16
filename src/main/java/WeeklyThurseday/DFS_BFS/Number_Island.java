package WeeklyThurseday.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Number_Island {
    static int w,h;
    static boolean visited[][];
    static int board[][];
    static int[] dx = {1, -1, 0, 0,1,-1,1,-1};  // x축 기준 <행 기준>) 아래로 위로. (방향키)
    static int[] dy = {0, 0, 1, -1,1,-1,-1,1}; // y축 기준 <열 기준>) 오른쪽으로 왼쪽으로  (방향키)
    // (-1,-1)) (1,1) (-1,1),(1,-1) 왼쪽하단,오른쪽상단,왼쪽상단,오른쪽 하단. ==? 대각선 추가.
    static ArrayList<Integer> Area; // 땅의 영역 개수.
    static int area;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        w=1;
        h=1;

        while (w!=0 && h!=0)
        {
            String str[]=sc.nextLine().split(" ");
            w=Integer.parseInt(str[0]);
            h=Integer.parseInt(str[1]);

            board=new int[h][w];
            visited=new boolean[h][w];
            for (int i = 0; i <h ; i++) {
                String str2[]=sc.nextLine().split(" ");
                for (int j = 0; j <w ; j++) {
                    board[i][j]=Integer.parseInt(str2[j]);
                }
            }
//            boardContext();
            Area =new ArrayList<>();
            area=0;
            for (int i = 0; i <h ; i++) {
                for (int j = 0; j <w ; j++) {
                    if(board[i][j]==1 &&!visited[i][j])
                    {
                        dfs(i,j);
                        Area.add(area);
                    }
                    area=0;
                }
            }
            if(w!=0 && h!=0)
            {
                System.out.println(Area.size());
            }
        }
    }
    public static void dfs(int x,int y)
    {
        visited[x][y]=true; //
        area++;
        for (int i = 0; i <8 ; i++) {
            int tempX=x+dx[i];
            int tempY=y+dy[i];
            if(0<=tempX && tempX<h &&0<=tempY && tempY<w &&!visited[tempX][tempY])
            {
                if(board[tempX][tempY]==1){
                    dfs(tempX,tempY);
                }
            }
        }
    }
    public static void boardContext()
    {
        for (int i = 0; i <board.length ; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
    }
}
