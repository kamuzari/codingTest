package Basic.SolvedAC3;

import java.io.*;

public class BOJ1913_Snail {

    private static StringBuffer answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] snail = new int[n][n];

        int loop = n;
        int idx = n * n;
        int right = 0;
        int bottom = -1;
        int top = 1;

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < loop; j++) {
                bottom += top;
                snail[bottom][right] = idx--;
            }
            loop--;
            for (int j = 0; j < loop; j++) {
                right += top;
                snail[bottom][right] = idx--;
            }
            top = top * (-1);
        }

        print(snail, target);


    }

    private static void print(int[][] snail, int target) {
        answer = new StringBuffer();
        int answers[] = new int[2];
        for (int i = 0; i < snail.length; i++) {
            for (int j = 0; j < snail[i].length; j++) {
                if (snail[i][j] == target) {
                    answers[0] = i + 1;
                    answers[1] = j + 1;
                }
//                System.out.printf("%2d ", snail[i][j]);
                answer.append(snail[i][j]+" ");
            }
            answer.append("\n");
        }
        answer.append(answers[0] + " " + answers[1]);
        System.out.println(answer);;
    }
}
