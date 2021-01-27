package oneDay_twoSol.Implementaion;

public class Key_Lock {
    public static void main(String[] args) {
        int [][]key={
            {0,0,0},
            {1,0,0},
            {0,1,1}
        };
        int [][]lock={
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        System.out.println(solution(key,lock));
        System.out.println("--------------");
    }
    public static int [][]  rotating(int arr[][])
    {
        int y=arr.length;
        int x=arr[0].length;
        int temp[][]=new int[y][x];
        for (int i = 0; i <y ; i++) {
            for (int j = 0; j <x ; j++) {
                temp[j][y-i-1]=arr[i][j];
            }
        }
        return temp;
    }

    public static boolean check(int ExpandLock[][])
    {
        int len = ExpandLock.length/3;
        for (int i =len; i <len*2 ; i++) {
            for (int j = len; j <len*2 ; j++) {
                if(ExpandLock[i][j]!=1)
                    return false;
            }
        }
        return true;
    }
    public static boolean solution(int[][] key, int[][] lock) {
        int n=lock.length; // 락의 행
        int m=key.length; // 키의 행.

        //자물쇠 크기 3배로 확장
        int[][] ExpandLock =new int[n*3][n*3];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                ExpandLock[i+n][j+n]=lock[i][j];
            }
        }

        // 회전 4가지 경우 확인 (0도, 90도 180도 270도 ,<360은 0도와 동일 그래서 제외>)

        for (int rotate = 0; rotate <4 ; rotate++) {
            key=rotating(key);
            for (int i = 0; i <n*2 ; i++) {
                for (int j = 0; j <n*2 ; j++) {

                    for (int k = 0; k <m ; k++) {
                        for (int l = 0; l <m ; l++) {
                            ExpandLock[i+k][j+l]+=key[k][l];
                        }
                    }
                    if(check(ExpandLock))
                        return true;

                    for (int k = 0; k <m ; k++) {
                        for (int l = 0; l <m ; l++) {
                            ExpandLock[i+k][j+l]-=key[k][l];
                        }
                    }
                }
            }
        }

        return false;
    }


}
