package oneDay_twoSol.graphTheory.Grouping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ACM_Craft {
    static int n;
    static int k;
    static int[] passDegree;
    static int[] time;
    static ArrayList<ArrayList<Integer>> list ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            passDegree = new int[n + 1];
            time = new int[n + 1];
            ans=new int[n+1];
            list=new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 1; i < n + 1; i++) {
                time[i] = sc.nextInt();
            }

            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                list.get(a).add(b);
                passDegree[b] += 1; // 진입차수 증가.
            }
            target = sc.nextInt();
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
                ans[i]= time[i]; // 해당 건물을 짓는데 미리 지어야할 건물이 없는 경우.
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer i : list.get(cur)) {
                passDegree[i]--;
                // core 해당 건물을 짓는데 걸리는 시간 = 이전에 지어야할 건물의 시간+현재 건물을 짓는데 걸리는 시간
                //  ,이전에 다른 건물에 의해서 만들어진 걸린시간의 최대 걸리는 시간 중 가중 오랜 시간이 걸린 것을 택
                ans[i]=Math.max(ans[cur]+ time[i], ans[i]);
                if (passDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        System.out.println(ans[target]);
    }
}

// 30 +