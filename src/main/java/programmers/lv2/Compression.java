package programmers.lv2;

import java.util.*;

public class Compression {

    /*
     * 1. sliding window 라고 생각함 (x)
     * : = 사전에 있으면 결과 출력 후 오른쪽 msg[index++] 문자 추가, 새로운 사전이면 왼쪽인덱스 ++;
     * 2. 이미 한번 출력 결과물에 들어가있으면 출력하지 않고 다음 문자를 넣고 새로운 문자열이면 등록하는 것.(x)
     * : = 하지만 예제 2번 출력 결과는 동일 결과를 출력하는 원소 또한 있었음.
     * 3. 단순 구현 (o)
     * : = 이미 사전에 등록되어 있는 경우
     *      오른쪽 인덱스의 문자열을 계속 추가하며 이전 결과를 출력하고 새로운 문자열을 사전에 등록
     */
    public int[] solution(String msg) {
        Map<String, Integer> map = createBasicDictionary();
        List<Integer> results = new ArrayList<>();
        int n = msg.length();
        int value = 27;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char msgChar = msg.charAt(i);
            sb.append(msgChar);
            while (map.containsKey(sb.toString())) {
                if (i + 1 == n) {
                    flag = true;
                    break;
                }
                sb.append(msg.charAt(++i));
            }
            if (flag) {
                results.add(map.get(sb.toString()));
                break;
            }
            String newWord = sb.toString();
            results.add(map.get(newWord.substring(0, newWord.length() - 1)));
            map.put(newWord, value++);
            --i;
        }
        int size = results.size();
        int answer[] = new int[size];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    public Map<String, Integer> createBasicDictionary() {
        Map<String, Integer> retMap = new HashMap<>();
        for (int i = 65; i < 65 + 26; i++) {
            char ch = (char) i;
            retMap.put(ch + "", i - 64);
        }
        return retMap;
    }
}
