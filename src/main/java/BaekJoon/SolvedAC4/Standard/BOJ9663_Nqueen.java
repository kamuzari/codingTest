package BaekJoon.SolvedAC4.Standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663_Nqueen {

    static int n;
    static int answer;
    static int positionOfHorses[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        positionOfHorses = new int[n];
        for (int i = 0; i < n; i++) {
            positionOfHorses[0] = i;
            pick(1);
        }
        System.out.println(answer);
    }

    static void pick(int currentHorse) {
        if (currentHorse == n) {
            answer++;
            return;
        }
        for (int positionToBePick = 0; positionToBePick < n; positionToBePick++) {
            if (promising(currentHorse, positionToBePick)) {
                pick(currentHorse + 1);
            }
        }
    }

    static boolean promising(int currentHorseIdx, int currentPosition) {
        positionOfHorses[currentHorseIdx] = currentPosition;
        for (int previousHorsePosition = 0; previousHorsePosition < currentHorseIdx;
            previousHorsePosition++) {
            if (isSameColumn(previousHorsePosition, currentHorseIdx)) {
                return false;
            } else if (isExistOnDiagonal(previousHorsePosition, currentHorseIdx)) {
                return false;
            }
        }
        return true;
    }

    static boolean isSameColumn(int placedPosition, int positionTobePlaced) {
        return positionOfHorses[placedPosition] == positionOfHorses[positionTobePlaced];
    }

    static boolean isExistOnDiagonal(int horse1, int horse2) {
        return Math.abs(horse1 - horse2) == Math
            .abs(positionOfHorses[horse1] - positionOfHorses[horse2]);
    }

}
