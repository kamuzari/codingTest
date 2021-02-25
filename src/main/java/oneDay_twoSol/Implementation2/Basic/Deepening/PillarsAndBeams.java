package oneDay_twoSol.Implementation2.Basic.Deepening;

import java.util.Arrays;

public class PillarsAndBeams {
//    private static boolean[][] pillars;
//    private static boolean[][] beams;

    public static void main(String[] args) {
//기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
//보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
        int n = 5;
        int arr[][] = {
                {1, 0, 0, 1}, {1, 1, 1, 1},
                {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1},
                {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}
        };
        int a[][]=solution(5,arr);
        int i=0;
        for (int[] aa : a) {
            System.out.println(Arrays.toString(aa));
        }
        System.out.println();
    }

//        static final int PILLAR = 0;
//        static final int BEAM = 1;
//        static final int DESTRUCT = 0;
//        static final int CONSTRUCT = 1;
//
//
//        public static int[][] solution ( int n, int[][] build_frame){
//            int structureCount = 0;
//
//            pillars = new boolean[n + 3][n + 3];
//            beams = new boolean[n + 3][n + 3];
//
//            for (int[] frame : build_frame) {
//                int x = frame[0] + 1;
//                int y = frame[1] + 1;
//                int structureType = frame[2];
//                int commandType = frame[3];
//
//                if (commandType == CONSTRUCT) {
//                    if (structureType == PILLAR && canConstructPillar(x, y)) {
//                        pillars[x][y] = true;
//                        structureCount++;
//                    }
//                    if (structureType == BEAM && canConstructBeam(x, y)) {
//                        beams[x][y] = true;
//                        structureCount++;
//                    }
//                } else if (commandType == DESTRUCT) {
//                    if (structureType == PILLAR) {
//                        pillars[x][y] = false;
//                    } else if (structureType == BEAM) {
//                        beams[x][y] = false;
//                    }
//
//                    if (canDestruct(x, y, structureType, n)) {
//                        structureCount--;
//                        continue;
//                    }
//
//                    if (structureType == PILLAR) {
//                        pillars[x][y] = true;
//                    } else if (structureType == BEAM) {
//                        beams[x][y] = true;
//                    }
//                }
//            }
//
//            int index = 0;
//            int[][] answer = new int[structureCount][3];
//
//            for (int i = 1; i <= n + 1; ++i) {
//                for (int j = 1; j <= n + 1; ++j) {
//                    if (pillars[i][j]) answer[index++] = new int[]{i - 1, j - 1, PILLAR};
//                    if (beams[i][j]) answer[index++] = new int[]{i - 1, j - 1, BEAM};
//                }
//            }
//            return answer;
//        }
//
//        private static boolean canConstructPillar ( int x, int y){
//            return y == 1 || pillars[x][y - 1] || beams[x][y] || beams[x - 1][y];
//        }
//
//        private static boolean canConstructBeam ( int x, int y){
//            return pillars[x][y - 1] || pillars[x + 1][y - 1] || (beams[x - 1][y] && beams[x + 1][y]);
//        }
//
//        private static boolean canDestruct ( int x, int y, int structureType, int n){
//            for (int i = 1; i <= n + 1; ++i) {
//                for (int j = 1; j <= n + 1; ++j) {
//                    if (pillars[i][j] && !canConstructPillar(i, j)) {
//                        return false;
//                    }
//                    if (beams[i][j] && !canConstructBeam(i, j)) {
//                        return false;
//                    }
//                }
//            }
//
//            return true;
//        }
    static boolean[][] pillars;
    static boolean[][] beam;
    static int n;

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int cnt=0;
        // 보를 제거할 때.
        pillars = new boolean[n+3][n+3];
        beam = new boolean[n+3][n+3];
        n = n;

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int kind = build_frame[i][2];
            int setUnset = build_frame[i][3];
            if (setUnset == 1) // 설치
            {
                if (kind == 0 && isConstruct(y, x, kind)) {
                    pillars[y][x] = true;
                    cnt++;
                } else {
                    if (isConstruct(y, x, kind)) {
                        beam[y][x] = true;
                        cnt++;
                    }
                }
            } else // 파괴
            {
                if (kind == 0) {
                    pillars[y][x] = false;
                } else
                    beam[y][x] = false;
                if (!isDestroy(y, x, kind)) {
                    if (kind == 0) {
                        pillars[y][x] = true;
                    } else {
                        beam[y][x] = true;
                    }
                }
                else
                    cnt--;
            }

        }
        int index = 0;
        answer= new int[cnt][3];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (pillars[i][j])
                    answer[index++] = new int[]{j, i, 0};
                if (beam[i][j])
                    answer[index++] = new int[]{j, i, 1};
            }
        }
        return answer;
    }

    private static boolean isConstruct(int y, int x, int kind) {
        if (kind == 0) { // 기둥일떄
            // 바닥에 있거나 ,보가 바로 밑에 있거나 , 보 옆쪽에 설치가 되있거나.
            return y == 0 || beam[y][x] || beam[y][x - 1] || pillars[y - 1][x]; //?  pillars[y][x-1]
        } else {  // 보일떄
            // 옆에보가 있거나 ,
            return pillars[y - 1][x] || pillars[y - 1][x + 1] || (beam[y][x - 1] && beam[y][x + 1]);
        }
    }

    private static boolean isDestroy(int y, int x, int kind) {
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillars[i][j] && !isConstruct(i, j, kind)) {
                    return false;
                }
                if (beam[i][j] && !isConstruct(i, j, kind))
                    return false;
            }
        }
        return true;
    }
    }
