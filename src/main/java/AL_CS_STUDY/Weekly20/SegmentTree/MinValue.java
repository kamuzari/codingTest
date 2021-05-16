package AL_CS_STUDY.Weekly20.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10868
public class MinValue {
    static int []arr,minTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        arr=new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        minTree=new int[n*4];
        init(1,n,1);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            sb.append(minFind(1,n,1,l,r)).append("\n");
        }
        System.out.println(sb);
    }
    static int init(int s,int e,int number)
    {
        if(s==e)
            return minTree[number]=arr[s];

        int mid=(s+e)/2;
        return minTree[number]=Math.min(init(s,mid,number*2),init(mid+1,e,number*2+1));
    }

    public static int minFind(int s,int e,int number,int l,int r)
    {
        if(r<s || e<l)
            return Integer.MAX_VALUE;

        if(l<=s && e<=r)
        {
            return minTree[number];
        }

        int mid=(s+e)/2;
        return Math.min(minFind(s,mid,number*2,l,r),minFind(mid+1,e,number*2+1,l,r));
    }
}
