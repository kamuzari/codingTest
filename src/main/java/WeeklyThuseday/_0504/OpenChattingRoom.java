package WeeklyThuseday._0504;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class OpenChattingRoom {
    public static void main(String[] args) {
        String s[]={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(s)));
    }
    public static String[] solution(String[] record) {
        HashMap<String,String> map=new LinkedHashMap<>();
        int cnt=0;
        for (int i = record.length-1; i >=0; i--) {
            String str[]=record[i].split(" ");
            String id=str[1];
            String cmd=str[0];
            if(cmd.equals("Leave"))
                continue;
            String name=str[2];
            if(!map.containsKey(id))
            {
                map.put(id,name);
            }
            if(cmd.equals("Change"))
                cnt++;

        }
        String[] answer = new String[record.length-cnt];
        int idx=0;
        for (int i = 0; i < record.length; i++) {
            String str[]=record[i].split(" ");
            String cmd=str[0];
            String id=str[1];
            switch (cmd)
            {
                case "Enter":
                    answer[idx++]=map.get(id)+"님이 들어왔습니다.";
                    break;
                case "Leave":
                    answer[idx++]=map.get(id)+"님이 나갔습니다.";
                    break;
                case "Change":
                    break;
            }
        }

        return answer;
    }
}
