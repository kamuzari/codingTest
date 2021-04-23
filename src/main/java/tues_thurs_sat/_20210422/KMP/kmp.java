package tues_thurs_sat._20210422.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
https://www.acmicpc.net/problem/16916
https://devje8.tistory.com/24
*/
public class kmp {
    static int res,pi[];
    static String org,pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        org=br.readLine();
        pattern=br.readLine();
        pi=new int[pattern.length()];
        getPi();
        int res=kmpAl();
        System.out.println(res);

    }
    public static void getPi()
    {
        int j=0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j>0 && pattern.charAt(i)!=pattern.charAt(j))
            {
                j=pi[j-1];
            }
            if(pattern.charAt(i)==pattern.charAt(j))
                pi[i]=++j;
        }
    }

    public static int  kmpAl()
    {
        int j=0;
        for (int i = 0; i < org.length(); i++) {
            while (j>0 && org.charAt(i)!=pattern.charAt(j))
            {
                j=pi[j-1];
            }
            if(org.charAt(i)==pattern.charAt(j))
            {
                if(j==pattern.length()-1)
                {
                    res=1;
                    return 1;
                }
                else
                    j++;
            }
        }
        return 0;
    }

}
