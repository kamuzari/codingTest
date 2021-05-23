package ProgrammersKit.DFS_BFS;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Network {
    public static void main(String[] args) {
        System.out.println(solution(3,new int[][]{
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
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
                if(i!=j &&computers[i][j]!=0)
                {
                    if(find(i)!=find(j))
                        union(i,j);
                }
            }
        }
        Set<Integer> set=new LinkedHashSet<>();
        for (int val : parent) {
            set.add(val);
        }
        return set.size();
    }
    static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
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
