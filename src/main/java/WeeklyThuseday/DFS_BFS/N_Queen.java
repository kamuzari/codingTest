package WeeklyThuseday.DFS_BFS;

import java.util.Scanner;
public class N_Queen {
    static int[] x={1,-1,0,0};
    static int[] y={0,0,1,-1};
    static int arr[];
    static int n;
    static boolean visited[][];
    static int cnt;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        DFS(0);
        System.out.println(cnt);
    }
    static void DFS(int depth)
    {
        // 깊이가 n이면 종료. // 모든 행 또는 각 y축에 놓을 퀸의 위치가 정해지면 종료.
        if(depth==n) {
            cnt++;
            return;
        }
        for (int i = 0; i <n ; i++) {
            arr[depth]=i;
            if(possible(depth))// 이부분이 BackTracking 핵심 그다음 위치에 놓을 자리가 유망한지 유망하지 않은지를 재고 다음 함수를 실행시킬지 결정하는 구간.
                DFS(depth+1);
        }
    }
    static boolean possible(int x)
    {
        for (int i = 0; i <x ; i++) {
            if(arr[x]==arr[i])  // 각 x의  위치가 같다는 말은 바로 아랫칸 이라는 뜻.
                return false;
            else if(Math.abs(x-i) == Math.abs(arr[x]-arr[i])) // 서로의 위치에서 x축끼리 뺸값 == y축을 뺸 값이 (대각 선 상에 존재하는 것이므로 위치할 수 없다.)
                 return false;
        }
        return true;
    }
}
