package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        while (t++ < 10) {
            int tmp = Integer.parseInt(br.readLine());
            int max = 1;
            char ch[][] = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++) {
                    ch[i][j] = str.charAt(j);
                }
            }
            for (int len = 100; len > 1; len--) {
                if (max > 1)
                    break;
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 100 - len + 1; j++) {
                        boolean flag= true;
                        for (int k = 0; k < len / 2; k++) {
                            if (ch[i][j + k] != ch[i][j+ len - k - 1]) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                        {
                            max=Math.max(max,len);
                        }
                    }
                }
                //세로
                for (int i = 0; i < 100-len; i++) {
                    for (int j = 0; j < 100 ; j++) {
                        boolean flag= true;
                        for (int k = 0; k < len / 2; k++) {
                            if (ch[i + k][j] != ch[i + len - k - 1][j]) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                        {
                            max=Math.max(max,len);
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + max);
        }
    }
}
