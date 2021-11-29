package Programmers.LV2;

public class JadenCaseStringMaking {
    /*
       *  단어의 첫문자가 소문자 이면 대문자이다.
       *  내가 했던 로직 : 공백을 쓸데없는 공백 지우고 이쁘게 출력함...
       *  무조건 단어 시작 문자는 대문자 (앞에 공백이여도 상관 없음. 단순히 무조건 첫문자는 대문자)
     */
    public String solution(String s) {
        s=s.toLowerCase();
        char chars[]=s.toCharArray();
        StringBuilder answer=new StringBuilder();
        answer.append(toUpper(chars[0]));
        for(int i=1; i<chars.length; i++){
            char ch=chars[i];
            if(ch!=' ' && chars[i-1]==' '){
                ch=toUpper(ch);
            }
            answer.append(ch);
        }
        return answer.toString();
    }

    private char toUpper(char ch){
        return Character.toUpperCase(ch);
    }

}
