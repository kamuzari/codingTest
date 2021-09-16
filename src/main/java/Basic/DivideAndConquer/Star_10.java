package Basic.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star_10 {
    static char arr[][];
    static StringBuffer sb=new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        arr=new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                starStamp(i,j);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static void starStamp(int y,int x){
        while (true){
            if(y==0){
                break;
            }
            if(y%3==1 && x%3==1)
            {
                sb.append(" ");
                return;
            }
            y/=3;
            x/=3;
        }
       sb.append("*");
    }

}
