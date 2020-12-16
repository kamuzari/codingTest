/*
package Al_Study.set0_APPENDIX_별찍기;

import java.util.Scanner;
public class Star_18 {
    static char arr[][];
    // 홀수 일때는 꼭짓점이 위로 짝수일때는 꼭지점이 아래로 규칙.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr=new char[(int) (Math.pow(2,n)-1)][(int)Math.pow(2,n+1)-3];

        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                arr[i][j]=' ';
            }
        }




    }
    public static void Star_19(int s, int len) {
        if (len<=s) return;

        for (int i = s; i < len; i++) {
            star[s][i] = '*'; //맨 위 가로줄
            star[len - 1][i] = '*'; //맨 아래 가로줄
            star[i][s] = '*'; //왼쪽 세로줄
            star[i][len - 1] = '*'; //오른쪽 세로줄
        }


        // 별을 좌표라고 생각할 때 겉테두리의 사각형과 가장 근접한 사각형을 보았을 때 2만큼의 차이가 난다
        Star_19(s + 2, len - 2);
    }
    public static void Star_18(int row,int col,int n)
    {
        // 짝수일 떄.
        for (int i = 0; i < ; i++) {

        }
        // 홀수일때.

        Star_18();
    }
}
*/
