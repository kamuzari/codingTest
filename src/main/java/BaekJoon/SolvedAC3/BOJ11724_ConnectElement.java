package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11724_ConnectElement {

    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()   );
        int m=Integer.parseInt(st.nextToken()   );
        parent=new int[n+1];
        for (int i = 1; i <=n; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(find(a)!=find(b)){
                union(a,b);
            }
        }
        for (int i = 1; i <=n ; i++) {
            find(i);
        }
        Set<Integer> set=new HashSet<>();
        for (int i = 1; i <=n; i++) {
            set.add(parent[i]);
        }
        System.out.println(set.size());

    }
    static void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a<b){
            parent[b]=a;
        }else{
            parent[a]=b;
        }
    }
    static int find(int a){
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
}
