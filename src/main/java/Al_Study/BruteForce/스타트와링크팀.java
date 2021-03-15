package Al_Study.BruteForce;

import java.util.*;

public class 스타트와링크팀 {
    static int ablity[][];
    static boolean visited[];
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ablity = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            String str[] = sc.nextLine().split(" ");
            for (int j = 1; j <= n; j++) {
                ablity[i][j] = transInt(str[j - 1]);
            }
        }
       /* for (int i = 1; i <=n ; i++) {
            System.out.println(Arrays.toString(ablity[i]));
        }*/
        comb(1, 0); // 순서가 1,3 뽑은 거랑 3,1로 뽑은 거랑 같다.
        System.out.println(min);

    }

    static void comb(int idx, int depth) {
        if (depth == n / 2) {
            /*System.out.println();
            for (int i = 1; i <visited.length ; i++) {
                if(visited[i])
                    System.out.println(i+"번쨰 선택.");
            }
            System.out.println();*/
            comparison();
        } else {
            for (int i = idx; i <= n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    comb(i + 1, depth + 1);
                    visited[i] = false;
                }
            }
        }

    }

    static void comparison() {
        int startTeam = 0; // 방문한 것이 true면 start팀.
        int linkTeam = 0; // 방문 안한 것이 false면 link 팀

        for (int i = 1; i < visited.length; i++) {
            for (int j = i+1; j < visited.length; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += ablity[i][j];
                    startTeam += ablity[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += ablity[i][j];
                    linkTeam += ablity[j][i];
                }
            }
        }
        int gap = Math.abs(startTeam - linkTeam);

        if (gap == 0) {
            System.out.println(gap);
            System.exit(0);
        }

        min = Math.min(gap, min);

    }

    static int transInt(String str) {
        return Integer.parseInt(str);
    }
}
