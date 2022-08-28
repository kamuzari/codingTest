package programmers.mockquestions.bundle22;

import java.util.ArrayList;
import java.util.Collections;

public class VowelDictionary {
	/**
	 * note : 5 게 뻡는데 있어 시간초과 안남
	 *  - 정렬하는데도 시간 초과 안남
	 */
	int size;
	String w;
	ArrayList<String> dictionary=new ArrayList<>();
	String[] org=new String[]{"A","E","I","O","U"};
	public int solution(String word) {
		int answer = 0;

		size=word.length();
		w=word;

		combination(0,"");

		Collections.sort(dictionary);

		return dictionary.indexOf(word);
	}

	void combination(int cnt, String result){
		if(cnt>5){
			return;
		}

		dictionary.add(result);

		for(int i=0; i<org.length; i++){
			combination(cnt+1,result+org[i]);
		}
	}
}
