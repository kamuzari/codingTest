package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquartB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        int max=10_000_001;
        boolean prime[]=new boolean[max];
        int list[]=new int[3500];
        int pos=0;
        prime[0]=prime[1]=true;
        for (int i = 2; i <Math.sqrt(max-1) ; i++) {
            if(prime[i]) continue;
            else
                list[pos++]=i;
            for (int j = i*2; j <max ; j+=i) {
                prime[j]=true;
            }
        }
        for (int i = 1; i <= testCase; i++) {
            int n=Integer.parseInt(br.readLine());
            int ans=0;
            if(!prime[n])
            {
                ans=n;
            }
            else {
                int idx=0;
                int cnt=0;
                ans=1;
                while (n>1)
                {
                    if(n% list[idx]==0) {
                        cnt++;
                        n/=list[idx];
                    }
                    if( n % list[idx] != 0){
                        if(cnt %2 != 0) ans *= list[idx];
                        if(!prime[n]){
                            ans *= n;
                            break;
                        }
                        idx++;
                        if(idx == pos){
                            ans *= n;
                            break;
                        }
                        cnt = 0;
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
