package thisCodingTest.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DisjointSet {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        parent =new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(find(a)==find(b))
            {
                System.out.println("Cycle is True");
            }
            else
                union(a,b);

        }

        System.out.println(Arrays.toString(parent));

    }
    static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a<b)
        {
            parent[b]=a;
        }
        else
        {
            parent[a]=b;
        }
    }
    static int find(int element)
    {
        if(parent[element]==element)
            return element;
        return parent[element]=find(parent[element]); // 경로 압축.
//        return find(parent[element]);


    }

}