package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HotelBorrowing {
	/**
	 * 빠른 퇴실 기준으로 정렬하면 FAIL
	 * - 왜 안돼지?
	 * 빠른 입실 기준으로 정렬하면 SUCCESS
	 * -
	 */
	class Time implements Comparable<Time>{
		int ih,im;
		int oh,om;

		public Time(String in,String out){
			String str[]=in.split(":");
			ih=Integer.parseInt(str[0]);
			im=Integer.parseInt(str[1]);
			str=out.split(":");
			oh=Integer.parseInt(str[0]);
			om=Integer.parseInt(str[1]);
		}

		public boolean isRelay(Time next){
			return this.getOutTotal()+10 <= next.getInTotal();
		}

		public int getInTotal(){
			return ih*60 + im;
		}

		public int getOutTotal(){
			return oh*60 + om;
		}

		public int compareTo(Time o){
			if(this.getInTotal() == o.getInTotal()){
				return this.getOutTotal() - o.getOutTotal();
			}

			return this.getInTotal() - o.getInTotal();
		}
	}
	public int solution(String[][] book_time) {
		int answer = 0;
		String[][] bt=book_time;
		int n=book_time.length;
		List<Time> times=new ArrayList<>();
		for(int i=0; i<n; i++){
			String in=bt[i][0];
			String out=bt[i][1];
			times.add(new Time(in,out));
		}

		Collections.sort(times);

		boolean[] possibles=new boolean[n];
		Arrays.fill(possibles,true);

		for(int i=0; i<n; i++){
			if(!possibles[i]) continue;
			Time cur=times.get(i);

			for(int j=i+1; j<n; j++){
				if(!possibles[j]) continue;
				Time next=times.get(j);
				if(cur.isRelay(next)){
					possibles[j]=false;
					cur=next;
				}

			}
			possibles[i]=false;
			answer++;
		}

		return answer;
	}
}
