package programmers.Kits.Graph;

import java.util.*;

public class FarthestNode {
    public static void main(String[] args) {
        int v[][]={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6,v));
    }
    static int INF=(int)1e9;
    static ArrayList<Integer> list[]=new ArrayList[20_001];
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int dist[]=new int[20_001];
        for (int i = 0; i < 20_001; i++) {
            list[i]=new ArrayList<>();
            dist[i]=-1;
        }

        for (int i = 0; i < edge.length; i++) {
            int[] vertaxs = edge[i];
            list[vertaxs[0]].add(vertaxs[1]);
            list[vertaxs[1]].add(vertaxs[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        dist[1]=0;
        while (!q.isEmpty())
        {
            Integer cur = q.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                int next=list[cur].get(i);
                if(dist[next]==-1)
                {
                    dist[next]=dist[cur]+1;
                    q.offer(next);
                }
            }
        }
        int[] copy = dist.clone();
        int max=-1;
        for (int val : dist) {
            max=Math.max(val,max);
        }
        for (int val : dist) {
            if(max==val)
                answer++;
        }

        return answer;
    }
}
