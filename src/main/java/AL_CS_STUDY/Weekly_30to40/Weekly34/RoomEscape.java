package AL_CS_STUDY.Weekly_30to40.Weekly34;

import java.io.*;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/15729
public class RoomEscape {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        int arr[] = new int[n];
        int answer = 0;
        int idx = 0;
        while (idx < n) {
            if (arr[idx] == target[idx]) {
                idx++;
                continue;
            } else {
                answer++;
                int targetValue = target[idx];
                arr[idx] = targetValue;

                if (idx + 2 < n) {
                    int next = reverse(arr[idx + 1]);
                    arr[idx+1]=next;
                    int nextnext = reverse(arr[idx + 2]);
                    arr[idx+2]=nextnext;
                }
                else if(idx+1<n)
                {
                    int next=reverse(arr[idx+1]);
                    arr[idx+1]=next;
                }

            }
        }
        System.out.println(answer);
    }

    static int reverse(int a) {
        return a == 1 ? 0 : 1;
    }
}
