package Wed_aWeek_Study.Al_Study.set0_APPENDIX_별찍기;

import java.util.Scanner;
public class Star_18
{
    static char arr[][]=new char[1023][2045];
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
//        arr=new char[(int)Math.pow(2,n+1)-3][(int)Math.pow(2,n)-1];
        // 공백 초기화
        init();
        // 높이 넓이 규칙.
        int height=(1<<n)-1;
        int width=2*height-1;
    }
    public static void init()
    {
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                arr[i][j]=' ';
            }
        }
    }
    public static void star(int depth,int x,int y) {
        arr[y][x] = '*';
        if (depth == 1)
            return;
        int height=(1<<depth)-1;
        int left,right;
        left=y;
        right=y;
        for (int i = 1; i <height; i++) {
            if(depth%2==0)
                x--;
            else
                x++;

            left--;right++;
            arr[x][left]='*';
            arr[x][right]='*';
        }
        for (int i = left+1; i <right ; i++) {
            arr[x][i]='*';
        }

        if(depth%2==0)
            x++;
        else
            x--;
        star(depth-1,x,y);



    }
}
