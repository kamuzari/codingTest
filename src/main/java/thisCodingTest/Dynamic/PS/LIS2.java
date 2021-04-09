package thisCodingTest.Dynamic.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LIS2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // input Size =1,000,000         n^2  -> False nlog(n) 100_000_000 \\\   log 1000 = 10 , log 1000000 =100 딱 1억
    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(0);
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            int input=Integer.parseInt(st.nextToken());
            if(input> arrayList.get(arrayList.size()-1))
                arrayList.add(input);
            else
            {
                int l=0;
                int r= arrayList.size()-1;
                while (l<r)
                {
                    int mid=(l+r)>>1;
                    if(arrayList.get(mid)>=input)
                    {
                        r=mid;
                    }
                    else
                        l=mid+1;
                }
                arrayList.set(r,input);
            }
        }

        System.out.println(arrayList.size()-1);
    }
}
/*
5
1 4 5 2 3
*/