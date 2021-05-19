package WeeklyThuseday._0401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://velog.io/@lre12/LCA-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Lowest-Common-Ancestor
public class LCA_NearstCommonAncestor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            List<Integer>[] adjList = new List[n + 1];
            int parent[] = new int[n + 1];
            int[] depth = new int[n + 1];
            boolean[] vertax = new boolean[n + 1];
            for (int i = 1; i < n + 1; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt(); // 하위 노드
                vertax[b] = true; // 하위 노드에 대해서 방문 처리 나중에 루트가 어떤 것인지 판별하기 위해.
                adjList[a].add(b);
                adjList[b].add(a);
            }
            int root = 0;
            for (int i = 1; i < n + 1; i++) {
                if (vertax[i] == false)
                    root = i;
            }
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            dfs(adjList, depth, parent, root, 0, -1);
            LCA(depth, parent, v1, v2);
        }
    }

    private static void LCA(int[] depth, int[] parent, int v1, int v2) {
        int depth1 = depth[v1];
        int depth2 = depth[v2];
        while (depth1 > depth2) // depth1이 더 밑에 레벨에 있다면.
        {
            v1 = parent[v1];
            depth1--;
        }
        while (depth1 < depth2) {
            v2 = parent[v2];
            depth2--;
        }
        while (v1 != v2)
        {
            v1=parent[v1];
            v2=parent[v2];
        }
        // 만약 서로 다른 트리라면..? 어떻게 구별 할까..? =? unionFind 로 걸러내면 될 것 같다.
        System.out.println(v1);
    }

    // 정보 저장.
    private static void dfs(List<Integer>[] adjList, int[] depth, int[] parent, int cur, int a, int b) {
        // 파라미터 의미 : cur -> 현재 루트 vertax ,a-> 현재 레벨이 몇인지 , b-> 바로 위의 부모노드가 무엇인지.
        depth[cur]=a;
        parent[cur]=b;
        for (Integer integer : adjList[cur]) {
            if(integer!=b){
                dfs(adjList,depth,parent,integer,a+1,cur);
            }
        }
    }
}