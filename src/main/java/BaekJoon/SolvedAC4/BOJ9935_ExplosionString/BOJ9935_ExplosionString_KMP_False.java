package BaekJoon.SolvedAC4.BOJ9935_ExplosionString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935_ExplosionString_KMP_False {

    /*
     * 유의 할 점 String.replce() api n^m 조심
     * 2% 메모리 초과 -> StringBuilder.delete 때문인가..? System.arraycopy() API가 계속 새로 생성해서 초과가 나는것 같다..
     */
    static final String DEFAULT = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String original = br.readLine();
        StringBuilder org = new StringBuilder();
        org.append(original);

        String boomb = br.readLine();
        int boombLength = boomb.length();
        int boombPi[] = getPattern(boomb);

        while (true) {
            int ret = kmp(org.toString(), boomb, boombPi);
            if (ret == -1) {
                break;
            }
            org.delete(ret-(boombLength-1), ret+1);
        }

        System.out.println(org.toString().equals("") ? DEFAULT :org.toString());
    }

    public static int[] getPattern(String pattern) {
        int n = pattern.length();
        int pi[] = new int[n];
        int prefix = 0;

        for (int suffix = 1; suffix < n; suffix++) {
            while (prefix != 0 && pattern.charAt(prefix) != pattern.charAt(suffix)) {
                prefix = pi[suffix - 1];
            }

            if (pattern.charAt(prefix) == pattern.charAt(suffix)) {
                pi[suffix] = ++prefix;
            }
        }
        return pi;
    }

    public static int kmp(String original, String pattern, int[] pi) {
        int pIdx = 0;
        for (int orgIdx = 0; orgIdx < original.length(); orgIdx++) {
            while (pIdx > 0 && pattern.charAt(pIdx) != original.charAt(orgIdx)) {
                pIdx = pi[pIdx - 1];
            }
            if (pattern.charAt(pIdx) == original.charAt(orgIdx)) {
                if (pIdx == pattern.length() - 1) {
                    return orgIdx;
                } else {
                    pIdx++;
                }
            }
        }

        return -1;
    }

}
