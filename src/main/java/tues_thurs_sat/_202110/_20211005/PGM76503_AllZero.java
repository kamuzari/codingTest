package tues_thurs_sat._202110._20211005;

import java.util.*;
public class PGM76503_AllZero {
    long answer=0;
    long dp[];
    List<Integer> list[];
    public long solution(int[] a, int[][] edges) {
        int n=a.length;
        list=new List[n];
        dp=new long[n];
        for(int i=0; i<n; i++){
            answer+=dp[i]=a[i];
            list[i]=new ArrayList<>();
        }
        if(answer!=0){
            return -1;
        }
        int inDegree[]=new int [n];
        for(int i=0; i<edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            list[from].add(to);
            list[to].add(from);
            inDegree[from]++;
            inDegree[to]++;
        }
        topologySort(n,inDegree);
        return answer;
    }
    public void topologySort(int n,int [] degree){
        Queue<Integer> q=new LinkedList<>();
        boolean v[]=new boolean[n];
        for(int i=0; i<n; i++){
            if(degree[i]==1){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            v[cur]=true;

            for(int next : list[cur]){
                if(!v[next])
                {
                    degree[next]--;
                    dp[next]+=dp[cur];
                    answer+=Math.abs(dp[cur]);
                    if(degree[next]==1){
                        q.offer(next);
                    }
                }
            }
        }
    }
}
