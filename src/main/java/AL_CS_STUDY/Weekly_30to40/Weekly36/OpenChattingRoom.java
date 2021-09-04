package AL_CS_STUDY.Weekly_30to40.Weekly36;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class OpenChattingRoom {
    public static void main(String[] args) {
        OpenChattingRoom openChattingRoom = new OpenChattingRoom();
        String[] solution = openChattingRoom.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        System.out.println(Arrays.toString(solution));

    }

    public String[] solution(String[] record) {
        Map<String, String> map = new LinkedHashMap<>();
        int changeCnt = 0;
        StringTokenizer st;
        for (String s : record) {
            st = new StringTokenizer(s, " ");
            String cmd = st.nextToken();
            if (cmd.equals("Leave")) {
                continue;
            }
            if (cmd.equals("Change")) {
                changeCnt++;
            }
            String key = st.nextToken();
            String value = st.nextToken();
            map.put(key, value);
        }

        String answers[] = new String[record.length - changeCnt];
        int idx = 0;
        StringBuffer sb;
        for (String s : record) {
            st = new StringTokenizer(s, " ");
            String cmd = st.nextToken();
            String answer = "";
            sb=new StringBuffer();
            switch (cmd) {
                case "Enter":
                    answer = sb.append(map.get(st.nextToken())).append("님이 들어왔습니다.").toString().trim();
                    answers[idx++] = answer;
                    break;
                case "Leave":
                    answer = sb.append(map.get(st.nextToken())).append("님이 나갔습니다.").toString().trim();
                    answers[idx++] = answer;
                    break;
            }
        }
        return answers;
    }
}
