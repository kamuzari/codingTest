package WeeklyThurseday.DFS_BFS;

import java.util.*;

public class teenager_Shark {
    static int n;
    static ArrayList<Integer> Area; // 이 구역이 사이즈가 영역의 개수.
    static fish arr[][];
    static boolean visited[][];
    static int area;
    static int dx[]={0,-1,-1, 0, 1,1,1, 0,-1};
    static int dy[]={0, 0,-1,-1,-1,0,1,-1, 1};
    // 1,2,3,4,5,6,7,8 == 위 ,2사분면,왼쪽, 3사분면, 아래, 4사분면, 오른쪽, 1사분면
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=4;
        arr=new fish[4][4];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                arr[i][j]=new fish(sc.nextInt(),sc.nextInt());
            }
        }

        for (int i = 0; i <n ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        // 일단 가까운 거리에 큰거 부터 잡아먹자
        // SecurityArea
        visited=new boolean[n][n];
        fish shark=new fish(17,0);
        shark.direction=arr[0][0].direction;
        shark.total=arr[0][0].id;
        visited[0][0]=true;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n ; j++) {
                if(!visited[i][j])
                {
                    dfs(i,j);
                }
            }
        }
        System.out.println(shark.total);
    }
    static void dfs(int x,int y)
    {
        visited[x][y]=true;

        for (int i = 0; i <9 ; i++) {
            int tempX=x+dx[i];
            int tempY=y+dy[i];
            if(tempX>=0 && tempX<n && tempY>=0 && tempY<n && !visited[tempX][tempY])
            {

            }
        }
    }
    static boolean foundShark(int x,int y)
    {
        if(arr[x][y].id==17)
        {
            return true;
        }
        return false;
    }
    static class fish{
        private int id;
        private int direction;
        public int total;

        public fish(int id, int direction) {
            this.id = id;
            this.direction = direction;
        }


        @Override
        public String toString() {
            return "fish{" +
                    "id=" + id +
                    ", direction=" + direction +
                    '}';
        }
    }

    static void swap(fish a,fish b)
    {
        fish temp=a;
        a=b;
        b=temp;

    }
}
