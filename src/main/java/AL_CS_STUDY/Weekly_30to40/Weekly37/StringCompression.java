package AL_CS_STUDY.Weekly_30to40.Weekly37;
//https://programmers.co.kr/learn/courses/30/lessons/60057?language=java
public class StringCompression {
    public int solution(String s) {
        int answer = s.length();
        int len=answer;
        for (int splitUnit = 1; splitUnit <=len/2; splitUnit++) {
            String compressionResult="";
            String standard=s.substring(0,splitUnit);
            int cnt=1;
            for (int next = splitUnit; next < len; next+=splitUnit) {
                StringBuilder sb=new StringBuilder();
                for (int j = next; j <splitUnit+next ; j++) {
                    if(j<len) {
                        sb.append(s.charAt(j));
                    }
                }
                if(standard.equals(sb.toString()))
                {
                    cnt++;
                }else
                {
                    compressionResult+=(cnt>=2) ?cnt+standard:standard;
                    standard=sb.toString();
                    cnt=1;
                }
            }
            compressionResult+=(cnt>=2)?cnt+standard:standard;
            answer=Math.min(answer,compressionResult.length());
        }
        return answer;
    }
}
