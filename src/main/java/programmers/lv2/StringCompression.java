package programmers.lv2;

public class StringCompression {
    public int solution(String s) {
        int answer = s.length();
        int n=s.length();
        for(int unit=1; unit<n/2+1; unit++){
            StringBuilder result=new StringBuilder();
            String pivot=s.substring(0,unit);
            int cnt=1;
            for(int next=unit; next<n; next+=unit){
                StringBuilder midRes=new StringBuilder();
                for(int i=next; i<next+unit; i++){
                    if(i<n) midRes.append(s.charAt(i));
                }
                if(pivot.equals(midRes.toString())) cnt++;
                else{
                    result.append((cnt>1)? String.valueOf(cnt)+pivot:pivot);
                    pivot=midRes.toString();
                    cnt=1;
                }
            }
            result.append((cnt>1)? String.valueOf(cnt)+pivot:pivot);
            answer=Math.min(answer,result.toString().length());

        }
        return answer;
    }
}
