package programmers.mockquestions.bundle42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TravelPath {
	boolean checkOut[];
	List<String> results=new ArrayList<>();

	public String[] solution(String[][] tickets) {
		String[] answer = {};
		checkOut=new boolean[tickets.length];
		travel(0,"ICN","ICN",tickets);
		Collections.sort(results);
		return results.get(0).split(" ");
	}

	public void travel(int cnt,String start, String candidates, String[][] tickets){
		if(cnt==tickets.length){
			results.add(candidates);
			return;
		}

		for(int i=0; i<tickets.length; i++){
			if(checkOut[i] || !tickets[i][0].equals(start)){
				continue;
			}

			checkOut[i]=true;
			travel(cnt+1, tickets[i][1], candidates + " "+ tickets[i][1],tickets);
			checkOut[i]=false;
		}
	}
}
