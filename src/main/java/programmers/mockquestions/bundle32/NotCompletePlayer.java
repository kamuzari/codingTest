package programmers.mockquestions.bundle32;

import java.util.HashMap;
import java.util.Map;

public class NotCompletePlayer {
	public String solution(String[] participant, String[] completion) {
		Map<String,Integer> names=new HashMap<>();

		for(String people : participant){
			names.put(people,names.getOrDefault(people,0)+1);
		}

		for(String compl : completion){
			if(names.containsKey(compl)){
				int cnt=names.get(compl);

				if(cnt-1==0){
					names.remove(compl);
				}else{
					names.put(compl,cnt-1);
				}

			}
		}

		for(String name : names.keySet()){
			return name;
		}

		return null;
	}
}
