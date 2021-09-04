package tues_thurs_sat._20210730;

public class Country124 {
    public String solution(int n)
    {
        int num[]=new int[]{4,1,2};
        StringBuilder sb=new StringBuilder();
        while (n>0)
        {
            int remain=n%3;
            n/=3;
            if(remain==0)
                n--;
            sb.append(remain);
        }
        return sb.reverse().toString();
    }
}
