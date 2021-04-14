package thisCodingTest.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Topology {
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    static int passDegree[];
    static int v,e;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        passDegree=new int[v+1];

        for (int i = 0; i < v+1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            passDegree[b]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i = 1; i < v+1; i++) {
            if(passDegree[i]==0)
                q.offer(i);
        }

        // logic

        ArrayList<Integer> res=new ArrayList<>();
        while (!q.isEmpty())
        {
            int cur=q.poll();
            res.add(cur);
            for (Integer val : list.get(cur)) {
                passDegree[val]--;
                if(passDegree[val]==0)
                    q.offer(val);
            }
        }

        System.out.println(res);

    }
}
    /*
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
    */
