package tues_thurs_sat._202110._20211002;

public class PGM12904_LongestPalindrome {
    public static void main(String[] args) {
        PGM12904_LongestPalindrome p = new PGM12904_LongestPalindrome();
        p.solution("abacde");
    }
    public int solution(String s){
            int answer = 0;
            char ch[]=s.toCharArray();
            int n=s.length();
            // 가장 긴 문자열 부터 시작 (범위)
            for(int i=n; i>1; i--){
                // 시작 인덱스
                for(int start=0; start+i<=n; start++){
                    boolean chk=true;
                    for(int k=0; k<i/2; k++){
                        if(ch[start+k]!=ch[start+i-k-1])
                        {
                            chk=false;
                            break;
                        }
                    }
                    if(chk){
                        return i;
                    }
                }
            }
            return 1;
        }
}
