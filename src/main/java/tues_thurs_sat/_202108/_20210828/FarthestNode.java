package tues_thurs_sat._20210828;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://programmers.co.kr/learn/courses/30/lessons/49189
public class FarthestNode {
    public static void main(String[] args) {
        FarthestNode farthestNode = new FarthestNode();
        int n=6;
        int edges[][]={
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        };
        farthestNode.solution(n,edges);
    }
    ArrayList<Integer> list[];
    public int solution(int n,int edge[][])
    {
        int answer=0;
        list=new ArrayList[n+1];
        int dist[]=new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i]=new ArrayList<>();
            dist[i]=-1;
        }
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        bfs(dist);

        int farthestDistValue=Integer.MIN_VALUE;
        for (int i = 1; i < dist.length; i++) {
            if(farthestDistValue<dist[i])
            {
                answer=0;
                answer++;
                farthestDistValue=dist[i];
            }
            else if(farthestDistValue==dist[i])
            {
                answer++;
            }
        }
        if(farthestDistValue==-1)
            return -1;
        else
            return answer;
    }

    private void bfs(int[] distTable) {
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        distTable[1]=0;
        while (!q.isEmpty())
        {
            int cur=q.poll();
            for (Integer next : list[cur]) {
                if(distTable[next]==-1)
                {
                    distTable[next]=distTable[cur]+1;
                    q.offer(next);
                }
                else if(distTable[next]>distTable[cur]+1)
                {
                    distTable[next]=distTable[cur]+1;
                    q.offer(next);
                }
            }
        }
    }
}
