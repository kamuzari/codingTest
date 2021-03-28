package thisCodingTest.BinarySearch.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class findNumberOrderedArray2 {
    /*
7 2
1 1 2 2 2 2 3    (5-1)
result : 4

7 4
1 1 2 2 2 2 3

result : -1
    */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int cnt=cntByRange(arr,m);
        if(cnt==0)
            System.out.println(-1);
        else
            System.out.println(cnt);
    }

    static int cntByRange(int []arr,int target)
    {
        int r=upperBound(arr,target,0,arr.length);
        int l=lowerBound(arr,target,0,arr.length);
        System.out.println(r +" "+l);
        return r-l;
    }

    private static int upperBound(int[] arr, int target, int s, int e) {
        while (s<=e-1)
        {
            int mid=(s+e)/2;
            if(arr[mid]>target)
                e=mid-1;
            else
                s=mid+1;
        }
        return e;
    }

    private static int lowerBound(int[] arr, int target, int s, int e) {
        while (s<=e-1)
        {
            int mid=(s+e)/2;
            if(arr[mid]>=target)
                e=mid-1;
            else
                s=mid+1;
        }
        return e-1;
    }
    // 0 0 1 1 1  (0,1,2,3,4)   4-2 =2
}
