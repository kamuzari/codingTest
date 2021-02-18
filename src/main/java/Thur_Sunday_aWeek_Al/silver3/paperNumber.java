package Thur_Sunday_aWeek_Al.silver3;

import java.util.Scanner;

public class paperNumber {
    static int papaer[][];
    static int mone,zero,one;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        papaer = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                papaer[i][j] = sc.nextInt();
            }
        }
        mone=0;
        zero=0;
        one=0;
        divide(n,0,0);
        System.out.println(mone);
        System.out.println(zero);
        System.out.println(one);
    }

    static void divide(int size, int y, int x)
    {
        if(check(size,y,x))
        {
            if(papaer[y][x]==-1)
                ++mone;
            else if(papaer[y][x]==1)
                ++one;
            else
                ++zero;
            return;
        }
        // 분할이 되야하면 .
        // 2열까지
        divide(size/3,y,x); //  0행 2열까지
        divide(size/3,y+size/3,x);   // 1행 2열까지
        divide(size/3,y+size/3*2,x); // 1행 2열
        // 3-5열까지
        divide(size/3,y,x+size/3);  //0행 3열부터 5열까지
        divide(size/3,y+size/3,x+size/3); //1행 3열부터 5열까지
        divide(size/3,y+size/3*2,x+size/3); //2행 3열부터 5열까지
        // 5-8열까지
        divide(size/3,y,x+size/3*2);  //0행 3열부터 5열까지
        divide(size/3,y+size/3,x+size/3*2); //1행 3열부터 5열까지
        divide(size/3,y+size/3*2,x+size/3*2); //2행 3열부터 5열까지

    }
    static boolean check(int size,int y,int x)
    {
        int criteria=papaer[y][x];
        for (int i = y; i <y+size ; i++) {
            for (int j = x; j <x+size ; j++) {
                if(papaer[i][j]!=criteria)
                    return false;
            }
        }
        return true;
    }

}
