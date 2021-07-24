package AL_CS_STUDY.RealTimeSolving.Weekly30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MemoryRestore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <= T; i++) {
            String str=br.readLine();
            char prev='0';
            int cnt=0;
            for(int j=0; j<str.length();j++)
            {
                char ch= str.charAt(j);
                if(prev!=ch)
                {
                    prev=ch;
                    cnt++;
                }
            }
            sb.append("#").append(i).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
