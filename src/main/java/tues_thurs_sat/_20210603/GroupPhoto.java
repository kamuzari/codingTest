package tues_thurs_sat._20210603;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class GroupPhoto {
    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
    }

    static char group[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static HashMap<Character, Integer> map = new LinkedHashMap<>();
    static int N;
    static String Data[];
    static int answer ;
    public static int solution(int n, String[] data) {
        answer = 0;
        N = n;
        Data = data;
        pick(0);
        return answer;
    }

    static void pick(int cnt) {
        if (cnt == 8) {

            if(check())
            {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!map.containsKey(group[i])) {
                map.put(group[i], cnt);
                pick(cnt + 1);
                map.remove(group[i]);
            }
        }
    }

    static boolean check() {
        for (String required : Data) {
            char a, b, cmd;
            int dist = 0;
            a = required.charAt(0);
            b = required.charAt(2);
            cmd = required.charAt(3);
            dist = required.charAt(4)-'0';
            switch (cmd) {
                case '>':
                    if(Math.abs(map.get(a)-map.get(b))-1<=dist)
                        return false;
                    break;
                case '<':
                    if(Math.abs(map.get(a)-map.get(b))-1>=dist)
                        return false;
                    break;
                case '=':
                    if(Math.abs(map.get(a)-map.get(b))-1!=dist)
                        return false;
                    break;
            }
        }
        return true;
    }

}
