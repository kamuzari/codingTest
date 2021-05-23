package ProgrammersKit.DFS_BFS;

import java.util.*;

public class Network {
    public static void main(String[] args) {
        System.out.println(solution(3,new int[][]{
                {1, 0, 0}, {0, 1, 0}, {0, 0, 1}
        }));
        System.out.println(solution(3,new int[][]{
                {1, 1, 0}, {1, 1, 1}, {0, 1, 1}
        }));

    }
    static int parent[];
    public static int solution(int n, int[][] computers) {
        int answer=0;
        parent=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(computers[i][j]==1)
                {
                    union(i,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            find(i);
        }
        Set<Integer> set=new LinkedHashSet<>();
        for (int val : parent) {
            set.add(val);
        }
        answer=set.size();
        return answer;
    }
    static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a==b)
            return;
        if(a>b)
            parent[a]=b;
        else
            parent[b]=a;
    }
    static int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
}
