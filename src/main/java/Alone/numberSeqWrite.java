package Alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numberSeqWrite
{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int ans=0;
//        for (int i = 1; i <= n; i++) {
//            int a=i;
//            ans+=Integer.toString(i).length();
//        }
        if(n < 10) {
            ans = n;
            System.out.println(ans);
        }
        else if(n >= 10 && n < 100) {
            ans = 9 + ((n - 9) * 2);
            System.out.println(ans);
        }
        else if(n >= 100 && n < 1000) {
            ans = 9 + (90 * 2) + ((n - 99 ) * 3);
            System.out.println(ans);
        }
        else if(n >= 1000 && n < 10000) {
            ans = 9 + (90 * 2) + (900 * 3) + ((n - 999) * 4);
            System.out.println(ans);
        }
        else if(n >= 10000 && n < 100000) {
            ans = 9 + (90 * 2) + (900 * 3) + (9000 * 4) + ((n - 9999) * 5);
            System.out.println(ans);
        }
        else if(n >= 100000 && n < 1000000) {  // 10만 이상 100만 이하
            ans = 9 + (90 * 2) + (900 * 3) + (9000 * 4) + (90000 * 5)
                    + ((n - 99999) * 6);
            System.out.println(ans);
        }
        else if(n >= 1000000 && n < 10000000) { // 100만 이상 1000만 이하
            ans = 9 + (90 * 2) + (900 * 3) + (9000 * 4) + (90000 * 5)
                    + (900000 * 6) + ((n - 999999) * 7);
            System.out.println(ans);
        }
        else if(n >= 10000000 && n < 100000000) { // 1000만 이상 1억 이하
            ans = 9 + (90 * 2) + (900 * 3) + (9000 * 4) + (90000 * 5)
                    + (900000 * 6) + (9000000 * 7) + ((n - 10000000 + 1) * 8);
            System.out.println(ans);
        }
        else {
            ans = 9 + (90 * 2) + (900 * 3) + (9000 * 4) + (90000 * 5)
                    + (900000 * 6) + (9000000 * 7) + (90000000 * 8) + 9;
            System.out.println(ans);
        }


    }

}
