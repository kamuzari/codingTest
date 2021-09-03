package tues_thurs_sat._20210903;

import java.util.Arrays;

public class OuterWallCheck {
    public static void main(String[] args) {
        int w[] = {1, 5, 6, 10};
        int d[] = {1, 2, 3, 4};
        OuterWallCheck outerWallCheck = new OuterWallCheck();
        outerWallCheck.solution(12, w, d);
    }

    static int min = Integer.MAX_VALUE;
    static int FRIENDS_NUMBER;
    static int N;
    static int d[];
    static int w[];

    // 반시계 방향 볼 필요가 없음.
    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        FRIENDS_NUMBER = dist.length;
        N = n;
        d = dist;
        w = weak;
        for (int i = 0; i < weak.length; i++) {
            perm(1, i, 0);
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        System.out.println(min);
        return min;
    }

    public void perm(int cnt, int postion, int v) {
        if(cnt>d.length)
        {
            return;
        }
        if(cnt>=min)
        {
            return;
        }
        for (int i = 0; i < w.length; i++) {
            int nextPos = (postion + i) % w.length;
            int diff = w[nextPos] - w[postion];
            if(nextPos <postion)
            {
                diff+=N;
            }
            if (diff > d[d.length - cnt]) {
                break;
            }
            v = v | 1 << nextPos;
        }

        if(v==(1<<w.length)-1)
        {
            min=Math.min(min,cnt);
            return;
        }

        for (int i = 0; i < w.length; i++) {
            if((v &(1<<i)) != 0)
                continue;
            perm(cnt+1,i,v);
        }
    }


}
