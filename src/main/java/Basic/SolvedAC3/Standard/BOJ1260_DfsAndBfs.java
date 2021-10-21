package Basic.SolvedAC3.Standard;

import java.util.*;
import java.io.*;

public class BOJ1260_DfsAndBfs {
    static List<Integer> list[];
    static boolean v[];
    private static List<Integer> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());
        list=new List[n+1];
        for (int i = 1; i < n+1; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        for (int i = 1; i < n+1; i++) {
            Collections.sort(list[i]);
        }
        v=new boolean[n+1];
        results = new ArrayList<>();
        dfs(startVertex,0);
        results.forEach(val ->System.out.print(val+" "));
        System.out.println();
        results.clear();
        v=new boolean[n+1];
        bfs(startVertex, results);
        results.forEach(val ->System.out.print(val+" "));
    }

    private static void bfs(int start,List<Integer> results) {
        LinkedList<Integer> q=new LinkedList<>();
        q.offer(start);
        v[start]=true;
        while (!q.isEmpty()){
            int cur=q.poll();
            results.add(cur);
            for(Integer next:list[cur]){
                if(v[next])continue;
                v[next]=true;
                q.offer(next);
            }
        }
    }

    private static void dfs(int start,int prev){
        v[start]=true;
        results.add(start);
        for(Integer next : list[start]){
            if(prev==next);
            if(v[next]) continue;
            dfs(next,start);
        }
    }
}
