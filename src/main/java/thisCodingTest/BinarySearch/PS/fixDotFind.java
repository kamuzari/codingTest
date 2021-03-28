package thisCodingTest.BinarySearch.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fixDotFind {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int ans= fixFind(arr);
        System.out.println(ans);
    }
    public static int fixFind(int[] arr)
    {
        int s=0;
        int e=arr.length-1;
        while (s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]==mid)
            {
                return mid;
            }
            else if(arr[mid]>mid)
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }

        return -1;
    }
}
/*
5
-15 -6 1 3 7
res = 3

7
-15 -4 2 8 9 13 15
res = 2

7
-15 -4 3 8 9 13 15
res =-1
*/