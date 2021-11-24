package Programmers.LV2;

import java.util.*;

public class NSquareSplit {
    // 구현 := n^2 .. 변환 X
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        List<Long> results=new ArrayList<>();
        for(long i=left; i<=right; i++){
            results.add(Math.max(i/n,i%n)+1);
        }
        return results.stream().mapToInt(value->value.intValue()).toArray();
    }
}
