package AL_CS_STUDY.Weekly32.BitMask;

import java.io.*;

public class BinaryOperation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] ch1 = br.readLine().toCharArray();
        char [] ch2 = br.readLine().toCharArray();
        int a[]=new int[100_001];
        int b[]=new int[100_001];
        int length = ch1.length;

        for (int i = 0; i <length ; i++) {
            a[i]=ch1[i]-'0';
            b[i]=ch2[i]-'0';
        }
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(a[i]&b[i]);
        }
        sb.append("\n");

        for (int i = 0; i < length; i++) {
            sb.append(a[i]|b[i]);
        }
        sb.append("\n");

        for (int i = 0; i < length; i++) {
            sb.append(a[i]^b[i]);
        }
        sb.append("\n");

        for (int i = 0; i < length; i++) {
            sb.append(a[i]^1);
        }
        sb.append("\n");

        for (int i = 0; i < length; i++) {
            sb.append(b[i]^1);
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
