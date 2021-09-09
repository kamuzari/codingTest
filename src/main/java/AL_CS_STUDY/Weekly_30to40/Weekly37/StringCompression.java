package AL_CS_STUDY.Weekly_30to40.Weekly37;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression stringCompression =
                new StringCompression();
        stringCompression.solution("abcde");

    }

    public int solution(String s) {
        int answer = s.length();
        int len=answer;
        for (int splitUnit = 1; splitUnit <=len/2; splitUnit++) {
            String compressionResult="";
            String standard=s.substring(0,splitUnit);
            int cnt=1;
            for (int next = splitUnit; next < len; next+=splitUnit) {
               StringBuffer sb=new StringBuffer();
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
