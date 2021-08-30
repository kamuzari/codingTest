package AL_CS_STUDY.Weekly_20to30.Weekly25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prerequisites {

    private static ArrayList<Integer> list[];
    private static int passDegree[];
    private static int n;
    private static int m;
    static  class Node{
        int vertax,orderedRank;

        public Node(int vertax, int orderedRank) {
            this.vertax = vertax;
            this.orderedRank = orderedRank;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list=new ArrayList[n+1];
        passDegree=new int[n+1];
        for (int i = 1; i < n+1; i++) {
          list[i]=new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            passDegree[b]++;
        }
        int answer[]=new int[n];
        Queue<Node> q=new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if(passDegree[i]==0)
                q.offer(new Node(i,1));
        }

        int cnt=2;
        while (!q.isEmpty())
        {
            Node cur = q.poll();
            answer[cur.vertax-1]=cur.orderedRank;
            for (Integer val : list[cur.vertax]) {
                passDegree[val]--;
                if(passDegree[val]==0)
                    q.offer(new Node(val,cur.orderedRank+1));
            }
            cnt++;
        }

//        System.out.println(Arrays.toString(answer));
        for (int val : answer) {
            System.out.print(val+" ");
        }
    }
}
