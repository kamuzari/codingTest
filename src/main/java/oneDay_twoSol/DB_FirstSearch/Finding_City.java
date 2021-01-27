package oneDay_twoSol.DB_FirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Finding_City {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int n, m, k, x;
    static int cnt = 0;
    static int distance[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        distance = new int[n + 1];

        int k = sc.nextInt();
        int x = sc.nextInt();

        // 인접 리스트 사용.
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<Integer>());
            distance[i]=-1;  // 전체 초기화
        }

        //방향이 있는 그래프 (무방향은 반대의 리스트도 입력해야 한다.)
        for (int i = 0; i < m; i++) {
            adjList.get(sc.nextInt()).add(sc.nextInt());
        }


        distance[x] = 0; // 출발 지점의 vertax를 0으로 초기화 자기 자신에게 가는 거리는 0

        // bfs
        Queue<Integer> q = new LinkedList<>();

        q.offer(x); // 시작 정점을 큐에 넣고.

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 0; i < adjList.get(current).size(); i++) {
                int next = adjList.get(current).get(i);
                if (distance[next] == -1) // 기존 인접한 부분이 탐색이 안되었다면.(탐색이 되면 다른 인접한 정점이 있는 것.
                {
                    distance[next] = distance[current] + 1; // 현재 정점에서 갈수있는 정점의 배멸에 +1을 추가.
                    q.offer(next);
                }

            }
        }
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            // 해당 정점에서 거리가 k인 값이 있으면 출려하고 없으면 -1을 출력하기 위해 check 라는 플래그 사용.
            if (distance[i] == k) {
                System.out.println(i);
                check = true;
            }
        }
        if(!check)
        {
            System.out.println(-1);
        }
    }

}


