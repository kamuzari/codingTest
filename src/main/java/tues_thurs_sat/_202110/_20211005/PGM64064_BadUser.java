package tues_thurs_sat._202110._20211005;

import java.util.*;
public class PGM64064_BadUser {
    String user[];
    String ban[];
    int target;
    Set<Set<String>> results=new LinkedHashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        user=user_id;
        ban=banned_id;
        target=ban.length;
        pick(0,new LinkedHashSet<>());
        return results.size();
    }
    private void pick(int cnt,LinkedHashSet<String>set){
        if(set.size()==target)
        {
            if(isBanUser(set)){
                results.add(new LinkedHashSet<>(set));
            }
            return;
        }
        for(int i=0; i<user.length; i++){
            if(!set.contains(user[i])){
                set.add(user[i]);
                pick(cnt+1,set);
                set.remove(user[i]);
            }
        }
    }

    private boolean isBanUser(LinkedHashSet<String> result){
        int idx=0;
        for(String user : result){
            if(!isSimilar(user,ban[idx++])){
                return false;
            }
        }
        return true;
    }

    private boolean isSimilar(String user1,String ban1){
        if(user1.length() != ban1.length()){
            return false;
        }
        for(int i=0; i<user1.length(); i++){
            if(ban1.charAt(i)=='*'){
                continue;
            }
            if(ban1.charAt(i)!=user1.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
