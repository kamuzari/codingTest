package tues_thurs_sat._20210826;

import java.util.*;

public class Compression {
    public static void main(String[] args) {
        Compression compression = new Compression();
        int[] kakaos = compression.solution("KAKAO");
        System.out.println(Arrays.toString(kakaos));
    }

    public int[] solution(String msg) {
        List<Integer> results=new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int idx = 0;
        for (; idx < 26; idx++) {
            String key =Character.toString((char) (65+idx));
            map.put(key, idx + 1);
        }
        idx++;

        char message[] = msg.toCharArray();
        boolean flag = false;
        for (int i = 0; i < message.length; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(message[i]);

            while (map.containsKey(sb.toString())) {
                ++i;
                if (i == message.length) {
                    flag = true;
                    break;
                }
                sb.append(message[i]);
            }
            if (flag) {
                results.add(map.get(sb.toString()));
                break;
            }
            results.add(map.get(sb.substring(0,sb.toString().length()-1)));
            map.put(sb.toString(),idx++);
            i--;
        }

        int answer[] = new int[results.size()];
        idx=0;
        for (Integer result : results) {
            answer[idx++]=result;
        }
        return answer;
    }
}
