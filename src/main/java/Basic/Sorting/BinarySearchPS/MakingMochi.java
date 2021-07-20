package Basic.Sorting.BinarySearchPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakingMochi {
    private static int arr[];
    private static int mochiNumber;
    private static int askedMochiLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        mochiNumber = Integer.parseInt(st.nextToken());
        askedMochiLength = Integer.parseInt(st.nextToken());
        arr=new int[mochiNumber];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < mochiNumber; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        binarySearch(askedMochiLength);

    }

    private static void binarySearch(int target) {
        int l=0;
        int r=2_000_000_000; // 떡의 최대길이 또는 한계값.
        int answer=0;
        while (l<=r) {
            int mid = (l + r) / 2;
            int restLength = calc(mid);

            if (restLength == askedMochiLength) {
                System.out.println(mid);
                return;
            } else if (restLength >= askedMochiLength) {
                answer=mid;
                l = mid+ 1;
            } else if (restLength < askedMochiLength)
            {
                r=mid-1;
            }
        }
        System.out.println(answer);
    }

    private static int calc(int h) {
        int totalLength=0;
        for (int i = 0; i < mochiNumber; i++) {
             if(arr[i]>h)
            {
                totalLength+=arr[i]-h;
            }
        }
        return totalLength;
    }
}
/*
4 6
19 15 10 17
answer : 15
*/
