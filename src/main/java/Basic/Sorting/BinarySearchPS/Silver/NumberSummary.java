package Basic.Sorting.BinarySearchPS.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSummary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(br.readLine());
        long answer=binary(n);
        System.out.println(answer);
    }
    static long binary(long n)
    {
        long answer=0;
        long s=0;
        long e=n;
        while (s <= e)
        {
            long mid=(s+e)/2;
            long sum=( mid*(mid+1) )/2;
            if(sum <=n)
            {
                answer=mid;
                s=mid+1;
            }
            else
                e=mid-1;
        }
        return answer;
    }

    static long loop(long n) {
        long sum = 0;
        long addNum = 0;
        while(n >= sum) {
            sum += ++addNum;
        }

        return addNum - 1;
    }
}
