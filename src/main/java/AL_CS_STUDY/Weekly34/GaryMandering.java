package AL_CS_STUDY.Weekly34;

import java.io.*;
import java.util.*;

public class GaryMandering {
    static final int MAX = Integer.MAX_VALUE;
    static List<Integer> list[];
    static int target = 0;
    private static int n;
    private static int answer = MAX;
    static Map<Integer, Integer> populations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            populations.put(i, Integer.parseInt(st.nextToken()));
            list[i] = new LinkedList<>();
        }
        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 1; j < split.length; j++) {
                list[i].add(Integer.parseInt(split[j]));
            }
        }

        for (int i = 1; i <= n / 2; i++) {
            target = i;
            comb(0, 1, new ArrayList<Integer>());
        }

        if(answer==MAX)
            System.out.println(-1);
        else
            System.out.println(answer);

    }

    static void comb(int cnt, int idx, ArrayList<Integer> A) {
        if (cnt == target) {
            mandering(A);
            return;
        }
        for (int i = idx; i <= n; i++) {
            A.add(i);
            comb(cnt + 1, i + 1, A);
            A.remove(A.size() - 1);
        }
    }

    private static void mandering(ArrayList<Integer> aRegions) {
        if (!isAdjConnected(aRegions)) {
            return;
        }

        ArrayList<Integer> bRegions = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (aRegions.contains(i))
                continue;
            bRegions.add(i);
        }
        if (!isAdjConnected(bRegions)) {
            return;
        }
        int aSum=0,bSum=0;
        aSum = getSum(aRegions);
        bSum = getSum(bRegions);
        int diff = Math.abs(aSum - bSum);
        answer=Math.min(answer,diff);
    }

    private static int getSum(ArrayList<Integer> regions) {
        int sum=0;
        for (Integer region : regions) {
            sum += populations.get(region);
        }
        return sum;
    }

    private static boolean isAdjConnected(ArrayList<Integer> aTeam) {
        boolean v[] = new boolean[n + 1];
        v[aTeam.get(0)] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(aTeam.get(0));

        int cnt = 1;
        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (Integer adjVertax : list[cur]) {
                if (!v[adjVertax] && aTeam.contains(adjVertax)) {
                    v[adjVertax] = true;
                    cnt++;
                    q.offer(adjVertax);
                }
            }
        }

        if (cnt == aTeam.size())
            return true;
        else
            return false;
    }

}
