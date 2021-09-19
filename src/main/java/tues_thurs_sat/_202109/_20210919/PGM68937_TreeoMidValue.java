package tues_thurs_sat._202109._20210919;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PGM68937_TreeoMidValue {
    public static void main(String[] args) {
        int edges[][]={{1,2},{2,3},{3,4}};
        PGM68937_TreeoMidValue sol = new PGM68937_TreeoMidValue();
        System.out.println(sol.solution(4, edges));
    }

    List<Integer> list[];
    public int solution(int n, int[][] edges) {
        int answer = 0;
        list=new List[n+1];
        for(int i=1; i<n+1; i++){
            list[i]=new ArrayList<>();
        }

        for(int[] e:edges){
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }

        int max=0;
        int start=1;
        int results[]=bfs(1,n); //1번에서 가장 먼 노드 찾기

        for(int i=1;i<n+1; i++){
            if(results[i]>results[start]){
                start=i;
                max=Math.max(max,results[start]);
            }
        }
        results=bfs(start,n);// 1번에서 가장 멀리 떠어진 노드에서 먼 노드 찾기
        start=1;
        for(int i=1;i<n+1; i++){
            if(results[i]>results[start]){
                start=i;
                max=results[i];
            }
        }
       int cnt=0;
        for(int val: results){
            if(max==val){
                ++cnt;
            }
        }
        // 1번을 제외하고 가장 먼 노드가 또 있으면(cnt==2) 중간 값은 max
        if(cnt>=2){
            return max;
        }

        results=bfs(start,n);
        for(int i=1; i<n+1; i++){
            if(results[i]>results[start]){
                start=i;
                max=results[i];
            }
        }
        cnt=0;
        for(int val: results){
            if(max==val){
                ++cnt;
            }
        }
        if(cnt>=2){
            return max;
        }
        return max-1;
    }
    public int[] bfs(int startVertex,int n)
    {
        boolean v[]=new boolean[n+1];
        int dist[]=new int[n+1];
        LinkedList<Integer> q=new LinkedList<>();
        q.offer(startVertex);
        v[startVertex]=true;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int next : list[cur]){
                if(!v[next] && next!=cur){
                    v[next]=true;
                    q.offer(next);
                    dist[next]=dist[cur]+1;
                }
            }
        }

        return dist;
    }
}
