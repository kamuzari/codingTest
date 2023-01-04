package programmers.lv2;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberCardDivision {
	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		List<Integer> aFactors = getFactors(arrayA);
		aFactors.addAll(getFactors(arrayB));
		Set<Integer> factors= aFactors.stream()
			.collect(Collectors.toSet());

		int n=arrayA.length;

		for(int factor: factors){
			if(isEnable(factor, arrayA, arrayB)){
				answer=Math.max(answer,factor);
			}

			if(isEnable(factor,arrayB, arrayA)){
				answer=Math.max(answer,factor);
			}
		}

		return answer;
	}

	public List<Integer> getFactors(int[] arr){
		int minValue = Arrays.stream(arr).min().orElseGet(()->0);

		return IntStream.rangeClosed(2,minValue)
			.filter(factor-> minValue % factor==0)
			.mapToObj(val->val)
			.sorted((a,b)->b-a)
			.collect(Collectors.toList());
	}

	public boolean isEnable(int factor, int[] arr1,int[] arr2){
		for(int i=0; i<arr1.length; i++){
			if(arr1[i] % factor != 0 || arr2[i] % factor ==0){
				return false;
			}
		}

		return true;
	}
}
