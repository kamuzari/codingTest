package programmers.mockquestions.bundle42;

public class Palindrom {
	public int solution(int n, int m) {
		int answer = 0;

		for(int val=n; val<=m; val++){
			boolean isPalindrom=true;
			String str=String.valueOf(val);
			int left=0;
			int right=str.length()-1;

			while(left<=right){
				if(str.charAt(left) != str.charAt(right)){
					isPalindrom=false;
					break;
				}

				left++;
				right--;
			}

			if(isPalindrom){
				answer++;
			}
		}
		return answer;
	}
}
