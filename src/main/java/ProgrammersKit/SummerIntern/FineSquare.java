package ProgrammersKit.SummerIntern;

public class FineSquare {
    public long solution(int w, int h) {
        long answer = 0;
        long w1=Long.parseLong(String.valueOf(w));
        long h1=Long.parseLong(String.valueOf(h));
        if(w1>h1)
        {
            answer=gcd(w1,h1);
        }
        else
        {
            answer=gcd(w1,h1);
        }
        // System.out.println("dd"+ answer);
        answer=w1*h1 - (w1+h1-answer);
        return answer;
    }
    public long gcd(long a,long b)
    {

        while(b>0)
        {

            long tmp=a;
            a=b;
            b=tmp%b;

        }
        return a;
    }
}
