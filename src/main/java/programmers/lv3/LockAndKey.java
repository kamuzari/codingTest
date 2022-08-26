package programmers.lv3;

public class LockAndKey {
    static final int DIR = 4;
    static int lockLen, keyLen;

    public boolean solution(int[][] key, int[][] lock) {
        lockLen = lock.length;
        keyLen = key.length;
        int sizeUpLock[][] = new int[lockLen * 3][lockLen * 3];
        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) {
                sizeUpLock[lockLen + i][lockLen + j] = lock[i][j];
            }
        }
        for (int dir = 0; dir < DIR; dir++) {
            key = rotateKey(key);
            for (int startRow = 0; startRow < lockLen * 2; startRow++) {
                for (int startCol = 0; startCol < lockLen * 2; startCol++) {
                    // 덧칠하기
                    for (int i = 0; i < keyLen; i++) {
                        for (int j = 0; j < keyLen; j++) {
                            sizeUpLock[startRow + i][startCol + j] += key[i][j];
                        }
                    }
                    if (isAllOne(sizeUpLock)) {
                        return true;
                    }
                    // 지우기
                    for (int i = 0; i < keyLen; i++) {
                        for (int j = 0; j < keyLen; j++) {
                            sizeUpLock[startRow + i][startCol + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    public int[][] rotateKey(int[][] key) {
        int temp[][] = new int[keyLen][keyLen];
        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                temp[i][j] = key[keyLen - 1 - j][i];
            }
        }
        return temp;
    }

    public boolean isAllOne(int[][] sizeUpLock) {
        for (int i = lockLen; i < lockLen * 2; i++) {
            for (int j = lockLen; j < lockLen * 2; j++) {
                if (sizeUpLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
