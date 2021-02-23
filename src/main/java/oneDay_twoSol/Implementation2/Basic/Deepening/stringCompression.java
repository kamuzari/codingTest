package oneDay_twoSol.Implementation2.Basic.Deepening;

public class stringCompression {

    public static void main(String[] args) {
        String str1 = "aabbaccc";
        System.out.println(solution(str1));
        String str2 = "ababcdcdababcdcd";
        System.out.println(solution(str2));
        String str3 = "abcabcdede";
        System.out.println(solution(str3));
        String str4 = "abcabcabcabcdededededede";
        System.out.println(solution(str4));
        String str5="xababcdcdababcdcd";
        System.out.println(solution(str5));
    }
    static boolean check[];
    public static int solution(String s) {

        String ans = "";
        int len = s.length();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len / 2; i++) { // i 는 자르는 갯수.이면서 반복문 도는 중의적 의미/
            String sub = s.substring(0, i);
            int cnt = 1;
            int j;
            boolean ch=true;
            for (j = i; j + i <= len; ) {
                if (sub.equals(s.substring(j, j + i))) {
                    cnt++;
                } else {
                    // 다르면.
                    if (cnt == 1)
                        ans += sub;
                    else
                        ans += cnt + sub;
                    sub = s.substring(j, j + i);
                    cnt = 1;
                }
                if (j + i == len) {
                    if (cnt == 1)
                        ans += sub;
                    else
                        ans += cnt + sub;
                }
                if(j+i>len)
                {
                    ch=false;
                }
                j += i;
                // 다 검사를 못했다... 범위가 넘어가서.. 이 부분을 탈출.
            }
            if (ans.length() <= len / 2 || j+i>len)
                continue;

            min = Math.min(min, ans.length());
            ans = "";
        }
        return min;
    }
}
