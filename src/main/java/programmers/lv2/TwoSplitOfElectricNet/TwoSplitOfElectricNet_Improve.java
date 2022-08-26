package programmers.lv2.TwoSplitOfElectricNet;

import java. util.*;
public class TwoSplitOfElectricNet_Improve {
    int cnt=0;
    List<Integer> list[];
    public int solution(int n, int[][] wires) {
        int answer = -1;
        list=new List[n+1];
        for(int i=1; i<n+1; i++){
            list[i]=new ArrayList<>(); // 인접 리스트
        }
        for(int i=0; i<wires.length; i++){
            int v1=wires[i][0];
            int v2=wires[i][1];
            list[v1].add(v2);
            list[v2].add(v1);
        }

        int minGap=100;

        for(int[] wire : wires){
            boolean v[]=new boolean[n+1];
            Set<Integer> closedVertexs=new HashSet<>();
            closedVertexs.add(wire[0]);
            closedVertexs.add(wire[1]);
            cnt=0;
            dfs(wire[0],closedVertexs,v); // 1번그룹 개수 count
            // 한번더 돌릴 필요 없이 두 그룹이므로 n-1그룹 = 2번 그룹 개수.
            // dfs(wire[1],closedVertexs,2,v); // 2번 그룹 개수 count

            int group1=cnt;
            int group2=n-group1;
            int gap=Math.abs(group1-group2);
            // System.out.println(edge.v1+" <-> "+edge.v2 +" gap is a "+gap);
            if(gap<minGap) {
                minGap=gap;
            }
        }
        answer=minGap;
        return answer;
    }
    public void dfs(int curV,Set<Integer> closedV,boolean v[]){
        if(v[curV]) return;

        cnt++;
        v[curV]=true;
        for(Integer next : list[curV]){
            if(closedV.contains(curV) && closedV.contains(next)) continue;
            dfs(next,closedV,v);
        }
    }
}
