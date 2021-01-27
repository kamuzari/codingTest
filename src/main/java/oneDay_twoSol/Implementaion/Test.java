package oneDay_twoSol.Implementaion;

import java.util.Arrays;

/*
기존대비 왼쪽방향 = ( 기존 방향 + 3 ) % 4

기존대비 역방향 = ( 기존 방향 + 2 ) % 4
 */
public class Test {
    public static void main(String[] args) {
        int [][]key={
                {0,0,0},
                {1,0,0},
                {0,1,1}
        };
        int[][] temp =new int[key.length][key[0].length];

        for (int i = 0; i <key.length ; i++) {
            for (int j = 0; j < key.length; j++) {
                temp[i][j]=key[key.length-1-j][i];
                System.out.println(key[key.length-1-j][i]);
            }
        }
        for (int i = 0; i < key.length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
    }
}