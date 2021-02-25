package oneDay_twoSol.Implementation2.Basic.Deepening;

public class stringCompression {

    public static void main(String[] args) {
        String str1 = "aabbaccc";
        System.out.println(customSol(str1));
        String str2 = "ababcdcdababcdcd";
        System.out.println(customSol(str2));
        String str3 = "abcabcdede";
        System.out.println(customSol(str3));
        String str4 = "abcabcabcabcdededededede";
        System.out.println(customSol(str4));
        String str5 = "xababcdcdababcdcd";
        System.out.println(customSol(str5));
    }


    public static int solution(String s) {

        String ans = "";
        int len = s.length();
        int min = s.length();
        for (int i = 1; i < len / 2 + 1; i++) {
            String comp = "";
            String prev = s.substring(0, i);
            int cnt = 1;

            for (int j = i; j < len; j += i) {
                String sub = "";
                for (int k = j; k < j + i; k++) {
                    if (k < s.length())
                        sub += s.charAt(k);
                }
                if (prev.equals(sub))
                    cnt++;
                else {
                    comp += (cnt >= 2) ? cnt + prev : prev;
                    sub = "";
                    for (int k = j; k < j + i; k++) {
                        if (k < s.length())
                            sub += s.charAt(k);
                    }
                    prev = sub;
                    cnt = 1;
                }
            }
            comp += (cnt >= 2) ? cnt + prev : prev;
            min = Math.min(min, comp.length());
        }
        return min;
    }

    public static int customSol(String s) {
        int ans = s.length();
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            String compression = "";
            String criteria = s.substring(0, i);
            int cnt = 1;
            for (int j = i; j < len; j += i) {
                String sub = "";
                for (int k = j; k < j + i; k++) {
                    if (k < len)
                        sub += s.charAt(k);
                }
                if (criteria.equals(sub)) {
                    cnt++;
                } else {
                    compression += (cnt >= 2) ? cnt + criteria : criteria;
                    criteria = sub;
                    cnt = 1;
                }
            }
            compression+=(cnt>=2)?cnt+criteria:criteria;
            ans=Math.min(ans,compression.length());
        }
        return ans;
    }


}
