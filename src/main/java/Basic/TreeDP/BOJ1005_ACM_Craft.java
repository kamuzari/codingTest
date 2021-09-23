package Basic.TreeDP;

import java.util.*;
import java.io.*;
public class BOJ1005_ACM_Craft {
    static int n;
    static int k;
    static int[] passDegree;
    static int[] time;
    static ArrayList<ArrayList<Integer>> list ;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            passDegree = new int[n + 1];
            time = new int[n + 1];
            ans=new int[n+1];
            list=new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }
            st=new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                st=new StringTokenizer(br.readLine());
                int a = Integer.parseInt(br.readLine());
                int b = Integer.parseInt(br.readLine());
                list.get(a).add(b);
                passDegree[b] += 1; // 진입차수 증가.
            }

            target = Integer.parseInt(br.readLine());
            topology();
        }
    }
    static int ans[],target;
    public static void topology() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (passDegree[i] == 0)
            {
                q.offer(i);
                ans[i]= time[i];
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer i : list.get(cur)) {
                passDegree[i]--;
                ans[i]=Math.max(ans[cur]+ time[i], ans[i]);
                if (passDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        System.out.println(ans[target]);
    }
}
