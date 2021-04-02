package mon_wed_fri.RT20210402;

import java.util.*;

public class diamondShopping {
    public static void main(String[] args) {
        String a[] = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String b[] = {"AA", "AB", "AC", "AA", "AC"};
        String c[] = {"XYZ", "XYZ", "XYZ"};
        String d[] = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(Arrays.toString(solution(a)));
        System.out.println(Arrays.toString(solution(b)));
        System.out.println(Arrays.toString(solution(c)));
        System.out.println(Arrays.toString(solution(d)));
    }

    static Map<String, Integer> map = new HashMap<>();

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int l = 0;
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        int s = 0;
        Queue<String> q = new LinkedList<>();
        int len = gems.length+1;
        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            q.add(gems[i]);
            while (true) {
                String str = q.peek();
//                System.out.println(map.get(str));
                if (map.get(str) > 1) {
                    q.poll();
                    s++;
                    map.put(str, map.get(str) - 1);
                } else break;
            }
            if (map.size() == set.size() && len > q.size()) {
                len = q.size();
                l = s;
            }
        }
        answer[0]=l+1;
        answer[1]=l+len;
        map.clear();
        return answer;
    }
}
