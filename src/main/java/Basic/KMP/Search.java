package Basic.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Search {
    static String original = "";
    static String pattern = "";
    static int orgLen, patLen;
    static int pi[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        original = br.readLine();
        pattern = br.readLine();

        orgLen = original.length();
        patLen = pattern.length();
        pi = new int[patLen];
        initGetPi();
        kmp();
    }

    private static void kmp() {
        int j = 0;
        int cnt=0;
        ArrayList<Integer> notificationIdx = new ArrayList<>();
        for (int i = 0; i < orgLen; i++) {
            while (j > 0 && original.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (original.charAt(i) == pattern.charAt(j)) {
                if (j == patLen - 1) {
                    cnt++;
                    j = pi[j];
                    notificationIdx.add(i - (patLen-1)+1);
                }
                else
                    j++;
            }
        }
        int arr[] = new int[notificationIdx.size()];
        int i = 0;
        StringBuilder sb=new StringBuilder();
        sb.append(cnt).append("\n");
        notificationIdx.forEach(val->sb.append(val).append(" "));
        System.out.println(sb);
    }

    private static void initGetPi() {
        int j = 0;
        for (int i = 1; i < patLen; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }
}
