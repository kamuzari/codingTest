package oneDay_twoSol.graphTheory.Grouping;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hide_And_Seek2 {

    static int dx[] = {-1, 1, 2};
    static int n, k;
    static int posit[];
    static int minT = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        posit = new int[100001];
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        if(n>=k)
        {
            System.out.println(n-k);
            System.out.println(1);
        }
        else {
            bfs(n);
            System.out.println(minT);
            System.out.println(cnt);
        }
    }

    static int cnt = 0;

    static void bfs(int subin) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(subin);// 수빈이의 위치를 넣고
        posit[subin] = 1; //수빈이의 위치를 처음 1로 초기화
        while (!q.isEmpty()) {
            int cur = q.poll(); // 현재 큐에서 뽑은 위치를 기반으로
            if (minT < posit[cur])
                return;
            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if (i != 2) {
                    nx = cur + dx[i];
                } else {
                    nx = cur * dx[i];
                }
                if (nx < 0 || nx > 100000) continue;

// 5 4 8 16 17 _ -> 큐 5 10 9 18 17 _  post[17]=4; //

                if (nx == k) {
                    minT = posit[cur];
                    cnt++; // 빠르게 도달하는 횟수 춧;
                }
                // 해당 시작 정점이 이미 정해져 있어서 만약 2에서 출발하게 되어
                // posit[nx] == posit[cur] + 1 이미 이전에 왔던 길로 해서 최소의 거리를 만들 었으면 그 점이 최단이여서. 볼필요가 없다??
                if (posit[nx] == 0 || (posit[nx] > posit[cur] + 1)) {
                    // 한번 방문하지 않았다면. -> 방문해도 상관 없지만 이전보다 거리가 크면 안됨..
                    q.add(nx);
                    posit[nx] = posit[cur] + 1; // 현재 큐에서 꺼내온 위치를 기준으로  +1;
                }
            }
        }
    }

}
