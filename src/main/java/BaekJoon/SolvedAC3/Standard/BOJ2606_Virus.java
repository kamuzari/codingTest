package BaekJoon.SolvedAC3.Standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2606_Virus {
    static List<Integer> list[];
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list=new List[n +1];
        for (int i = 1; i < n +1; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from =Integer.parseInt(st.nextToken());
            int to =Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        int answer = spreadVirus(1);
        System.out.println(answer);


    }
    static int spreadVirus(int s){
        int answer=0;
        LinkedList<Integer> q=new LinkedList<>();
        q.offer(s);
        boolean v[]=new boolean[n+1];
        v[s]=true;
        while (!q.isEmpty()){
            Integer cur = q.poll();
            for(Integer next:list[cur]){
                if(!v[next]){
                    q.offer(next);
                    v[next]=true;
                    answer++;
                }
            }
        }
        return answer;
    }
}
