package TestSE.스코페;

import java.util.ArrayList;
import java.util.Scanner;

public class three {
    static int map[][];
    static ArrayList<Integer> areaSize = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        int size[] = new int[n + 1];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[] = sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        int cnt = 1;
        while (true) {
            if (cnt >= n + 1)
                break;
            int area = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (solve(i, j, cnt)) {
                        area++;
                    }
                }
            }
            areaSize.add(area);
            cnt++;
        }

        int total[] = {0};
//        System.out.println(Arrays.toString(size));
        areaSize.stream().forEach(integer -> {
            total[0] += integer;
        });
        System.out.println("total: " + total[0]);
        for (int i = 0; i < areaSize.size(); i++) {
//            if (areaSize.get(i) != 0)
                System.out.println("size[" + (i + 1) + "]: " + areaSize.get(i));
        }


    }

    static boolean solve(int y, int x, int cnt) {
        for (int i = y; i < y + cnt; i++) {
            for (int j = x; j < x + cnt; j++) {
                if (map[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
}
