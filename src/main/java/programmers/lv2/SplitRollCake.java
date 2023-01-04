package programmers.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SplitRollCake {
	/**
	 * note:
	 * 	- 오른쪽으로 compact 시킨다.
	 * 	- compact 시킨 큐에서 숫자를 하나씩 꺼내면서 왼쪽 Set으로 넘겨준다.
	 * 	- 오른쪽은 Set이 아닌 Map을 사용하므로써 해당 개수를 체크한다.
	 * @param topping
	 * @return
	 */
	public int solution(int[] topping) {
		int answer = 0;

		Set<Integer> aSet=new HashSet<>();
		Map<Integer,Integer> elementMap=new HashMap<>();

		LinkedList<Integer> bq=new LinkedList<>();

		Arrays.stream(topping).forEach(val -> {
			elementMap.put(val,elementMap.getOrDefault(val,0)+1);
			bq.offer(val);
		});

		int n=topping.length;

		while(!elementMap.keySet().isEmpty()){
			if(elementMap.keySet().size()==aSet.size()){
				answer++;
			}

			int value=bq.poll();

			if(elementMap.get(value)==1){
				elementMap.remove(value);
			}else{
				elementMap.put(value,elementMap.get(value)-1);
			}

			aSet.add(value);
		}

		return answer;
	}
}
