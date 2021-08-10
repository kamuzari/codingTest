package Basic.Sorting.BinarySearchPS.gold;

import java.io.*;
import java.util.StringTokenizer;

public class PaperAndScissors {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        long n=Long.parseLong(st.nextToken());
        long k=Long.parseLong(st.nextToken());
        long s=0;
        long e=n/2+1;
        while (s<=e)
        {
            long mid=s+e >> 1;
            long answer=(mid+1) * (n-mid+1);
            if(answer==k) {
                System.out.println("YES");
                return;
            }
            else
            {
                if(s==e) break;;
                if(answer>k)
                    e=mid-1;
                else
                    s=mid+1;
            }
        }
        System.out.println("NO");

    }
}
