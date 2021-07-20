package Basic.Sorting.BinarySearchPS;

public class FixPointSearch {
    public static void main(String[] args) {
        int a=solution(5,new int[]{-15,-6,1,3,7});
        System.out.println("a = " + a);
        int b=solution(7,new int[]{-15,-4,2,8,9,13,15});
        System.out.println("b = " + b);
        int c=solution(7,new int[]{-15,-4,3,8,9,13,15});
        System.out.println("c = " + c);
    }
    public static int solution(int n,int arr[])
    {
        int answer=-1;
        int l=0;
        int r=arr.length-1;
        while (l<=r)
        {
            int mid=(l+r)/2;
            if(arr[mid]==mid)
                return mid;
            else if(arr[mid]>mid)
            {
                r=mid-1;
            }
            else if(arr[mid]<mid)
            {
                l=mid+1;
            }
        }
        return answer;
    }
}

