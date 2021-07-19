package Basic.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
    static int n, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(val)).append("\n");
        }
        System.out.println(sb);

    }

    private static int binarySearch(int target) {
        int l=0;
        int r=n-1;

        while (l<=r)
        {
            int mid=(l+r)/2;
            if(arr[mid]==target) {
                return 1;
            }
            else if(arr[mid]>target)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return 0;
    }
}
