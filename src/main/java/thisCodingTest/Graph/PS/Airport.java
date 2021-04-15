package thisCodingTest.Graph.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.acmicpc.net/problem/10775
public class Airport {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        parent=new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i]=i;
        }
        int airplane=Integer.parseInt(br.readLine());
        int cnt=0;
        for (int i = 0; i <airplane ; i++) {
            int input=Integer.parseInt(br.readLine());
            int findNumber=find(input);
            if(findNumber!=0) {
                union(findNumber, findNumber - 1);
                cnt++;
            }
            else
                break;
        }
        System.out.println(cnt);
    }
    static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a<b)
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
    //
}
