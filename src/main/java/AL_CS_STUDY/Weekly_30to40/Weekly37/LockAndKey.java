package AL_CS_STUDY.Weekly_30to40.Weekly37;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        LockAndKey lockAndKey = new LockAndKey();
        System.out.println(lockAndKey.solution(key, lock));
    }

    static final int DIRECTION = 4;
    int lockLength = 0;
    int keyLength = 0;

    public boolean solution(int key[][], int lock[][]) {
        lockLength = lock.length;
        keyLength = key.length;
        int expandLock[][] = new int[lock.length * 3][lock.length * 3];
        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                expandLock[lockLength + i][lockLength + j] = lock[i][j];
            }
        }
        for (int dir = 0; dir < DIRECTION; dir++) {
            key = ClockRotate(key);
            for (int row = 0; row < lockLength * 2; row++) {
                for (int col = 0; col < lockLength * 2; col++) {
//                    System.out.println();
//                    System.out.println("키 넣기 전");
//                    Arrays.stream(expandLock).forEach(ints -> System.out.println(Arrays.toString(ints)));
                    for (int i = 0; i < keyLength; i++) {
                        for (int j = 0; j < keyLength; j++) {
                            expandLock[row + i][col + j] += key[i][j];
                        }
                    }
//                    System.out.println("키 넣기 후");
//                    Arrays.stream(expandLock).forEach(ints -> System.out.println(Arrays.toString(ints)));

                    boolean everyElementsOne = isEveryElementsOne(expandLock);
                    if (everyElementsOne)
                        return true;
                    else {
                        for (int i = 0; i < keyLength; i++) {
                            for (int j = 0; j < keyLength; j++) {
                                expandLock[row + i][col + j] -= key[i][j];
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public int[][] ClockRotate(int key[][]) {
        int temp[][] = new int[keyLength][keyLength];
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                temp[i][j] = key[keyLength - 1 - j][i];
            }
        }
        return temp;
    }

    public boolean isEveryElementsOne(int[][] lock) {
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (lock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
