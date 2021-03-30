package AL_CS_STUDY.Weekly14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class subSequenceSum {
    static int n,arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int ans=Integer.MAX_VALUE;
        int sum=0;
        int ptr1=0;
        int ptr2=0;
        while (true)
        {
            if(sum>=s)
            {
                ans=Math.min(ans,(ptr2-ptr1));
                sum-=arr[ptr1++];
            }
            else if(ptr2==n)
                break;
            else
            {
                sum+=arr[ptr2++];
            }
        }
        if(ans==Integer.MAX_VALUE)
            System.out.println(0);
        else {
            System.out.println(ans);
        }
    }

}
