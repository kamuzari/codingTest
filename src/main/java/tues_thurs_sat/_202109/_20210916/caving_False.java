package tues_thurs_sat._202109._20210916;

import java.util.*;

public class caving_False {
    public static void main(String[] args) {
        int p[][] = {{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}};
        int o[][] = {{8, 5}, {6, 7}, {4, 1}};
        caving_False v = new caving_False();
        System.out.println(v.solution(9, p, o));
    }

    private boolean v[];
    private List<Integer> list[];
    private Map<Integer, Integer> preCondition;
    private Map<Integer, Integer> reversPreCondition;

    public boolean solution(int n, int[][] path, int[][] order) {
        v = new boolean[n];
        list = new List[n];
        preCondition = new HashMap<>();
        reversPreCondition = new HashMap<>();
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < path.length; i++) {
            int a = path[i][0];
            int b = path[i][1];
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < order.length; i++) {
            int a = order[i][0];
            int b = order[i][1];
            preCondition.put(b ,a);
            reversPreCondition.put(a,b);
        }

        if(preCondition.containsKey(0))
            return false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (v[cur]) {
                continue;
            }
            v[cur] = true;
            for (Integer nextNode : list[cur]) {
                if (!preCondition.containsKey(nextNode)) {
                    q.offer(nextNode);
                    if(reversPreCondition.containsKey(nextNode)){
                        Integer preconditionKey = reversPreCondition.get(nextNode);
                        preCondition.remove(preconditionKey);
                        q.offer(preconditionKey);
                    }
                } else {
                    int condition = preCondition.get(nextNode).intValue();
                    if (!v[condition]) {
                        continue;
                    } else if (v[condition]) {
                        q.offer(nextNode);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(!v[i])
            {
                return false;
            }
        }
        return true;
    }
}
