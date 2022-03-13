package Programmers.kakao2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class GetReportResults {
    static int limit;
    public int[] solution(String[] id_list, String[] report, int k) {
        limit=k;
        Map<String,Set<String>> reports=new HashMap<>();
        Map<String,Integer> users=new LinkedHashMap<>();
        for(String username : id_list){
            users.put(username,0);
            reports.put(username,new HashSet<String>());
        }
        for(String reportingUser : report){
            String split[]=reportingUser.split(" ");
            String reportUser=split[0];
            String reportedUser=split[1];
            if(reports.containsKey(reportedUser)){
                reports.get(reportedUser).add(reportUser);
            }else{
                throw new RuntimeException("BUG");
            }
        }
        for(String key : reports.keySet()){
            if(reports.get(key).size()>=limit){
                for(String reporting : reports.get(key)){
                    users.put(reporting,users.get(reporting)+1);
                }
            }
        }

        int[] answer = new int[users.size()];
        int idx=0;
        for(String username : users.keySet()){
            answer[idx++]=users.get(username);
        }
        return answer;
    }
}
