package Basic.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuardTree {

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str[]=br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j]=Integer.parseInt(str[j]);
            }
        }

        divide(n,0,0);
        System.out.println(sb);
    }
    private static StringBuffer sb=new StringBuffer();
    private static void divide(int n, int y, int x) {
        if(check(n,y,x))
        {
            sb.append(arr[y][x]);
            return;
        }
        sb.append("(");
        divide(n/2,y,x);
        divide(n/2,y,x+n/2);
        divide(n/2,y+n/2,x);
        divide(n/2,y+n/2,x+n/2);
        sb.append(")");

    }

    private static boolean check(int n, int y, int x) {
        int pivot=arr[y][x];
        for (int i = y; i <y+n ; i++) {
            for (int j = x; j < x+n; j++) {
                if(pivot!=arr[i][j])
                    return false;
            }
        }
        return true;
    }
}
