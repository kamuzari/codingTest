package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2630_PaperMaking {

    private static int[][] paper;
    private static int n,white,blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(str[j]);
            }
        }
        partition(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }
    static void partition(int r,int c,int size){
        if(check(r,c,size)){
            int val=paper[r][c];
            if(val==0){
                white++;
            }else if(val==1){
                blue++;
            }
            return;
        }
        partition(r,c,size/2);
        partition(r,c+size/2,size/2);
        partition(r+size/2,c,size/2);
        partition(r+size/2,c+size/2,size/2);
    }

    private static boolean check(int r, int c, int size) {
        int pivot=paper[r][c];
        for (int i = r; i <r+size ; i++) {
            for (int j = c; j < c+size; j++) {
                if(pivot!=paper[i][j]) return false;
            }
        }
        return true;
    }
}
