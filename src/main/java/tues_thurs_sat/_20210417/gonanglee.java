package tues_thurs_sat._20210417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class gonanglee {
    static HashMap<Character, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split("");
        int l = 0, r = 0;
        int len = str.length;
        int ans = 0;
        while (r < len) {
            char ch = str[r].charAt(0);
//            System.out.println(ch);
            if (map.size() < n || map.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                int sum = 0;
                for (Integer value : map.values()) {
                    sum += value;
                }
                r++;
                ans = Math.max(sum, ans);
            } else {
                while (map.size() != n - 1) {
                    int gap = map.get(str[l].charAt(0));
                    if (gap != 1) {
                        map.put(str[l].charAt(0), gap - 1);
                    } else {
                        map.remove(str[l].charAt(0));
                    }
                    l++;
                }
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                int sum = 0;
                for (Integer value : map.values()) {
                    sum += value;
                }
                r++;
                ans = Math.max(sum, ans);
            }
        }
        System.out.println(ans);


    }
}
