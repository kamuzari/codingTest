package Basic.CompleteSearch_BackTracking;

import java.util.*;

public class diffMax {
//    static int temp[];
    static int arr[];
    static boolean visited[];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
//        temp=new int[n];
        visited=new boolean[n];
        permutation(0);
        System.out.println(MAX_SUM);

        int On=1;
        for (int i = 8; i >=1 ; i--) {
            On*=i;
        }
        System.out.println(On);
    }
    static Stack<Integer> s=new Stack<>();
    static int MAX_SUM=0;
    public static void permutation(int cnt)
    {
        if(cnt==n)
        {
            MAX_SUM=Math.max(calc(s),MAX_SUM);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i])
            {
                visited[i]=true;
                s.push(arr[i]);
                permutation(cnt+1);
                s.pop();
                visited[i]=false;
            }
        }


    }

    public static int calc(Stack<Integer> s)
    {
        int sum=0;
        int temp[]=new int[n];
        int idx=0;
        for (Integer i : s) {
            temp[idx++]=i;
        }
        for (int i = 0; i < n-1; i++) {
            sum+=Math.abs(temp[i]-temp[i+1]);
        }
        return sum;
    }


}



// 20 15 10 8 4 1
 // 20-1 1-15 15-4 4-10 10-8 /19 14 11 6 2