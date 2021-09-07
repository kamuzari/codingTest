package Basic.DFS_BFS;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ShortestTransferPath {

    private static int n,l;
    private static final int INF=Integer.MAX_VALUE;
    private static List<Integer>route[];
    private static int dist[];
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        route=new List[n+l+2];
        for (int i = 0; i < n+l+2; i++) {
            route[i]=new LinkedList<>();
        }
        for (int i = 1; i <= l; i++) {
            int dummy=n+i;
            String s[] = br.readLine().split(" ");
            for (int j = 0; j < s.length - 1; j++) {
                int node = Integer.parseInt(s[j]);
                route[dummy].add(node);
                route[node].add(dummy);
            }
        }
        dist =new int[n+l+2];
        st=new StringTokenizer(br.readLine());
        int startNode=Integer.parseInt(st.nextToken());
        int endNode=Integer.parseInt(st.nextToken());
        Queue<Integer> q=new LinkedList<>();
        dist[startNode]=1;
        q.offer(startNode);
        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (Integer node : route[cur]) {
                if(node<=n)
                {
                    dist[node]=dist[cur]+1;
                }
                else if(node>n)
                {
                    dist[node]=dist[cur];
                }
                q.offer(node);
            }
        }

    }
}
