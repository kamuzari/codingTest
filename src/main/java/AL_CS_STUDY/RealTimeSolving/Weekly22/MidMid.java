package AL_CS_STUDY.RealTimeSolving.Weekly22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class MidMid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; i++) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            String s = br.readLine();
            sb.append("#").append(i);
            for (int j = 0; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            }
            boolean flag = true;
            if (map.keySet().size() != 2) {
                sb.append(" No\n");
                continue;
            }
            for (Character ch : map.keySet()) {
                if (map.get(ch) != 2) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                sb.append(" Yes\n");
            else
                sb.append(" No\n");
        }
        System.out.println(sb);
    }
}
