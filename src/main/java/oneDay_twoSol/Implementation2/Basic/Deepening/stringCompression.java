package oneDay_twoSol.Implementation2.Basic.Deepening;

public class stringCompression {

    public static void main(String[] args) {
//        String str1 = "aabbaccc";
//        System.out.println(solution2(str1));
//        String str2 = "ababcdcdababcdcd";
//        System.out.println(solution2(str2));
//        String str3 = "abcabcdede";
//        System.out.println(solution2(str3));
//        String str4 = "abcabcabcabcdededededede";
//        System.out.println(solution2(str4));
        String str5="xababcdcdababcdcd";
        System.out.println(solution2(str5));
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

    public static int solution2(String s) {
        int len=s.length()/2;
        int min=Integer.MAX_VALUE;
        for (int i = 1; i <=len ; i++) {
            compression(s,i);
            min=Math.min(min,compression(s,i).length());
        }
        return min;
    }
    public static String compression(String str, int i) {

        int count = 1;
        String compression = "";
        String pattern = "";

        for (int j = 0; j <= str.length() + i; j += i) {

            String nowStr;

            // 전 문자열과 비교할 현재 문자열
            if (j >= str.length()) { // 현재 문자열이 없을 때
                nowStr = "";
            } else if (str.length() < j + i) { // 마지막 현재 문자열일 때
                nowStr = str.substring(j);
            } else {
                nowStr = str.substring(j, j + i); // 그 외
            }

            // 1. 전 문자열이랑 똑같은지 비교한다. (맨 처음이면 비교 X)
            if (j != 0) {
                if (nowStr.equals(pattern)) { // 똑같으면
                    count++;
                } else if (count >= 2) { // 다르고 count가 2회 이상이면 압축 가능
                    compression += count + pattern;
                    count = 1;
                } else { // 압축 불가능하면 그냥 그대로 문자열 이어붙이기
                    compression += pattern;
                }
            }
            // 2. i 길이만큼 문자열을 자른다.
            pattern = nowStr;
        }

        return compression;
    }
}
