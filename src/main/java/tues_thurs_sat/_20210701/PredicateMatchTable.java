package tues_thurs_sat._20210701;

public class PredicateMatchTable {
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int l=0,r=0;
        if(a>b)
        {
            l=b;
            r=a;
        }
        else{
            l=a;
            r=b;
        }

        while(true)
        {
            if(l%2==1 && r-l==1)
                break;

            l=(l+1)/2;
            r=(r+1)/2;
            answer++;
        }
        return answer;
    }
}
