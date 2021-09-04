package tues_thurs_sat._20210817;
import java.util.*;
public class IslandConnect {
    class Node implements Comparable<Node>{
        private int v1,v2,cost;

        public Node(int v1,int v2,int cost)
        {
            this.v1=v1;
            this.v2=v2;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o1)
        {
            return this.cost-o1.cost;
        }

    }
    static int parent[];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent=new int[n+1];
        for(int i=1; i<n+1; i++)
        {
            parent[i]=i;
        }
        List<Node> nodes=new ArrayList<>();

        for(int[] arr:costs)
        {
            int v1=arr[0];
            int v2=arr[1];
            int cost=arr[2];
            nodes.add(new Node(v1,v2,cost));
        }
        Collections.sort(nodes);
        int edgeCnt=0;
        for(Node cur: nodes)
        {
            if(find(cur.v1)!=find(cur.v2))
            {
                union(cur.v1,cur.v2);
                answer+=cur.cost;
                edgeCnt++;
                if(edgeCnt==n-1)
                    break;
            }
        }
        return answer;
    }

    private void union(int a,int b)
    {
        a=find(a);
        b=find(b);

        if(a<b)
        {
            parent[b]=a;
        }
        else if(a>b)
        {
            parent[a]=b;
        }
    }
    private int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
}
