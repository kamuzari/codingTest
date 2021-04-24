package tues_thurs_sat._20210424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmusementPark {
    static int n,m;
    static int park[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        n=Integer.parseInt(s[0]);

        m=Integer.parseInt(s[1]);
        park=new int[m];
        s=br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            park[i]=Integer.parseInt(s[i]);
        }
        if(n<=m) {
            System.out.println(n);
        }
        else
        {
            int ans=solution();
            System.out.println(ans);
        }
    }
    public static int solution()
    {
        int ans=0;
        long l=0;
        long r=2_000_000_000L*30L; // 최대시간.
        while (l<=r)
        {
            long mid=(l+r)/2;
            long s,e;
            s=0;
            e=m;

            for (int i = 0; i < park.length; i++) {
                e+=(mid/park[i]);
            }
            s=e;
            for (int i = 0; i < m; i++) {
                if(mid%park[i]==0)
                    s--;
            }
            s++;
            if(n<s)
            {
                r=mid-1;
            }
            else if(n>e)
            {
                l=mid+1;
            }
            else
            {
                for (int i = 0; i < m; i++) {
                    if(mid%park[i]==0)
                    {
                        if(n==s)
                        {
                          return i+1;
                        }
                        s++;
                    }
                }
            }

        }
        return ans;
    }
}
