package thisCodingTest.BinarySearch.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RouterInstall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int house[] = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            house[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(house);
        int s = 1;
        int e = house[n - 1] - house[0];
        int ans=0;
        while (s <= e) {
            int mid = (s + e) / 2;
            int val=house[0];
            int cnt=1;
            for (int i = 1; i < n; i++) {
                if(house[i]>=val+mid)
                {
                    val=house[i];
                    cnt++;
                }
            }
            if(cnt>=c)
            {
                s=mid+1;
                ans=mid;
            }
            else
                e=mid-1;
        }
        System.out.println(ans);

    }
}
