package Programmers.LV2.TwoSplitOfElectricNet;
import java.util.*;

public class TwoSplitOfElectricNet {
    // core logic := 하나씩 끊어본다? (완전 탐색)
    class Edge{
        private int v1,v2;
        public Edge(int v1,int v2){
            this.v1=v1;
            this.v2=v2;
        }

    }
    Map<Integer,Integer> map=new HashMap<>();
    List<Integer> list[];
    public int solution(int n, int[][] wires) {
        int answer = -1;
        list=new List[n+1];
        List<Edge> eList=new ArrayList<>();
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
            dfs(wire[0],closedVertexs,1,v); // 1번그룹 개수 count
            dfs(wire[1],closedVertexs,2,v); // 2번 그룹 개수 count
            int group1=map.get(1);
            int group2=map.get(2);
            int gap=Math.abs(group1-group2);
            // System.out.println(edge.v1+" <-> "+edge.v2 +" gap is a "+gap);
            if(gap<minGap) {
                minGap=gap;
            }
            map.clear();
        }
        answer=minGap;
        return answer;
    }
    public void dfs(int curV,Set<Integer> closedV,int groupNumber,boolean v[]){
        if(v[curV]) return;
        v[curV]=true;
        map.put(groupNumber,map.getOrDefault(groupNumber,0)+1);
        for(Integer next : list[curV]){
            if(closedV.contains(curV) && closedV.contains(next)) continue;
            dfs(next,closedV,groupNumber,v);
        }
    }
}
