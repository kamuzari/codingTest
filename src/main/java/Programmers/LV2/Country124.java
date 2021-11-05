package Programmers.LV2;
// 규칙 찾기
public class Country124 {
    public String solution(int n)
    {
        int num[]=new int[]{4,1,2};
        StringBuilder sb=new StringBuilder();
        while (n>0)
        {
            int rest=n%3;
            n/=3;
            if(rest==0)
                n--;
            sb.append(num[rest]);
        }
        return sb.reverse().toString();
    }
}
