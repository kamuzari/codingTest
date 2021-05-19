package WeeklyThuseday.StringProblem;

public class stringCompression {
    public static void main(String[] args) {
//        int x=solution("aabbaccc");
        int x=solution("ababcdcdababcdcd");
        System.out.println(x);
    }
    public static int solution(String s) {
        int len=s.length();
        int answer = len;
        for (int i = 1; i <=len/2; i++) {
            // 문자열 압축
            int pos=0;
            int x=len; // 갱신.
            for (; pos+i<=len;)
            {
                String unit=s.substring(pos,pos+i);
                pos+=i;

                int cnt=0;
                for(;pos+i<=len;)
                {
                    if(unit.equals(s.substring(pos,pos+i)))
                    {
                        cnt++;
                        pos+=i;
                    }
                    else
                        break;
                }
                if(cnt>0)
                {
                    x-=i*cnt;
                    if(cnt<9)
                    {
                        x+=1;
                    }
                    else if(cnt<99)
                    {
                        x+=2;
                    }
                    else if(cnt<999)
                    {
                        x+=3;
                    }
                    else if(cnt>9999)
                    {
                        x+=4;
                    }
                }
            }
        answer=Math.min(answer,x);

        }
        return answer;
    }
}
