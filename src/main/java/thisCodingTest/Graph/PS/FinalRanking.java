package thisCodingTest.Graph.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FinalRanking {
    static int n,m;
    static int passDegree[];
    static int rank[];
    static boolean[][] graph;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in))  ;
        int T=Integer.parseInt(br.readLine());
        while (T-->0)
        {
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            passDegree=new int[n+1];
            ArrayList<Integer> rank=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                rank.add(Integer.parseInt(st.nextToken()));
            }
            graph=new boolean[n+1][n+1];
            // 5 4 3 2 1

            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    graph[rank.get(i)][rank.get(j)]=true;
                    passDegree[rank.get(j)]++;
                }
            }
            int m=Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                if(graph[a][b])
                {
                    graph[a][b]=false;
                    graph[b][a]=true;
                    passDegree[b]--;
                    passDegree[a]++;
                }
                else
                {
                    graph[a][b]=true;
                    graph[b][a]=false;
                    passDegree[a]--;
                    passDegree[b]++;
                }
            }

            ArrayList<Integer>ans=new ArrayList<>();
            Queue<Integer> q=new LinkedList<>();
            for (int i = 1; i < n+1; i++) {
                if(passDegree[i]==0)
                    q.offer(i);
            }
//            System.out.println(Arrays.toString(passDegree));

            boolean certain=true;
            boolean cycle=false;

            for (int i = 0; i < n; i++) {
                if(q.size()==0)
                {
                    cycle=true;
                    break;
                }
                if(q.size()>1)
                {
                    certain=false;
                    break;
                }

                int cur=q.poll();
                ans.add(cur);
                for (int j = 1; j < n+1; j++) {
                    if(graph[cur][j])
                    {
                        passDegree[j]--;
                        if(passDegree[j]==0)
                            q.offer(j);
                    }
                }
            }

            if(cycle)
                sb.append("IMPOSSIBLE\n");
            else if(!certain)
            {
                sb.append("?\n");
            }
            else
            {
                for (Integer val : ans) {
                    sb.append(val+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
