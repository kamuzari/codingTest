package tues_thurs_sat._20210506;

public class Palindrome {
    public static void main(String[] args) {

    }
    public int solution(String s)
    {
        char ch[]=s.toCharArray();
        for (int i = s.length(); i > 1; i--) {
            for (int j = 0; j+i <= s.length(); j++) {
                boolean flag=true;
                for (int k = 0; k < i/2; k++) {
                    if(ch[j+k]!=ch[j+i-k-1])
                    {
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    return i;
            }
        }

        return 1;
    }

}
