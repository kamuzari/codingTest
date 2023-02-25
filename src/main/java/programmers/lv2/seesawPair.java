package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class seesawPair {
	public long solution(int[] weights) {
		long answer = 0;
		Map<Integer, Integer> maps=new TreeMap<>(); // 사람 무게, 명수
		Arrays.stream(weights)
			.forEach(key->maps.put(key,maps.getOrDefault(key,0)+1));

		Map<Integer, List<Integer>> sources=new HashMap<>();

		for(Integer source : maps.keySet()){
			// 중복 계산
			if(maps.get(source)>=2){
				int n=maps.get(source);
				n--;
				answer+=((long)n * (n+1) / 2); // 10만 10만 =: 백억> int type overFlow
			}
			for(int i=2; i<=4; i++){
				int nKey=source*i;

				if(sources.containsKey(nKey)){
					sources.get(nKey).add(source);
				}else{
					List<Integer> sourceList=new ArrayList<>();
					sourceList.add(source);
					sources.put(nKey,sourceList);
				}
			}
		}
		// 원천지가 같으면 시소 짝궁을 이룰 수 있는 것을 말함.
		for(Integer val: sources.keySet()){
			List<Integer> list=sources.get(val);
			if(list.size()==1) continue; // 만들 수 있는 원천지가 2개 이상이여야 짝을 이룰 수 있음.

			for(int i=0; i<list.size(); i++){
				int left=list.get(i);
				for(int j=i+1; j<list.size(); j++){
					int right=list.get(j);

					answer+=((long)maps.get(left)*maps.get(right)); // int type overFlow 5만 * 5 25억이므로
				}
			}
		}

		return answer;
	}
}
