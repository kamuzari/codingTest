package tues_thurs_sat._202109._20210928;

public class PGM12980_JumpAndTeleport {
    public static int solution(int n)
    {
        int answer=0;
        while (n!=0)
        {
            if(n%2==0)
            {
                n/=2;
            }
            else
            {
                n--;
                answer++;
            }
        }
        return answer;
    }
}
