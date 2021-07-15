package Basic.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//이슈 : StringBuilder를 사용하지 않으면 시간초과가 난다.
// String + operator
public class IOIOI {
    static String S;
    static String P="";
    static int pi[];
    static int patternLen;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder s = new StringBuilder("I");
        for(int i = 0; i<n; i++){
            s.append("OI");
        }
//        for (int i = 1; i <= n*2; i++) {
//            if(i%2==1)
//                P+="I";
//            else
//                P+="O";
//        }
//        P+="I";
        P=s.toString();
        patternLen=P.length();
        pi=new int[patternLen];
        int sLen=Integer.parseInt(br.readLine());
        S=br.readLine();
        getPi();
        kmp();
    }
    private static void getPi() {
        int j=0;
        for (int i = 1; i < patternLen; i++) {
            while (j>0 && P.charAt(i)!=P.charAt(j))
            {
                j=pi[j-1];
            }
            if(P.charAt(i)==P.charAt(j))
            {
                pi[i]=++j;
            }
        }
    }
    static void kmp()
    {
        int cnt=0;
        int j=0;

        for (int i = 0; i < S.length(); i++) {
            while (j>0 && S.charAt(i)!=P.charAt(j))
            {
                j=pi[j-1];
            }
            if(S.charAt(i)==P.charAt(j))
            {
                if(j==patternLen-1)
                {
                    cnt++;
                    j=pi[j];
                }
                else {
                    j++;
                }
            }
        }
        System.out.println(cnt);
    }
}
