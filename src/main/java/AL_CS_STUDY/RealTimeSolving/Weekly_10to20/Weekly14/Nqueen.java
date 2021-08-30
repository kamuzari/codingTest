package AL_CS_STUDY.RealTimeSolving.Weekly_10to20.Weekly14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nqueen {
    static int n,map[];
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            map=new int[n];
            for (int j = 0; j < n; j++) {
                map[0]=j;
                pick(1);
            }
            sb.append("#").append(i+" ").append(count).append("\n");
            count=0;
        }
        System.out.println(sb);
    }

    static int count=0;
    static void pick(int cnt)
    {
        if(cnt==n)
        {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            map[cnt]=i;
            if(check(cnt))
            {
                pick(cnt+1);
            }
        }

    }
    static boolean check(int cnt)
    {
        for (int i = 0; i < cnt; i++) {
            if(map[cnt]==map[i])
                return false;
            if(Math.abs(cnt-i)==Math.abs(map[i]-map[cnt]))
                return false;
        }
        return true;
    }
}
