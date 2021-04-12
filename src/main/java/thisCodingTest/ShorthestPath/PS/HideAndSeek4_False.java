package thisCodingTest.ShorthestPath.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/13913
public class HideAndSeek4_False {
    static int dx[]={2,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int subin=Integer.parseInt(st.nextToken());
        int sister=Integer.parseInt(st.nextToken());
        int dist[]=new int[100_001];
        int path[]=new int[100_001];
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(subin));
        Arrays.fill(dist,(int)1e9);
        dist[subin]=0;
        while (!q.isEmpty())
        {
            Node cur=q.poll();
            if(cur.x==sister)
            {
                System.out.println(dist[cur.x]);
                cur.arr.add(sister);
                for (Integer integer : cur.arr) {
                    System.out.printf(integer+" ");
                }
                break;
            }
            for (int i = 0; i < 3; i++) {
                int nx=0;
                if(i==0)
                {
                    nx=dx[i]*cur.x;
                }
                else
                {
                    nx=dx[i]+cur.x;
                }

                if(nx>=0 && nx<100_001)
                {

                     if(dist[nx]>=dist[cur.x]+1)
                    {
                        Node node = new Node(nx);
                        node.arr.addAll(cur.arr);
                        node.arr.add(cur.x);
                        q.offer(node);
                        dist[nx]=dist[cur.x]+1;
                    }
                }
            }
        }
    }
    static class Node
    {
        int x;
        ArrayList<Integer> arr=new ArrayList<>();

        public Node(int x) {
            this.x = x;
        }
    }
}
