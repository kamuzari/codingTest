package Programmers.LV3;

import java.util.Arrays;

/**
 * 요구사항 : 순위를 매길수 있는 선수는 몇명 인가?
 * 매커니즘 :
 * - 순위를 알려면 진입 차수와 진출 차수가 n-1개 여야 한다. 하지만 예제 1번에서 2번은 n-1개의 진입차수와 진출 차수를 가지고 있다.
 * 하지만, 5번 선수는 진출 차수가 1이다.(2번 한테 진다는 이야기) 진출 차수의 노드가 순위를 정할 수 있다면 해당 선수는 순위를 정할 수 있을까?
 * - 진출 차수의 노드가 순위를 정할 수 있다면 해당 선수는 순위를 항상 정할 수 있을까?(해결못함)
 * - 참조: https://tosuccess.tistory.com/47
 * - := 5번 선수는 진출 차수가 1이고 진입차수가 0인데 2번과 연결되어 있고 2번으로부터 모든 자기 자신(5번)을 제외하고 모든 정점과 연결돠어 있다.
 * 이것이 힌트였고, 해당 정점으로 도착할 수 있는 정점의 수, 해당 정점에서 출발할 수 있는 정점의 수 이 두값을 더했을 때 n-1이면 해당 정점의
 * 순위를 파악할 수 있게 된다. 현재 노드는 100개 플로이드 워셔러 100^3 := 백만이므로 1초안에 들어올 수 있다.
 */
public class Ranking {
    static final int INF = (int) 1e9;
    static final int CONNECT = 1;

    public int solution(int n, int[][] results) {
        int answer = 0;
        int dist[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist, INF);
        }

        for (int[] result : results) {
            dist[result[0]][result[1]] = CONNECT;
        }

        doFloyed(n, dist);
        for (int i = 1; i <=n; i++) {
            boolean flag=true;
            for (int j = 0; j <=n; j++) {
                if(i==j) continue;
                if(dist[i][j]==INF && dist[j][i]==INF){
                    flag=false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }

    private void doFloyed(int n, int[][] dist) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

}
