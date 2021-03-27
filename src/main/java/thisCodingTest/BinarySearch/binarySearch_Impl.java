package thisCodingTest.BinarySearch;

import java.util.*;

public class binarySearch_Impl {
    static Map<Integer, Integer> map = new HashMap<>();
    static final int N=10;
    public static void main(String[] args) {
        Random random = new Random();
        int r = random.nextInt(N) + 1;
        System.out.println(r);
        int arr[] = new int[r];
        for (int i = 0; i < r; i++) {
            int rand = random.nextInt(r) + 1;
            while (true) {
                if (map.containsKey(rand)) {
                    rand = random.nextInt(r) + 1;
                } else {
                    map.put(rand, 1);
                    arr[i] = rand;
                    break;
                }
            }
        }

        System.out.println("Original arr : " + Arrays.toString(arr));
        Arrays.sort(arr);
        int target=random.nextInt(N) + 1;
        System.out.println("target value => "+target);
        System.out.println("======== recursion =========");
        binarySearch_recursion(arr,0,r-1,target);
        System.out.println("======== loop =========");
        loop_binarySearch(arr,0,r-1,target);
        System.out.println("binarySearch arr : " + Arrays.toString(arr));
    }

    public static void binarySearch_recursion(int arr[], int start, int end, int target) {
        if(start>end)
        {
            System.out.println("Not Found");
            return;
        }
        int m=(start+end)/2;
        if(arr[m]==target)
        {
            System.out.println("found idx : "+ m);
            return;
        }

        if(arr[m]<target)
        {
            binarySearch_recursion(arr, m+1, end, target);
        }
        else
        {
            binarySearch_recursion(arr,start,m-1,target);

        }

    }

    public static  void loop_binarySearch(int arr[],int s,int e,int target)
    {
        while (s<=e)
        {
            int mid=(s+e)/2;
            if(arr[mid]==target)
            {
                System.out.println("findIdx : "+mid);
                return;
            }
            else if(arr[mid]<target)
            {
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }

        System.out.println("binarySearch_Impl.loop_binarySearch ==> NOT FOUND");
    }

}
