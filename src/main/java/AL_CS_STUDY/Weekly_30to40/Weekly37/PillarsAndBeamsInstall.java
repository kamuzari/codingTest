package AL_CS_STUDY.Weekly_30to40.Weekly37;

import java.util.Arrays;

public class PillarsAndBeamsInstall {
    public static void main(String[] args) {
        int[][] a = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        PillarsAndBeamsInstall pillarsAndBeamsInstall = new PillarsAndBeamsInstall();
        int[][] solution = pillarsAndBeamsInstall.solution(5, a);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(Arrays.toString(solution[i]));
        }

        int[][] b = {
                {0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}
        };
        int[][] solution1 = pillarsAndBeamsInstall.solution(5, b);
        for (int i = 0; i < solution1.length; i++) {
            System.out.println(Arrays.toString(solution1[i]));
        }

    }

    final int PILLAR = 0; //기둥
    final int BEAM = 1; // 보
    final int DESTROY = 0;
    final int INSTALL = 1;


    boolean pillars[][];
    boolean beam[][];

    public int[][] solution(int n, int[][] build_frame) {

        pillars = new boolean[n + 2][n + 2];
        beam = new boolean[n + 2][n + 2];
        int updateCount = 0;
        for (int[] row : build_frame) {
            int x = row[0];
            int y = row[1];
            int type = row[2];
            int cmd = row[3];
            if (type == PILLAR) {
                if (cmd == INSTALL) {
                    if (checkPillar(x, y)) {
                        pillars[x][y] = true;
                        updateCount++;
                    }
                } else if (cmd == DESTROY) {
                    pillars[x][y] = false;
                    if (!canDelete(x, y)) {
                        pillars[x][y] = true;
                    } else {
                        updateCount--;
                    }
                }
            } else if (type == BEAM) {
                if (cmd == INSTALL) {
                    if (checkBeam(x, y)) {
                        beam[x][y] = true;
                        updateCount++;
                    }
                } else if (cmd == DESTROY) {
                    beam[x][y] = false;
                    if (!canDelete(x, y)) {
                        beam[x][y] = true;
                    } else {
                        updateCount--;
                    }
                }
            }
        }

        int answers[][] = new int[updateCount][3];
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillars[i][j]) {
                    answers[cnt][0] = i;
                    answers[cnt][1] = j;
                    answers[cnt++][2] = PILLAR;
                }
                if (beam[i][j]) {
                    answers[cnt][0] = i;
                    answers[cnt][1] = j;
                    answers[cnt++][2] = BEAM;
                }
            }
        }
        return answers;
    }

    private boolean canDelete(int x, int y) {
        for (int i = Math.max(x - 1, 0); i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {
                if (pillars[i][j] && !checkPillar(i, j)) {
                    return false;
                } else if (beam[i][j] && !checkBeam(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBeam(int x, int y) {
        if (y > 0 && (pillars[x][y - 1] || pillars[x + 1][y - 1]))
            return true;
        if (x > 0 && beam[x - 1][y] && beam[x + 1][y])
            return true;
        return false;
    }

    private boolean checkPillar(int x, int y) {
        if (y == 0 || pillars[x][y - 1])
            return true;
        if ((x > 0 && (beam[x - 1][y]) || beam[x][y]))
            return true;
        return false;
    }
}
