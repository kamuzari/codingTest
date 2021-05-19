package WeeklyThuseday.RT._0512;

import java.util.LinkedHashMap;
import java.util.Map;

public class GroupPhoto {
    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
    }

    static char ch[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int answer;
    static String[] DATA;
    static int N = 0;
    static Map<Character, Integer> map = new LinkedHashMap<>();

    public static int solution(int n, String[] data) {
        answer=0;
        N = n;
        DATA = data;
        pick(0);
        return answer;
    }

    public static void pick(int cnt) {
        if (cnt == 8) {
            System.out.println(map);
            if (checking()) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!map.containsKey(ch[i])) {
                map.put(ch[i], cnt);
                pick(cnt + 1);
                map.remove(ch[i]);
            }
        }

    }

    private static boolean checking() {

        for (int i = 0; i < N; i++) {
            char arr[] = DATA[i].toCharArray();
            char target = arr[0];
            char who = arr[2];
            char cmd = arr[3];
            int dist = (arr[4] - '0') + 1;

            int targetIdx = map.get(target);
            int whoIdx = map.get(who);

            if ('=' == cmd) {
                if (Math.abs(targetIdx - whoIdx) != dist)
                    return false;
            }
            if ('>' == cmd) {
                if (Math.abs(targetIdx - whoIdx) <= dist)
                    return false;
            }
            if ('<' == cmd) {
                if (Math.abs(targetIdx - whoIdx) >= dist)
                    return false;
            }
        }
        return true;
    }
}
