package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly29;

import java.io.*;
public class INFdictionary {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {
            String str1=br.readLine();
            String str2=br.readLine();
            String answer="";
           if(!(str1+"a").equals(str2))
                answer="Y";
           else
               answer="N";

            sb.append("#"+testCase).append(" "+answer).append("\n");
        }
        System.out.println(sb);
    }
}
