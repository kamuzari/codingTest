package thisCodingTest.Graph.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1976
public class GoTravel {
    static int parent[];
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        map=new int[n+1][n+1];
        parent=new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i]=i;
        }
        StringTokenizer st;
        for (int i = 1; i < n+1; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                {
                    Union(i,j);
                }
            }
        }
        boolean flag=true;
        st=new StringTokenizer(br.readLine());
        int criteria = parent[Integer.parseInt(st.nextToken())];
        for (int i = 0; i <m-1 ; i++) {
            int next=parent[Integer.parseInt(st.nextToken())];
            if(next!=criteria)
            {
                flag=false;
                break;
            }
        }
        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
    static void Union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a==b)
            return;
        else if(a<b)
            parent[b]=a;
        else
            parent[a]=b;
    }
    static int find(int v)
    {
        if(parent[v]==v)
            return v;
        return parent[v]=find(parent[v]);
    }

}
