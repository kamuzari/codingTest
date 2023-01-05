package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PickingTangerines {
	/**
	 서로 다른 종류의 수를 최소화 하고 싶다.
	 그런데 만약 개수가 딱 내려지지 않는다면 어떡하지...?
	 아 그래도 상관없구나 어차피 해당 개수만 채울것으로 예상하니깐!
	 */
	public int solution(int k, int[] tangerine) {

		Map<Integer,Integer> fruits=new TreeMap<>();

		Arrays.stream(tangerine)
			.forEach(key-> fruits.put(key, fruits.getOrDefault(key, 0)+1));

		int answer=0;
		List<Integer> keys= new ArrayList<>(fruits.keySet());

		keys.sort((a,b)-> fruits.get(b)-fruits.get(a));

		for(int id : keys){
			if(k<=0) break;

			answer++;
			k -=fruits.get(id);
		}


		return answer;
	}
}
