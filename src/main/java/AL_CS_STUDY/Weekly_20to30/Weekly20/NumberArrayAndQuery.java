package AL_CS_STUDY.Weekly_20to30.Weekly20;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberArrayAndQuery {
    static int arr[],minTree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        arr=new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine()    );
        for (int i = 1; i < n+1; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        minTree=new int[n*4];
        init(1,n,1);

        int query=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < query; i++) {
            st=new StringTokenizer(br.readLine());
            int cmd=Integer.parseInt(st.nextToken() );
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            if(cmd==1)
            {
                update(1,n,1,a,b);
            }
            else
            {
                sb.append(minFind(1,n,1,a,b)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int init(int s,int e,int idx)
    {
        if(s==e)
        {
            return minTree[idx]=arr[s];
        }
        int mid=(s+e)/2;
        return minTree[idx]= Math.min(init(s,mid,idx*2),init(mid+1,e,idx*2+1));
    }

    static int minFind(int s,int e,int idx,int l,int r)
    {
        if(r<s || l>e)
            return Integer.MAX_VALUE;
        if(l<=s && e<=r)
            return minTree[idx];

        int mid=(s+e)/2;
        return Math.min(minFind(s,mid,idx*2,l,r),minFind(mid+1,e,idx*2+1,l,r));
    }

    static int update(int s,int e,int number,int idx,int val)
    {
        if(idx<s || idx>e)
            return minTree[number];

        if(s==e)
            return minTree[number]=val;

        int mid=(s+e)/2;
        return minTree[number]=Math.min(update(s,mid,number*2,idx,val),update(mid+1,e,number*2+1,idx,val));
    }
}
