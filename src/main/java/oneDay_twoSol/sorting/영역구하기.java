package oneDay_twoSol.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 영역구하기 {
    static int m,n;
    static boolean board[][]; // board 에 색칠 부분은 true,
    static ArrayList<Integer> Area; // 넓이 넣어놓는 곳. 이 길이는 영역의 개수.
    static int area; // 각 영역에 따르는 넓이
    static boolean visited[][];
    static int[] dx = {1, -1, 0, 0};  // x축 기준 <행 기준>) 아래로 위로. (방향키)
    static int[] dy = {0, 0, 1, -1}; // y축 기준 <열 기준>) 오른쪽으로 왼쪽으로  (방향키)

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        m=parse(str[0]); // y축
        n=parse(str[1]); // x축
        int k=parse(str[2]); // 직사각형의 개수
        board=new boolean[m][n];
        for (int i = 0; i <k ; i++) {
            String str2[]=sc.nextLine().split(" ");
//            System.out.println(Arrays.toString(str2));
//            1. 일단 배열 선언하고 칠한것과 칠하지 않은 것을 구분한다. 주의사항 배열 행 렬 y축,x축이라는 것을 꼭 생각해야 한다.
            applyColored(parse(str2[0]),parse(str2[1]),parse(str2[2]),parse(str2[3]));
        }

//       boardContext();  board의 현황판 .

        Area =new ArrayList<>();
        area=0;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(!board[i][j])
                {
                    dfs(i,j);
                    Area.add(area);
//                    boardContext();
                }
                area=0;
            }
        }
        Collections.sort(Area);
        System.out.println(Area.size());
        for (int t:Area
             ) {
            System.out.print(t+" ");
        }

    }
    public static void dfs(int x,int y)
    {
        board[x][y]=true; // 방문되었음을 표시 <색칠한 보드위에 덧칠(방문하는 것 까지)하는 것.>
        area++;
        for (int i = 0; i <4 ; i++) {
            int tempX=x+dx[i];
            int tempY=y+dy[i];
            if(0<=tempX && tempX<m &&0<=tempY && tempY<n)
            {
                if(!board[tempX][tempY]){
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


    public static void applyColored(int x1, int y1, int x2, int y2)
    {
        for (int i = y1; i <y2 ; i++) {
            for (int j = x1; j <x2 ; j++) {
                board[i][j]=true;
            }
        }
        //true가 칠해진 부분.
    }


    public static int parse(String str)
    {
        return Integer.parseInt(str);
    }
}
