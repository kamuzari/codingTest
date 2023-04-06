package programmers.lv2;

import java.util.LinkedList;

public class TwoQueueSummaryEqual {

	public int solution(int[] queue1, int[] queue2) {
		int repeat = 0;
		LinkedList<Long> a=move(queue1);
		LinkedList<Long> b=move(queue2);

		long aSum=getSum(a);
		long bSum=getSum(b);
		// 왜 q1,q2길이가 안돼지?
		int limitCount=(a.size()+b.size()) * 2;

		while(aSum!=bSum){
			// 언제까지 반복해야하지?
			if(aSum>bSum){
				long val=a.poll();
				aSum-=val;
				bSum+=val;
				b.add(val);
				repeat++;
			}else if(aSum<bSum){
				long val=b.poll();
				bSum-=val;
				aSum+=val;
				a.add(val);
				repeat++;
			}

			if(limitCount < repeat){
				return -1;
			}
		}

		return repeat;
	}

	LinkedList<Long> move(int[] arr){
		LinkedList<Long> list=new LinkedList<>();

		for(int val: arr){
			list.add((long)val);
		}

		return list;
	}

	long getSum(LinkedList<Long> list){
		return list.stream()
			.reduce(0L,Long::sum);
	}

}
