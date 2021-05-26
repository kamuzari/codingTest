package AL_CS_STUDY.RealTimeSolving.Weekly22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class validNumbering {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            if (s.charAt(2) - '0' < 5) {
                System.out.printf("#%d %c.%c*10^%d\n", i, s.charAt(0), s.charAt(1), s.length() - 1);
            } else if (s.charAt(2) - '0' >= 5 && s.charAt(1) - '0' < 9) {
                System.out.printf("#%d %c.%c*10^%d\n", i, s.charAt(0), s.charAt(1) + 1, s.length() - 1);
            } else if (s.charAt(1) - '0' == 9 && s.charAt(2) - '0' >= 5) {
                if (s.charAt(0) - '0' == 9) {
                    System.out.printf("#%d 1.0*10^%d\n", i, s.length());
                }
                else {
                    System.out.printf("#%d %c.0*10^%d\n", i, s.charAt(0)+1,s.length());
                }
            }
        }
    }
}

