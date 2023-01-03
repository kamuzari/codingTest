package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartialSequenceSummary {

	public int solution(int[] elements) {
		int n=elements.length;
		int[] numbers=new int[n*2];

		for(int i=0; i<n; i++){
			numbers[i]=numbers[i+n]=elements[i];
		}

		Set<Integer> summaries=new HashSet<>();

		for(int interval=1; interval<=n; interval++){
			for(int start=0; start<n; start++){
				summaries.add(Arrays.stream(numbers,start,start+interval).sum());
			}
		}

		return summaries.size();
	}
}
