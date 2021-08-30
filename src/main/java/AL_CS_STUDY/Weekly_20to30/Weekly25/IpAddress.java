package AL_CS_STUDY.Weekly_20to30.Weekly25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IpAddress {

    private static int n;
    private static ArrayList<Integer> ip;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ip = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            int idx1 = str.indexOf(".", 0);
            int idx2 = str.indexOf(".", idx1 + 1);
            int idx3 = str.lastIndexOf(".");

            String digits1 = str.substring(0, idx1);
            String digits2 = str.substring(idx1 + 1, idx2);
            String digits3 = str.substring(idx2 + 1, idx3);
            String digits4 = str.substring(idx3 + 1);

            int number = (toInt(digits1) << 24) + (toInt(digits2) << 16) + (toInt(digits3) << 8) + (toInt(digits4));
            ip.add(number);
        }

        int diff_pos = -1;

        for (int i = 31; i >= 0; i--) {
            for (int j = 1; j < n; j++) {

                int l = ip.get(j - 1);
                int r = ip.get(j);

                if ((l & (1 << i)) != (r & (1 << i))) {
                    diff_pos = i;
                    break;
                }
            }
            if (diff_pos != -1)
                break;
        }

        int network = 0;
        int networkMask = 0;

        if (diff_pos == -1) {
            networkMask = (1 << 32) - 1;
            network = networkMask & ip.get(0);
        } else {
            for (int i = 31; i > diff_pos; i--) {
                networkMask |= (1 << i);
            }
            network = networkMask & ip.get(0);
        }

        String ans1 = "";
        String ans2 = "";
        for (int i = 0; i < 4; i++) {

            int check = (1 << 8) - 1;
            int number1 = (network & check);
            int number2 = (networkMask & check);
            ans1 = String.valueOf(number1) + "." + ans1;
            ans2 = String.valueOf(number2) + "." + ans2;


            network >>= 8;
            networkMask >>= 8;
        }

        System.out.println(ans1.substring(0, ans1.length() - 1) + "\n"

                + ans2.substring(0, ans2.length() - 1));


    }

    static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
