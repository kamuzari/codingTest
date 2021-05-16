package WeeklyThurseday.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hide_Seek {
    static int subin,bro;
    static int[] check = new int[100001]; // 수빈과 동생의 위치.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        subin=Integer.parseInt(str[0]);
        bro=Integer.parseInt(str[1]);
        if (subin==bro)
            System.out.println(0);
        else
        {
            bfs(subin);
        }
    }


    public static void bfs(int position)
    {
        // 너비우선 탐색.
        Queue<Integer>q =new LinkedList<>();
        q.add(position);
        check[position] = 1;
        // 큐에 있는 것이 수빈의 위치가 동생이랑 맞을 때까지!  모든 경우의 수를 탐색하는 것이다.
        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }
                // 위치가 같으면 출력
                if (next == bro) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
        System.out.println();
    }
}
