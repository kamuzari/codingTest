package oneDay_twoSol.Implementation2.Deepening;

import java.util.Arrays;

public class 외벽점검 {
    public static void main(String[] args) {

    }
    static int N,Weak[],Dist[];
    static int min=Integer.MAX_VALUE;
    static void check(int cnt,int pos,int visisted)
    {
        if(cnt>Dist.length)
            return;
        if(cnt>=min)
            return;
        for (int i = 0; i < Weak.length; i++) {
            int next=(pos+i)%Weak.length;
            int dist=Weak[next]-Weak[pos];
            if(next<pos)
            {
                dist=N+Weak[next]-Weak[pos];
            }
            if(dist>Dist[Dist.length-1-cnt])
                break;

            visisted |=1<<next;

        }
        if(visisted==(1<<Weak.length)-1)
        {
            min=cnt;
            return;
        }
            for (int i = 0; i <Weak.length ; i++) {
                if((visisted &(1<<i)) !=0)
                    continue;
                check(cnt+1,i,visisted);

        }
    }

    public static int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        N=n;
        Weak=weak;
        Dist=dist;
        for (int i = 0; i < weak.length; i++) {
            check(1,i,0);
        }
        if(min==Integer.MAX_VALUE)
            return -1;

        return min;
    }
}
