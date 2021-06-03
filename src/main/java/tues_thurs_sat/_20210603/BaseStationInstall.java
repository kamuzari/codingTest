package tues_thurs_sat._20210603;

public class BaseStationInstall {
    public static void main(String[] args) {
        System.out.println(solution(11,new int[]{4,11},1));
    }
    public static int solution(int n, int[] stations, int w) {
        int answer=0;
        int location=1;
        int idx=0;
        while (location<=n)
        {
            if(idx<stations.length && location>=stations[idx]-w)
            {
                location=stations[idx]+w+1;
                idx++;
            }
            else{
                location+=2*w+1;
                answer++;
            }
        }
        return answer;
    }
}
