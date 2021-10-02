package AL_CS_STUDY.Weekly_30to40.Weekly39;

import java.io.*;
public class BOJ1701_Cubeditor {
    static int maxLen;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        n = str.length();
        for (int i = 0; i < n ; i++) {
            String pattern = str.substring(i, n);
            final int[] pi = getPi(pattern);
        }
        System.out.println(maxLen);
    }

    private static int kmp(int[] pi, String str,String pattern) {
        int matchingCnt=0;

        int j=0;
        for (int i = 0; i <n ; i++) {
            while (j>0 && str.charAt(i) != pattern.charAt(j)){
                j=pi[j-1];
            }
            if(str.charAt(i)==pattern.charAt(j)){
                if(j==pattern.length()-1){
                    matchingCnt++;
                    j=pi[j];
                    if(matchingCnt>1){
                        return pattern.length();
                    }
                }else{
                    j++;
                }
            }
        }
        return -1;
    }

    private static int[] getPi(String pattern) {
        int[] pi =new int[pattern.length()];
        int j=0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j>0 && pattern.charAt(i)!=pattern.charAt(j)){
                j=pi[j-1];
            }
            if(pattern.charAt(i)==pattern.charAt(j)) {
                pi[i] = ++j;
                maxLen=Math.max(maxLen,pi[i]);
            }
        }
        return pi;
    }



}
