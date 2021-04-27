package AL_CS_STUDY.Weekly18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sebu_Krukal {
    static int n,m;
    static int start,arrival;
    static int parent[];
    static class Node implements Comparable<Node>
    {
        private int v1, v2,dist;

        public Node(int v1, int v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return o.dist-dist;
        }
    }

    static ArrayList<Node> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        parent=new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            parent[i]=i;
        }
        st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        arrival=Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list.add(new Node(v1,v2,w));
        }
        Collections.sort(list);
        int ans = kruskal();
        System.out.println(ans);

    }
   static int kruskal()
   {
       int ans=Integer.MAX_VALUE;
       for (Node cur : list) {
           if(find(cur.v1)!=find(cur.v2))
           {
               Union(cur.v1,cur.v2);
               ans=Math.min(ans,cur.dist);
           }
           if(find(start)==find(arrival))
           {
               return ans;
           }
       }
       return 0;
   }

    static void Union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a<b)
            parent[b]=a;
        else
            parent[a]=b;
    }
    static int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
}
/*
7 9
1 5
1 2 1
1 7 1
2 3 1
3 7 1
4 6 1
6 7 1
5 6 1
5 7 1
3 5 100
*/