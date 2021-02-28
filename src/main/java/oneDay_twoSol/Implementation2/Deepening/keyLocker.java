package oneDay_twoSol.Implementation2.Deepening;

public class keyLocker {
    public static void main(String[] args) {
        int key[][]={
                {0,0,0},
                {1,0,0},
                {0,1,1}
        };
        int lock[][]={
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
       boolean flag= solution(key,lock);
        System.out.println(flag);
    }
    // 4번 돌리고
    // 체크
    // 이동
    static int[][] rotate(int key[][])
    {
        int len=key.length;
        int temp[][]=new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <len; j++) {
                temp[i][j]=key[len-1-j][i];
            }
        }
        return temp;
    }
    public static boolean solution(int key[][], int lock[][]) {
        int keyLen=key.length;
        int lockLen=lock.length;
        int expandLock[][]=new int[lockLen+(2*keyLen)][lockLen+(2*lockLen)];
        for (int i = 0; i <lockLen ; i++) {
            for (int j = 0; j < lockLen; j++) {
                expandLock[keyLen+i][keyLen+j]=lock[i][j];
            }
        }
        for (int r = 0; r < 4; r++) {
            key=rotate(key);
            for (int h = 0; h <keyLen+lockLen ; h++) {
                for (int w = 0; w <keyLen+lockLen ; w++) {
                    boolean flag=true;
                    // key 를 만춰봄.
                    for (int i = 0; i <keyLen ; i++) {
                        for (int j = 0; j < keyLen; j++) {
                            expandLock[h+i][w+j]+=key[i][j];
                        }
                    }
                    for (int i = keyLen; i <keyLen+lockLen ; i++) {
                        for (int j = keyLen; j < keyLen + lockLen; j++) {
                            if (expandLock[i][j] != 1) {
                                flag = false;
                            }
                        }
                    }
                    if(flag)
                    {
                        return true;
                    }
                    for (int i = 0; i <keyLen ; i++) {
                        for (int j = 0; j < keyLen; j++) {
                            expandLock[h+i][w+j]-=key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

}
