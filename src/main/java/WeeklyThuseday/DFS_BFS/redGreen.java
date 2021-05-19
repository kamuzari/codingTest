package WeeklyThuseday.DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class redGreen {
    static int n;
    static ArrayList<Integer> Area; // 이 구역이 사이즈가 영역의 개수.
    static char arr[][];
    static boolean visited[][];
    static int area;
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc=new Scanner( System.in);
        n=sc.nextInt();
        arr=new char[n][n];
        sc.nextLine();
        for (int i = 0; i <n ; i++) {
            String str[]=sc.nextLine().split("");
            for (int j = 0; j <n ; j++) {
                arr[i][j]=str[j].charAt(0);
            }
        }
//        for (int i = 0; i <n ; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        //logic

        Area=new ArrayList<>();
        area=0;
        int var=2;
        while (var-->0)
        {
            visited=new boolean[n][n];
            if(var==0)
            {
                for (int i = 0; i <n ; i++) {
                    for (int j = 0; j <n ; j++) {
                        if(arr[i][j]=='G')
                            arr[i][j]='R';
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        dfs(i, j);
                        Area.add(area);
                    }
                }
            }
            System.out.print(Area.size()+" ");
            Area.clear();
        }

    }
    public static void dfs(int x,int y) // 행 렬
    {
        visited[x][y]=true;

        area++;
        for (int i = 0; i <4 ; i++) {
            int tempX=x+dx[i];
            int tempY=y+dy[i];
            if(tempX>=0 && tempX<n && tempY>=0 && tempY<n && !visited[tempX][tempY])
            {
                if(arr[x][y]==arr[tempX][tempY])
                {
                    dfs(tempX,tempY);
                }
            }
        }
    }
}
