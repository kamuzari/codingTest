package AL_CS_STUDY.Weekly28;
import java.util.*;
import java.io.*;
public class Network {
    static int parent[];
        static class Edge implements Comparable<Edge>{
            int v1,v2,cost;

            public Edge(int v1, int v2, int cost) {
                this.v1 = v1;
                this.v2 = v2;
                this.cost = cost;
            }

            @Override
            public int compareTo(Edge another) {
                return cost-another.cost;
            }
        }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int vertaxNumber=Integer.parseInt(br.readLine());
        parent=new int[vertaxNumber+1];
        for (int i = 1; i < vertaxNumber+1; i++) {
            parent[i]=i;
        }
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int edgeNumber=Integer.parseInt(br.readLine());
        for (int i = 0; i < edgeNumber; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            pq.offer(new Edge(v1,v2,cost));
        }
        int edgeCnt=vertaxNumber-1;
        int answer=0;
        while (!pq.isEmpty())
        {
            Edge cur = pq.poll();
            int v1 = cur.v1;
            int v2 = cur.v2;
            int cost = cur.cost;
            if(find(v1)!=find(v2))
            {
                union(v1,v2);
                answer+=cost;
                edgeCnt--;
                if(edgeCnt==0)
                {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }

    static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a<b)
            parent[b]=a;
        else if(a>b)
            parent[a]=b;
    }
    static int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
}
