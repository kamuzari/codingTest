package AL_CS_STUDY.Weekly_20to30.Weekly29;

import java.io.*;
import java.util.StringTokenizer;

public class RingGoPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long n=Long.parseLong(st.nextToken());
        long k=Long.parseLong(st.nextToken());
        int s=1;
        int e=(int)n;
        int answer[]=new int[(int)n+1];
        for (long i = 1; i <=n; i++) {
            if(k>=n-i) {
                k -= (n - i);
                answer[(int)i]=e--;
            }
            else
                answer[(int)i]=s++;
        }
        if(k!=0 || s<=e)
            System.out.println(-1);
        else
        {
            for (int i = 1; i < n+1; i++) {
                System.out.print(answer[i]+" ");
            }
        }

    }
}
