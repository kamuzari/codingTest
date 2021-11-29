package BaekJoon.SolvedAC4;

import java.io.*;
import java.util.StringTokenizer;

/*
--- try ---
1. 7% : RuntimeError  := 입력 이중 for문 COLUMN 오류 예상.
2. 7% : False :=  오타(dpMin 구하기)
    반례
    4
    1 1 0
    2 3 3
    3 2 3
    1 0 1
    output : 8 6
    correct answer : 8,5
*/
public class BOJ2096_GoDown {
    static final int COLUMN=3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int pos[][]=new int[n][COLUMN];
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < COLUMN; j++) {
                pos[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int dpMax[][]=new int[n][COLUMN];
        int dpMin[][]=new int[n][COLUMN];

        for (int i = 0; i < n; i++) {
            dpMax[i]=pos[i].clone();
            dpMin[i]=pos[i].clone();
        }

        for (int i = 1; i <n ; i++) {
            dpMax[i][0]+=Math.max(dpMax[i-1][0],dpMax[i-1][1]);
            dpMax[i][1]+=Math.max(dpMax[i-1][0],Math.max(dpMax[i-1][1],dpMax[i-1][2]));
            dpMax[i][2]+=Math.max(dpMax[i-1][1],dpMax[i-1][2]);

            dpMin[i][0]+=Math.min(dpMin[i-1][0],dpMin[i-1][1]);
            dpMin[i][1]+=Math.min(dpMin[i-1][0],Math.min(dpMin[i-1][1],dpMin[i-1][2]));
            dpMin[i][2]+=Math.min(dpMin[i-1][1],dpMin[i-1][2]);
        }

        int answerMax=Math.max(dpMax[n-1][0],Math.max(dpMax[n-1][1],dpMax[n-1][2]));
        int answerMin=Math.min(dpMin[n-1][0],Math.min(dpMin[n-1][1],dpMin[n-1][2]));
        System.out.println(answerMax+" "+answerMin);
    }
}
