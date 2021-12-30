package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11725_ParentSearchOfTree {

    static final int ROOT = 1;
    static int parentDfs[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parentDfs = new int[n + 1];
        StringTokenizer st;
        // 자료구조를 어떤 것을 선택해야 할까? :=  인접 리스트? ...?
        List<List<Integer>> list = new ArrayList<>();
        adjListInit(n, list);
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        int[] answer = bfs(ROOT, n, list);
        dfs(ROOT,list);
        printAnswer(answer);
    }

    private static void printAnswer(int [] parents){
        for (int i = 2; i <parents.length ; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void adjListInit(int n, List<List<Integer>> list) {
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
    }

    static int[] bfs(int root, int size, List<List<Integer>> adjList) {
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(root);
        int[] parent = new int[size + 1];

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            for (Integer next : adjList.get(cur)) {
                if(next==ROOT) continue;
                if (parent[next] == 0) {
                    parent[next] = cur;
                    q.offer(next);
                }
            }
        }
        return parent;
    }

    static void dfs(int currentNode,List<List<Integer>> adjList) {
        for(Integer next : adjList.get(currentNode)){
            if(next==ROOT) continue;
            if(parentDfs[next]==0){
                parentDfs[next]=currentNode;
                dfs(next,adjList);
            }
        }
    }

}
