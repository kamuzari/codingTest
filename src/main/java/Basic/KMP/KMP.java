package Basic.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KMP {
    static String org = "ABABABABC";
    static String pattern = "AB";
    private static int[] pi;

    public static void main(String[] args) throws IOException {
        pi = new int[pattern.length()];
        getPi();
        kmp();
    }

    public static void getPi() {
        int j=0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j>0 && pattern.charAt(j)!=pattern.charAt(i))
            {
                j=pi[j-1];
            }
            if(pattern.charAt(i)==org.charAt(j))
            {
                pi[i]=++j;
            }
        }
    }
    public static void kmp()
    {
        int j=0;
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < org.length(); i++) {
            while (j>0 && org.charAt(i)!=pattern.charAt(j))
            {
                j=pi[j-1];
            }
            if(org.charAt(i)==pattern.charAt(j))
            {
                if(j==pattern.length()-1)
                {
                    list.add(i-pattern.length()+1);
                    j=pi[j];
                }
                else
                {
                    j++;
                }
            }
        }
        System.out.println(list);
    }
}
