package tues_thurs_sat._20210828;

import java.util.*;

// 보석 쇼핑 https://programmers.co.kr/learn/courses/30/lessons/67258
public class JewelShopping {
    public static void main(String[] args) {
        String gems[] = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String gems2[] = {"AA", "AB", "AC", "AA", "AC"};
        JewelShopping jewelShopping = new JewelShopping();
        int[] answer = jewelShopping.solution(gems);
        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(String gems[]) {
        LinkedList<String> q = new LinkedList<>();
        Map<String, Integer> bucket = new LinkedHashMap<>();
        Set<String> set = new LinkedHashSet<>(Arrays.asList(gems));

        int n = gems.length;
        int s = 0;
        int e = 0;
        int startSection=0;
        int sectionSize=n;
        while (true) {
            if (e > n - 1)
                break;
            bucket.put(gems[e],bucket.getOrDefault(gems[e],0)+1);
            q.offer(gems[e++]);

            while (bucket.get(q.peek()) > 1) {
                s++;
                String peek = q.peek();
                bucket.put(peek,bucket.get(peek)-1);
                q.poll();
            }

            if(bucket.size()== set.size() && sectionSize>q.size())
            {
                sectionSize=q.size();
                startSection=s;
            }
        }
        bucket.clear();
        q.clear();
        set.clear();
        return new int[]{startSection+1,startSection+sectionSize};
    }
}
