package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465_Sticker {

    static final int DEFAULT_ROW = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answers = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int sticker[][] = new int[DEFAULT_ROW+1][n];
            for (int i = 1; i <= DEFAULT_ROW; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = dynamic(sticker, n);
            answers.append(answer).append("\n");
        }
        System.out.println(answers);
    }

    public static int dynamic(int[][] sticker, int n) {
        sticker[1][1] += sticker[2][0];
        sticker[2][1] += sticker[1][0];
        for (int col = 2; col < n; col++) {
            sticker[1][col] += Math.max(sticker[2][col - 1], sticker[2][col - 2]);
            sticker[2][col] += Math.max(sticker[1][col - 1], sticker[1][col - 2]);
        }
        return Math.max(sticker[1][n-1],sticker[2][n-1]);
    }
    /*
        Q. 전 대각선 전전 대각선인 이유가 과연 정당할 까?
        Q. 그 전단계 대각선을 보는데 전전대각선을 보는 이유가 뭘까?
        Q. 전전 대각선 밑은 왜 안보는 것인가?


        ---> 이쪽 방향임을 고려하고 이전의 값의 현재 위치에 어떻게 영향을 끼칠까라고 생각해봤을 때,
        해당 위치 오른쪽은 생각하지 않는다. 바로 <-- 이쪽만을 생각한다. 다음값의 영향은 신경쓰지 않는다.

        i,j = [i-1 or i+1] , [j-1]  OR [i][j-2]


        대각선 대로 뽑으면 값이 중복된다 해당 행의 전전 값과 현재 행과 다른 행이 였을 때는
        [i][j-2] ==> [현재 행과 다른 행 ] [j-1] := 이미 이 값은 [i][j-2] 값이 영향을 끼쳐 있다.

        그렇기 때문에 현재 점에서 이전의 값이 영향을 끼치는지 보았을 때,
        현재 행과 다른 j-1 번째와 다른 j-2번째의 값을 비교해야 중복이 일어나지 않는다.



    */

}
