package WeeklyThuseday.Implementation;

public class Key_Lock {
    public static void main(String[] args) {

    }

    public void rotate(int key[][])
    {
        int m=key.length;
        int temp[][]=new int[m][m];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <m ; j++) {
                temp[i][j]=key[m-1-j][i]; // rotate 공식
            }
        }
        key=temp;
        return;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int m=key.length;
        int n=lock.length;
        int cnt=0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if(lock[i][j]==0)
                    cnt++; // 홈부분.
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j =-21; j <=21; j++) {
                for (int k = -21; k <=21 ; k++) {
                    int _cnt=0;boolean flag=false;
                    for (int l = 0; l < m; l++) {
                        for (int o = 0; o < m; o++) {
                            int tempy=j+l;
                            int tempx=k+o;
                            if(0<=tempy && tempy<n && 0<=tempx && tempx<n)
                            {
                                if(lock[tempy][tempx]==1 && key[l][o]==1)
                                    flag=true;
                                else if(lock[tempy][tempx]==0 && key[l][o]==1)
                                    _cnt++;
                            }
                        }

                    }
                    if(_cnt==cnt && !flag)
                        return true;

                }

            }
            rotate(key);

        }
        return false;
    }
}
