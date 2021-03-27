package thisCodingTest.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 떡만들기
public class basic2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken()); // request Length

        st=new StringTokenizer(br.readLine());
        int mochi[]=new int[n];
        int minLen=0;
        int maxLen=-1;
        for (int i = 0; i < n; i++) {
            mochi[i]=Integer.parseInt(st.nextToken());
            maxLen=Math.max(maxLen,mochi[i]);
        }
/*
input
4 6
19 15 10 17
*/
        while (minLen<=maxLen)
        {
            int mid=(minLen+maxLen)/2;
            int rest=0;
            for (int i = 0; i < n; i++) {
                int a=mochi[i];
                if(a-mid<0)
                    continue;
                rest+=a-mid;
            }
            if(rest==m)
            {
                System.out.println(mid);
                return;
            }
            else if(rest<m)
            {
                maxLen=mid-1;
            }
            else {
                minLen=mid+1;
            }
        }




    }
}
