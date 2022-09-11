package programmers.mockquestions.bundle41;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MenuRenewal {
	/**
	 note : 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 리턴하라.
		 + 오름차순으로 구성하라.

	 resolve:
	   - 1. 손님이 주문한 음식들을 기반으로 course 개수를 조합으로 구성한다.
	   - 2. 1번에서 나온 결과 값들 중 가장 많이 주문한 코스요리를 결과값에 담는다.
	 *
	 */
	List<Set<Character>> orderList =new ArrayList<>(); // orders
	List<Character> foodCandidates;
	Set<Character> picks=new TreeSet<>();
	Map<String,Integer> orderCandidates;
	int target;
	int maxOrderCnt=0;

	public String[] solution(String[] orders, int[] course) {
		Set<Character> foods=new HashSet<>();

		for(String order: orders){
			Set<Character> guestsOrder= new HashSet<>();
			for(int i=0; i<order.length(); i++){
				char ch = order.charAt(i);
				guestsOrder.add(ch);
				foods.add(ch);
			}
			orderList.add(guestsOrder);
		}

		foodCandidates=foods.stream().collect(Collectors.toList());
		List<String> retCourses=new ArrayList<>();

		for(int i=0; i<course.length; i++){
			target=course[i];
			orderCandidates=new HashMap<>();
			comb(0,0);

			for(String candidate : orderCandidates.keySet()){
				if(orderCandidates.get(candidate)==maxOrderCnt){
					retCourses.add(candidate);
				}
			}
			maxOrderCnt=0;
		}

		Collections.sort(retCourses);

		return retCourses.stream().toArray(String[]::new);
	}

	public void comb(int cnt,int idx){
		if(cnt==target){
			int orderCnt=0;

			for(Set<Character> order:orderList){
				if(order.containsAll(picks)){
					orderCnt++;
				}
			}

			if(orderCnt>1){
				StringBuilder course=new StringBuilder();

				picks.forEach(food -> course.append(food));

				maxOrderCnt=Math.max(maxOrderCnt,orderCnt);
				String key=course.toString();
				orderCandidates.put(key,orderCnt);
			}
			return;
		}

		for(int i=idx; i<foodCandidates.size(); i++){
			char food=foodCandidates.get(i);

			picks.add(food);
			comb(cnt+1,i+1);
			picks.remove(food);
		}
	}
}
