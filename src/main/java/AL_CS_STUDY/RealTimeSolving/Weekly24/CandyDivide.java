package AL_CS_STUDY.RealTimeSolving.Weekly24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyDivide {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <testCase ; i++) {
            int n=Integer.parseInt(br.readLine());
            int total=0;
            int bro=0;
            int sister=0;
            String str[]=br.readLine().split(" ");
            sister=bro=total=Integer.parseInt(str[0]);
            for (int j = 1; j < str.length; j++) {
                int input=Integer.parseInt(str[j]);
                total+=input;
                bro^=input;
                if(sister>input)
                    sister=input;
            }
            sb.append("#").append(i+1)
                    .append(" ").append(bro==0? total-sister:"NO").append("\n");
        }
        System.out.println(sb);
    }
}

