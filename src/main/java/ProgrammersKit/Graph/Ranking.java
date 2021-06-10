package ProgrammersKit.Graph;

import java.util.Arrays;

public class Ranking {
    public int solution(int n, int[][] results) {
        int INF = 100001;
        int answer = 0;
        int[][] vertax = new int[n + 1][n + 1];
        for (int[] arr : vertax) {
            Arrays.fill(arr, INF);
        }
        for (int[] arr : results) {
            vertax[arr[0]][arr[1]] = 1;
        }
        for (int k = 1; k < vertax.length; k++) { //거치는 경로
            for (int i = 1; i < vertax.length; i++) { //시작 정점
                for (int j = 1; j < vertax.length; j++) { //도착 정점 ex) k-1, i-2, j-3 이면 2->3 > 2->1->3을 비교
                    if (vertax[i][j] > vertax[i][k] + vertax[k][j]) {
                        vertax[i][j] = vertax[i][k] + vertax[k][j];
                    }
                }
            }
        }
        for (int i = 1; i < vertax.length; i++) {
            boolean flag = true;
            for (int j = 1; j < vertax[i].length; j++) {
                if (i == j) continue;
                if (vertax[i][j] == INF && vertax[j][i] == INF) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++; //모든 정점에서 갈 수 있는 정점을 찾은 경우
        }
        return answer;

    }
}
