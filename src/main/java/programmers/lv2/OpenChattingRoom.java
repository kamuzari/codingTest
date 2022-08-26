package programmers.lv2;
import java.util.*;
public class OpenChattingRoom {

    public String[] solution(String[] record) {
        Map<String,String> map=new HashMap<>();
        int changeCmdCnt=0;
        for(int i=0; i<record.length; i++){
            StringTokenizer st=new StringTokenizer(record[i]," ");
            char cmd=st.nextToken().charAt(0); // Enter,Leave,Change
            String key=st.nextToken();
            if(cmd=='E'){
                map.put(key,st.nextToken());
            }else if(cmd=='C')
            {
                changeCmdCnt++;
                map.put(key,st.nextToken());
            }
        }
        String[] answer = new String[record.length-changeCmdCnt];
        int idx=0;
        for(int i=0; i<record.length; i++){
            StringTokenizer st=new StringTokenizer(record[i]," ");
            char cmd=st.nextToken().charAt(0);
            String key=st.nextToken();
            if(cmd=='E'){
                String result=map.get(key)+"님이 들어왔습니다.";
                answer[idx++]=result;
            }else if(cmd=='L')
            {
                String result=map.get(key)+"님이 나갔습니다.";
                answer[idx++]=result;
            }
        }
        return answer;
    }

}
