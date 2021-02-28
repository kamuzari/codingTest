package oneDay_twoSol.Implementation2.Group;

import java.util.Scanner;

public class Bingo {
    static int n = 5;
    static int[][] bingoPan = new int[5][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int moderator[] = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bingoPan[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n * n; i++) {
            moderator[i] = sc.nextInt();
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if(bingoPan[j][k]==moderator[i])
                        {
                            bingoPan[j][k]=0;
                            if(check(j,k)>=3)
                            {
                                System.out.println(i+1);
                                return;
                            }
                        }
                    }
                }
        }
    }
    static int FalseCode_checking(int y, int x)
    {
        int cnt=0;
        int rowCnt=0;
        // 다른 가로 세로 부분에서 빙고가 나올수 있으므로 모두 봐줘야 함. 부분이 아닌 전체를 봐야함..
        int colCnt=0;
        for (int i = 0; i < 5; i++) {
            if(bingoPan[y][i]==0)
                rowCnt++;
        }
        if(rowCnt==5)
            cnt++;

        for (int i = 0; i < 5; i++) {
            if(bingoPan[i][x]==0)
                colCnt++;
        }
        if(colCnt==5)
            cnt++;
        int ccnt=0;

        for (int i = 0; i < n; i++) {
            if(bingoPan[4-i][i]==0)
                ccnt++;
        }
        if(ccnt==5)
            cnt++;
        ccnt=0;
        for (int i = 0; i < n; i++) {
            if(bingoPan[i][4-i]==0)
                ccnt++;
        }
        if(ccnt==5)
            cnt++;

        return cnt;
    }
    private static int check(int r, int c) {
        // TODO Auto-generated method stub
        int cnt = 0;
        // 가로 방향 보기
        for (int i = 0; i < 5; i++) {
            int rcnt = 0;
            for (int j = 0; j < 5; j++) {
                if (bingoPan[i][j] == 0)
                    rcnt++;
            }
            if (rcnt == 5)
                cnt++;
        }

        // 세로 방향 보기
        for (int i = 0; i < 5; i++) {
            int ccnt = 0;
            for (int j = 0; j < 5; j++) {
                if (bingoPan[j][i] == 0)
                    ccnt++;
            }
            if (ccnt == 5)
                cnt++;
        }
        // 우상향 대각선 보기
        int ccnt = 0;
        for (int i = 4; i >= 0; i--) {

            if (bingoPan[4-i][i] == 0)
                ccnt++;
            if (ccnt == 5)
                cnt++;
        }

        // 우하향대각선
        ccnt= 0;
        for ( int i=0; i<5; i++) {
            if ( bingoPan[i][i] == 0 ) ccnt++;
            if (ccnt == 5) cnt ++;
        }
        return cnt;
    }

}
