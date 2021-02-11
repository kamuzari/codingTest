package oneDay_twoSol.graphTheory;

import java.util.*;

public class Curriculum {
    static ArrayList<ArrayList<Integer>> adhList = new ArrayList<>();
    static int t[], passDegree[];
    static int n;
    static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        int result[] = new int[t.length];
       result=t.clone();

        for (int i = 1; i < n+1; i++) {
            if(passDegree[i]==0)
                q.add(i);
        }

        while (!q.isEmpty())
        {
            int cur=q.poll();
            for (Integer integer : adhList.get(cur)) {
                result[integer]=Math.max(result[integer],result[cur]+t[integer]);
                passDegree[integer]--;
                if(passDegree[integer]==0)
                    q.offer(integer);
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();

        for (int i = 0; i < n + 1; i++) {
            adhList.add(new ArrayList<>());
        }
        passDegree = new int[n + 1];
        sc.nextLine();
        t = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int time = sc.nextInt();
            t[i] = time;
            while (true) {
                int a = sc.nextInt();
                if (a == -1) break;
                passDegree[i] += 1;
                adhList.get(a).add(i);
            }
        }
        topologySort();


    }
}
/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */