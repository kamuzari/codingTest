package programmers.lv1;

public class reversing3Notation {

	public int solution(int n) {
		String result=translateTo3Noation(n);

		return tralateTo10Notation(3,result);
	}

	private String translateTo3Noation(int val){
		StringBuilder answer=new StringBuilder();

		while(val>=3){
			int rest=val%3;

			answer.append(rest);

			val/=3;
		}

		answer.append(val);

		return answer.toString();
	}

	private int tralateTo10Notation(int notation,String val){

		int answer=0;
		int n=val.length();


		for(int i=0; i<n; i++){
			int value = val.charAt(i)-'0';

			if(value==0) continue;

			answer+=value * (int) Math.pow(3,(n-1)-i);
		}

		return answer;
	}
}
