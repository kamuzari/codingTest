package Al_Study.set0_APPENDIX_별찍기;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Star_11 {
    //높이 n  가로의 길이 2n-1
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr=new char[n+1][2*n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n; j++) {
                arr[i][j] = 'v';
            }
        }
        star_11(0, n - 1, n);

        //출력.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n - 1; j++) {
                bw.write(arr[i][j]+""); bw.flush();
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        sc.close();
    }
    static void star_11(int x, int y, int n) {
        if(n == 3) {
            // 더 이상 분할 할 수 없으므로 별을 그린다.
            arr[x][y] = '*';//                '*'
            arr[x + 1][y - 1] = '*';//      *
            arr[x + 1][y + 1] = '*'; //           *
            for(int j = y - 2; j <= y + 2; j++) {  // 밑변의 별
                arr[x + 2][j] = '*';
            }
            return;
        }

        star_11(x, y, n / 2); // 위 삼각형
        star_11(x + n / 2, y - n / 2, n/2); // 아래 왼쪽 삼각형
        star_11(x + n / 2, y + n / 2, n/2); // 아래 오른쪽 삼각형
    }
}
