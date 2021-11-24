package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer p = new StringBuffer();
        p.append("I");
        for (int i = 0; i < n; i++) {
            p.append("OI");
        }
        String pattern = p.toString();
        int pi[]=getPi(pattern);
        int m = Integer.parseInt(br.readLine());
        StringBuffer org = new StringBuffer();
        String str[] = br.readLine().split("");
        for (int i = 0; i < m; i++) {
            org.append(str[i]);
        }
        String orginal=org.toString();
        int answer = kmp(orginal, pi, pattern);
        System.out.println(answer);
    }

    public static int[] getPi(String pattern) {
        int n = pattern.length();
        int answer[] = new int[n];
        int prefix = 0;
        for (int suffix = 1; suffix < n; suffix++) {
            while (prefix > 0 && pattern.charAt(prefix) != pattern.charAt(suffix)) {
                prefix = answer[prefix - 1];
            }
            if (pattern.charAt(suffix) == pattern.charAt(prefix)) {
                answer[suffix] = ++prefix;
            }
        }
        return answer;
    }

    public static int kmp(String org,int pi[],String pat){
        int answer=0;
        int pIdx=0;
        for (int orgIdx = 0; orgIdx <org.length() ; orgIdx++) {
            while (pIdx>0 && org.charAt(orgIdx)!=pat.charAt(pIdx)){
                pIdx=pi[pIdx-1];
            }
            if(org.charAt(orgIdx)==pat.charAt(pIdx)){
                if(pIdx==pat.length()-1){
                   answer++;
                   pIdx=pi[pIdx];
                }else{
                    pIdx++;
                }
            }
        }
        return answer;
    }
}
