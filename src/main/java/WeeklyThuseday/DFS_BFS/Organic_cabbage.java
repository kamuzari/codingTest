package WeeklyThuseday.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Organic_cabbage {
    static int m,n;
    static ArrayList<Integer> Area;//  벌레가 있어야할 영역의 개수
    static boolean board[][];
    static boolean visited[][];
    static int area;
    static int[] dx = {1, -1, 0, 0};  // x축 기준 <행 기준>) 아래로 위로. (방향키)
    static int[] dy = {0, 0, 1, -1}; // y축 기준 <열 기준>) 오른쪽으로 왼쪽으로  (방향키)
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        sc.nextLine();
        while (T-->0)
        {
            String str[]=sc.nextLine().split(" ");
            m=parse(str[0]); // y축
            n=parse(str[1]); // x축
            int k=parse(str[2]); // 배추가 심어져 있는 개수.
            board=new boolean[m][n];
            visited=new boolean[m][n];

            for (int i = 0; i <k ; i++) {
                String str2[]=sc.nextLine().split(" ");
                int x=parse(str2[0]);
                int y=parse(str2[1]);
                board[x][y]=true;
            }
//            boardContext();
            Area =new ArrayList<>();
            area=0;
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++) {
                    if(board[i][j] && !visited[i][j])
                    {
                        dfs(i,j);
                        Area.add(area);
//                    boardContext();
                    }
                    area=0;
                }
            }
            System.out.println(Area.size());
        }
    }
    public static void dfs(int x,int y)
    {
        visited[x][y]=true; // 방문되었음을 표시 <색칠한 보드위에 덧칠(방문하는 것 까지)하는 것.>
        area++;
        for (int i = 0; i <4 ; i++) {
            int tempX=x+dx[i];
            int tempY=y+dy[i];
            if(0<=tempX && tempX<m &&0<=tempY && tempY<n &&!visited[tempX][tempY])
            {
                if(board[tempX][tempY]){
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
    public static int parse(String str)
    {
        return Integer.parseInt(str);
    }
}
