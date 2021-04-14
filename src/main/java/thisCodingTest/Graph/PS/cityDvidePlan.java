package thisCodingTest.Graph.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class cityDvidePlan {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<Info> list=new ArrayList<>();
        parent=new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list.add(new Info(a,b,w));
        }
        int ans=0;
        int cnt=0;
        Collections.sort(list);
        for (Info info : list) {
            if(cnt==n-2)
                break;
            if(find(info.v1)!=find(info.v2))
            {
                Union(info.v1,info.v2);
                ans+=info.cost;
                cnt++;
            }
        }

        System.out.println(ans);



    }
    static void Union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a>b)
        {
            parent[b]=a;
        }
        else
        {
            parent[a]=b;
        }
    }
    static int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
    static class Info implements Comparable<Info>{
        int v1,v2,cost;

        public Info(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return cost-o.cost;
        }
    }
}
