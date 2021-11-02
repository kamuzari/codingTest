package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ7662_DoublePriorityQueue {
    static final String DELETE = "D";
    static final String INSERT = "I";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder answers = new StringBuilder();
        while (test-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.keySet().toArray();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String cmd = st.nextToken();
                int val = Integer.parseInt(st.nextToken());
                if (cmd.equals(INSERT)) {
                    map.put(val, map.getOrDefault(val, 0) + 1);
                } else if (cmd.equals(DELETE)) {
                    if (map.size() == 0) continue;

                    else if (val == 1) {
                        int maxKey = map.lastKey();
                        if (map.get(maxKey) - 1 == 0) {
                            map.remove(maxKey);
                        } else {
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    } else if (val == -1) {
                        int minKey = map.firstKey();
                        if (map.get(minKey) - 1 == 0) {
                            map.remove(minKey);
                        } else {
                            map.put(minKey, map.get(minKey) - 1);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                answers.append("EMPTY\n");
            } else {
                answers.append(map.lastKey() + " " + map.firstKey()+"\n");
            }
        }
        System.out.println(answers);
    }
}
