package Basic.StackAndQueue;

import java.util.*;
import java.io.*;


public class BOJ17608_Poll {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int arr[] = new int[n];
        int cnt=0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                cnt++;
                s.push(arr[i]);
            } else {
                if (s.peek() < arr[i]) {
                    s.push(arr[i]);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
