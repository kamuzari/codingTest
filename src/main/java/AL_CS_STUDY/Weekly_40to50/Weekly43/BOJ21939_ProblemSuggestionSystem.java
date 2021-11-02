package AL_CS_STUDY.Weekly_40to50.Weekly43;

import java.io.*;
import java.util.*;

public class BOJ21939_ProblemSuggestionSystem {
    static class problem {
        private int number, level;

        public problem(int number, int level) {
            this.number = number;
            this.level = level;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            problem comp = (problem) o;
            return comp.number == this.number && comp.level == this.level;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, level);
        }
    }

    private static final String RECOMMEND = "recommend";
    private static final String SOLVED = "solved";
    private static final String ADD = "add";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> pNumber = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        StringTokenizer st;
        StringBuilder answers=new StringBuilder();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            pNumber.put(problem, level);
            if (map.containsKey(level)) {
                map.get(level).add(problem);
            } else {
                map.put(level, new TreeSet<>());
                map.get(level).add(problem);
            }
        }
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals(RECOMMEND)) {
                int notification = Integer.parseInt(st.nextToken());
                if (notification == -1) {
                    Integer key = map.firstKey();
                    TreeSet<Integer> set = map.get(key);
                    if (set.size() == 0) continue;
                    answers.append(set.first()+"\n");
                } else if (notification == 1) {
                    Integer key = map.lastKey();
                    TreeSet<Integer> set = map.get(key);
                    if (set.size() == 0) continue;
                    answers.append(set.last()+"\n");
                }
            } else if (cmd.equals(ADD)) {
                int problemNumber = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                pNumber.put(problemNumber, level);
                if (map.containsKey(level)) {
                    map.get(level).add(problemNumber);
                } else {
                    map.put(level, new TreeSet<>());
                    map.get(level).add(problemNumber);
                }
            } else if (cmd.equals(SOLVED)) {
                int problemNumber = Integer.parseInt(st.nextToken());
                Integer level = pNumber.remove(problemNumber);
                TreeSet<Integer> set = map.get(level);
                if (set.size() == 1) {
                    map.remove(level);
                } else {
                    map.get(level).remove(problemNumber);
                }
            }
        }
        System.out.println(answers);
    }
}
