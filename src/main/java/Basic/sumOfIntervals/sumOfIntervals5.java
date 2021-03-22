package Basic.sumOfIntervals;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sumOfIntervals5 {
    //  x1, y1, x2, y2
    static int n,arr[][],m;

    public static void main(String[] args) throws IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
         m=Integer.parseInt(st.nextToken());
        // 시간 복잡도 10초 (10억)
        arr=new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
//                if(j-1==0)
//                    arr[i][j]+=arr[i-1][n];
//                else
//                    arr[i][j]+=arr[i][j-1];
                arr[i][j]+=arr[i-1][j]+arr[i-1][j-1]+arr[i][j-1];
            }
        }
        System.out.println();
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        while (m-->0)
        {
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            System.out.println(arr[x2][y2]-arr[x1-1][y2]-arr[x2][y1-1]+arr[x1-1][y1-1]);
        }



    }
    static int Intervals_Sum(int x1,int y1,int x2,int y2)
    {
        int sum=0;
        for (int i = x1; i <=x2 ; i++) {
            for (int j = y1; j <=y2 ; j++) {
                sum+=arr[i][j];
            }
        }
        return sum;
    }
}
