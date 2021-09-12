package Basic.Tree;
import java.util.*;
import java.io.*;
public class TreeParentSearch {
    private static List<Integer> adjList[];
    private static int n;
    private static boolean v[];
    private static int parentTable[];
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adjList=new List[n +1];
        for (int i = 1; i < n +1; i++) {
            adjList[i]=new LinkedList<>();
        }
        for (int i = 1; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        int start=1;
        int[] answers = bfs(start);
        StringBuffer sb=new StringBuffer();
        for (int i = 2; i < answers.length; i++) {
            sb.append(answers[i]).append("\n");
        }
        System.out.println(sb);
        System.out.println();
        parentTable=new int[n+1];
        parentTable[1]=1;
        v=new boolean[n+1];
        dfs(1);
        System.out.println(Arrays.toString(parentTable));
    }
    static final int NO_PARENT=0;
    private static int[] bfs(int start) {
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(start);
        int[] parent = new int[n + 1];

        parent[start]=1;
        while (!q.isEmpty())
        {
            Integer cur = q.poll();
            for (Integer next : adjList[cur]) {
                if(parent[next]==NO_PARENT)
                {
                    parent[next]=cur;
                    q.offer(next);
                }
            }
        }
        return parent;
    }
    private static void dfs(int parent)
    {
        v[parent]=true;
        for (Integer next : adjList[parent]) {
            if(!v[next])
            {
                parentTable[next]=parent;
                dfs(next);
            }
        }
    }
}
