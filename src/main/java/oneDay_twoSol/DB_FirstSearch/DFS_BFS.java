package oneDay_twoSol.DB_FirstSearch;

import java.util.*;

public class DFS_BFS {
    static ArrayList<ArrayList<Integer>> adjacentList = new ArrayList<>();
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start_Vertax = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i <= n; i++) {
            adjacentList.add(new ArrayList<Integer>());
        }
        for (int i = 1; i <= m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            adjacentList.get(a).add(b);
            adjacentList.get(b).add(a);
        }
        for (int i = 1; i <=n; i++) {
            if(!adjacentList.get(i).isEmpty())
                Collections.sort(adjacentList.get(i));
        }
       /* for (int i = 0; i <adjacentList.size() ; i++) {
            System.out.println(adjacentList.get(i));
        }*/

        visited=new boolean[n+1];
        dfs(start_Vertax);
        visited=new boolean[n+1];
        System.out.println();
        bfs(start_Vertax);

    }

    static void dfs(int vertax) {
        System.out.print(vertax + " ");
        visited[vertax] = true;
        for (int i = 0; i <adjacentList.get(vertax).size() ; i++) {
            int temp=adjacentList.get(vertax).get(i);
                if (!visited[temp])
                {   dfs(temp);
                }
        }
    }
    static void bfs(int vertax)
    {
        Queue<Integer> q=new LinkedList<>();
        q.offer(vertax);

        visited[vertax]=true;
        while (!q.isEmpty())
        {
            int temp=q.poll();
            System.out.print(temp+" ");
            for (int i = 0; i <adjacentList.get(temp).size() ; i++) {
                int v=adjacentList.get(temp).get(i);
                if(!visited[v])
                {
                    q.offer(v);
                    visited[v]=true;
                }
            }
        }

    }

}
