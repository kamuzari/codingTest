package Basic.Sorting.BinarySearchPS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class stampCutting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[]=new int[N];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int max = Arrays.stream(arr).reduce(Integer::max)
                .orElseThrow(NoSuchElementException::new);
        binarySearch(N,arr,M);

    }

    private static void binarySearch(int n, int[] arr,int target) {
        long answer=0;
        long s=1;
        long e = Arrays.stream(arr).reduce(Integer::max)
                .orElseThrow(NoSuchElementException::new);

        while (s<=e)
        {
            long mid= (s+e)/2;
            long restStamp=calc(n,arr,mid);

            if(restStamp>=target)
            {
                answer=Math.max(mid,answer);
                s=mid+1;
            }
            else
                e=mid-1;

        }
        System.out.println(answer);
    }

    private static long calc(int n, int[] arr,long mid) {
        long restLength=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]>mid)
            {
                restLength+=arr[i]-mid;
            }
        }
        return restLength;
    }
}
