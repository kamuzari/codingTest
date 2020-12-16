package Al_Study.Basic_implemetation;

import java.util.Scanner;
import java.util.Arrays;

public class 기타줄 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            int M = sc.nextInt();
            int Min = Integer.MAX_VALUE;

        int[] pack = new int[M];
        int[] unit = new int[M];
            for (int i = 0; i < M; i++) {
                pack[i] = sc.nextInt();
                unit[i] = sc.nextInt();
            }
            Arrays.sort(unit);
            Arrays.sort(pack);
            // 비교 대상 3가지
        //가장 싼 6개짜리 팩 구매
        // 가장 싼 낱개 구매
        // (가장싼 6개짜리 팩 + 낱개)
            Min = Math.min(((N / 6) + 1) * pack[0], N * unit[0]);
            Min = Math.min(Min, ((N / 6)) * pack[0] + (N % 6) * unit[0]);

            System.out.println(Min);
        }
    }
