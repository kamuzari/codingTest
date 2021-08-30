package AL_CS_STUDY.RealTimeSolving.Weekly_30to40.Weekly31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidNumberNotification {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TESTCASE; t++) {
            String answer = "";
            String INPUT = br.readLine();
            int exponent = INPUT.length()-1;

            StringBuilder numberExtracted=new StringBuilder();
            numberExtracted.append(INPUT.substring(0,3));
            numberExtracted.insert(1,".");
            double NUMBER=Double.parseDouble(numberExtracted.toString());
            String format = String.format("%.1f", NUMBER);

            int idx = format.indexOf(".");
            String IntegerPart =format.substring(0,idx);
            int mantissa=Integer.parseInt(IntegerPart);

            StringBuilder sbStr=new StringBuilder();
            if(mantissa/10>=1)
            {
                int rest=mantissa%10;
                mantissa/=10;
                exponent++;
                sbStr.append(mantissa).append(".").append(rest);
            }
            else
            {
                sbStr.append(format);
            }
            sbStr.append("*10^").append(exponent);
            answer=sbStr.toString();

            sb.append("#").append(t+1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }
}


