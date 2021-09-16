package tues_thurs_sat._202109._20210916;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class caving {
    int[] before;
    int[] reverseBefore;
    ArrayList<Integer> list[];
    boolean[] v;

    public boolean solution(int n, int[][] path, int[][] order) {
        list = new ArrayList[n];
        before = new int[n];
        reverseBefore = new int[n];
        v = new boolean[n];

        for (int i = 0; i < n; i++) { //
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < path.length; i++) {
            list[path[i][0]].add(path[i][1]);
            list[path[i][1]].add(path[i][0]);
        }

        for (int i = 0; i < order.length; i++) {
            before[order[i][1]] = order[i][0];
        }

        if (before[0] != 0) {
            return false;
        }

        v[0] = true;
        Queue<Integer> q = new LinkedList<>();
        for (int i : list[0]) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if(v[cur]) continue;
            if (!v[before[cur]]) {
                reverseBefore[before[cur]] = cur;
                continue;
            }
            v[cur] = true;
            for (Integer nextNode : list[cur]) {
                q.offer(nextNode);
            }

            q.offer(reverseBefore[cur]);
        }
        for (int i = 0; i < n; i++) {
            if(!v[i])
                return false;
        }
        return true;
    }
}
