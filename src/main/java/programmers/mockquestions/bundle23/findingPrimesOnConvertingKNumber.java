package programmers.mockquestions.bundle23;

import java.util.HashSet;
import java.util.Set;

public class findingPrimesOnConvertingKNumber {
	public int solution(int n, int k) {
		int answer = 0;
		String convertedNumber=convertKnary(n,k);
		String[] results=convertedNumber.split("0");
		for(String num: results){
			if(num.isBlank()) continue;
			if(isPrime(Long.parseLong(num))){
				answer++;
			}
		}
		return answer;
	}

	public String convertKnary(int n,int k){
		StringBuilder answer=new StringBuilder();

		while(n>=k){
			answer.append(n%k);
			n/=k;
		}

		answer.append(n);

		return answer.reverse().toString();
	}

	public boolean isPrime(long n){

		if(n<2) return false;

		int square=(int)Math.sqrt(n);

		for(int i=2; i<=square; i++){
			if(n%i==0){
				return false;
			}
		}

		return true;
	}


	// error [runtime] 및 시간초과 -> 백만을 이진수로 바꾸면 엄청나게 숫자가 커짐.. 에라토스는 너무 큰수에 대응 힘듬...
	public Set<Integer> getPromisingPrimes(int n){
		boolean[] primes=new boolean[n+1];

		primes[0]=primes[1]=true;

		for(int i=2; i*i<=n; i++){
			if(!primes[i]){
				for(int j= i*i; j<=n; j+=i){
					primes[j]=true;
				}
			}
		}

		Set<Integer> results=new HashSet<>();

		for(int i=2; i<=n; i++){
			if(!primes[i]){
				results.add(i);
			}
		}

		return results;
	}

}