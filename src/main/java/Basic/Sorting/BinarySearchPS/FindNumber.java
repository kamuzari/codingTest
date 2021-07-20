package Basic.Sorting.BinarySearchPS;

public class FindNumber {

    public static void main(String[] args) {
        int a=solution(7,new int[]{1,1,2,2,2,2,3},2);
        System.out.println(a);
    }
    public static int solution(int n,int arr[],int x)
    {
        int rightIdx=upperBound(arr,x,0,arr.length);
        int leftIdx=lowerBound(arr,x,0,arr.length);
        return rightIdx-leftIdx;
    }
    static int lowerBound(int arr[],int target,int start,int end)
    {
        while (start<end)
        {
            int mid=(start+end)/2;
            if(arr[mid]>=target)
                end=mid;
            else
                start=mid+1;
        }
        return end;
    }

    static int upperBound(int arr[],int target,int start,int end)
    {
        while (start<end)
        {
            int mid=(start+end)/2;
            if(arr[mid]>target)
                end=mid;
            else
                start=mid+1;
        }
        return end;
    }

}
