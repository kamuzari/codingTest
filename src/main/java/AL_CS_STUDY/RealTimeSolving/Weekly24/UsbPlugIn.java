package AL_CS_STUDY.RealTimeSolving.Weekly24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsbPlugIn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            String[] str = br.readLine().split(" ");
            double p = Double.parseDouble(str[0]);
            double q = Double.parseDouble(str[1]);
            String result = "YES";

            double s1 = (1-p)*q;
            double s2 = p*(1-q)*q;
            if(s1 >= s2) {
                result = "NO";
            }
            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
        System.out.println(sb);

    }
}
