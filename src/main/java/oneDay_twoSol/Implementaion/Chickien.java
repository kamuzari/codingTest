package oneDay_twoSol.Implementaion;

import java.util.Scanner;

public class Chickien {
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static int arr[][];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        arr=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        
    }
}
