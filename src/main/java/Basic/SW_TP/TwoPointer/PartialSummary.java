package Basic.SW_TP.TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class PartialSummary {
    static final int MAXLENGTH=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0, e = 0;
        int len = n;
        int sum = 0;
        int shortestLen = MAXLENGTH;
        while (true) {
            if (sum >= k) {
                shortestLen = Math.min(shortestLen, e - s);
                sum -= arr[s++];
            } else if (e > len - 1)
                break;
            else if (sum < k) {
                sum += arr[e++];
            }

        }
        if(shortestLen==MAXLENGTH)
            System.out.println(0);
        else
            System.out.println(shortestLen);
    }
}
