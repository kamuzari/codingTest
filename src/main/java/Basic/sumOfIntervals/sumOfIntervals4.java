package Basic.sumOfIntervals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11659
public class sumOfIntervals4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n + 1];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

//        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            sb.append(arr[x2] - arr[x1 - 1]).append("\n");
        }
        System.out.println(sb);

    }
}
