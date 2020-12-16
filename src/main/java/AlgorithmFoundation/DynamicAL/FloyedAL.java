package AlgorithmFoundation.DynamicAL;

import java.util.Arrays;

public class FloyedAL {
    static final int infi = 9999;
    static int W[][] = new int[][]{
            {},
            {0, 0, 1, infi, 1, 5},
            {0, 9, 0, 3, 2, infi},
            {0, infi, infi, 0, 4, infi},
            {0, infi, infi, 2, 0, 3},
            {0, 3, infi, infi, infi, 0}
    };
    static int D[][] = new int[][]{
            {},
            {0, 0, 1, infi, 1, 5},
            {0, 9, 0, 3, 2, infi},
            {0, infi, infi, 0, 4, infi},
            {0, infi, infi, 2, 0, 3},
            {0, 3, infi, infi, infi, 0}
    };
    static int p[][];
    public static void main(String[] args) {
        int n = 5;
     /*   p=new int [w.length][w.length];
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if(D[i][j]>D[i][k]+D[k][i])
                    {
                        p[i][j]=k;
                        D[i][j]=D[i][k]+D[k][i];
                    }
                }
                }
            }*/
//        print(D);
        floyd(n,W,D);
        print(p);
        }
    static void print(int arr[][])
    {
        System.out.println();
        for (int i = 1; i <arr.length ; i++) {
            for (int j = 1; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void floyd(int n,int [][]W,int[][]D ) {
        int i,j,k;
        D=W;
        p=new int [D.length][D.length];
        for (k = 1; k <= n; k++) { // 거치는 정점 k
            for (i = 1; i <= n; i++) { // 정점 k에 대해 모든 정점 순회
                for (j = 1; j <= n; j++) {
                    // 기존 거리와 정점을 거치는 거리 비교
                    if(D[i][j] >(D[i][k] + D[k][j]))
                    {
                        p[i][j]=k;
                        D[i][j]=(D[i][k] + D[k][j]);
                    }
                }
            }
        }

        for (int[] arr: D) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }

}
