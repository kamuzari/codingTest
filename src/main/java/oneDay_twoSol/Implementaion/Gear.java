package oneDay_twoSol.Implementaion;

import java.util.*;

public class Gear {
    static int[][] gear;
    static int[] valid; // 0이면 안도는 것.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gear = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String str[] = sc.nextLine().split("");
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(str[j]); // 시계방향 순서대로. 12  2 3 4  6  8 9 10  24
            }
            // N극: 0, S극: 1
        }
//        for (int i = 0; i <4 ; i++) {
//            System.out.println(Arrays.toString(gear[i]));
//        }

        int k = sc.nextInt(); // 몇 번을 수행할 것인지.
        for (int i = 0; i < k; i++) {
            valid = new int[4]; // 방향을 알기위한 -1: 반시계 , 1:시계 방향.
            int x = sc.nextInt()-1;
            int dir = sc.nextInt();
            check(x, dir);  // 몇번 톱니바퀴 ,무슨방향.
            rotating(valid);
        /*    System.out.println("===============================");
            for (int q = 0; q < 4; q++) {
                System.out.println(Arrays.toString(gear[q]));
            }*/
        }
        System.out.println(calc());
    }

    static int calc() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int num = gear[i][0];

            if (num == 1) {
                sum += Math.pow(2, i);
            }
        }
        return sum;
    }

    static void check(int gearNumber, int direction) {
        valid[gearNumber] = direction;
        // 헤딩 톱니바퀴의 방향 저장.

        int left = gearNumber - 1;
        int right = gearNumber + 1;

        if (left >= 0 && valid[left] == 0) {
            // 현재바퀴의 6번쨰와 2번째와 맞닿아 있어 회전의 경우를 결정한다.
            if (gear[left][2] != gear[gearNumber][6]) // 서로 상극이여야 한다.
            {
                check(left, direction * -1); // 맞으면 반대방향. (재귀 형식으로 그다음 번호의 왼쪽 오른쪽 또한 호출)
            }
        }
        if (right <= 3 && valid[right] == 0) {
            if (gear[right][6] != gear[gearNumber][2]) {
                check(right, direction * -1);
            }
        }
    }

    static void rotating(int[] valid) {
        for (int i = 0; i < 4; i++) {
            if (valid[i] != 0) {
                int[] temp = new int[8];
                int index;
                for (int j = 0; j < 8; j++) {
                    index = j + valid[i]; // 시작점 포인터
                    if (index == -1) {
                        index = 7;
                    } else if (index == 8) {
                        index = 0;
                    }
                    temp[index] = gear[i][j];
                }
                gear[i] = temp; // overwrite
            }
        }
    }
}
