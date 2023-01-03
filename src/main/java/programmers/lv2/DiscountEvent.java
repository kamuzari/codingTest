package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {

		/**
		 * 할인하는 제품은 하루에 하나씩만 구매 할 수 있다.
		 * 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우를 맞춰서 회원가입

		 ret 회원 등록 날짜(할인을 모두 받을 수 있는 날짜, 없으면 0)
		 */

		final int MEMBER_DURATION=10;
		public int solution(String[] want, int[] number, String[] discount) {
			int registration = 0;

			Map<String,Integer> wants=new HashMap<>();

			for(int i=0; i<want.length; i++){
				String name=want[i];
				int quantity=number[i];
				wants.put(name,quantity);
			}

			int n=discount.length;

			for(int i=0; i <n-9; i++){
				Map<String,Integer> purchases =new HashMap<>();

				for(int day=i; day<i+10; day++){
					String name=discount[day];
					purchases.put(name,purchases.getOrDefault(name,0)+1);
				}

				if(isEnable(wants,purchases)){
					registration++;
				}
			}


			return registration;
		}

		public boolean isEnable(Map<String,Integer> wants, Map<String,Integer> purchases){
			for(String key : wants.keySet()){
				if(!purchases.containsKey(key)){
					return false;
				}

				if(wants.get(key) != purchases.get(key)){
					return false;
				}
			}

			return true;
		}
}
