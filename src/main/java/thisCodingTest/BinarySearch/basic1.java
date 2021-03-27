package thisCodingTest.BinarySearch;

import java.util.Arrays;

public class basic1 {

    public static void main(String[] args) {

        int n=5;
        int arr[]={8,3,7,9,2};
        int max=-1;
        for (int i = 0; i < n; i++) {
            max=Math.max(max,arr[i]);
        }
        int request=3;
        int req[]={5,7,9};


        System.out.println("\nbinarySearch");
        Arrays.sort(arr);
        for (int i = 0; i < request; i++) {
            int target=req[i];
            binarySearch(arr,0,n-1,target);
        }

        System.out.println("\n\ncount sort Using ");
        // 1. 계수 정렬 ,2.  Map 사용
        int cnt[]=new int[max+1];
        for (int i = 0; i < n; i++) {
            cnt[arr[i]]++;
        }
        for (int i = 0; i < request; i++) {
            if(cnt[req[i]]!=0)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }
    static void binarySearch(int arr[],int s,int e,int target)
    {
        while (s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]==target)
            {
                System.out.print("yes ");
                return;
            }
            else if(arr[mid]>target)
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        System.out.print("No ");
    }
}
