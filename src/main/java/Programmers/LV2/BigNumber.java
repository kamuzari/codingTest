package Programmers.LV2;

import java.util.*;
import java.util.stream.*;

public class BigNumber {
    // 완전 탐색 불가
    // 숫자로 정렬 StringBuilder -> X
    // 커스텀 정렬 필요..
    public String solution(int[] numbers) {
        List<String> numList = Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.toList());
        numList.sort((o1, o2) -> {
            return (o2 + o1).compareTo((o1 + o2));
        });
        StringBuilder answers = new StringBuilder();
        for (String val : numList) {
            answers.append(val);
        }
        return answers.charAt(0) == '0' ? "0" : answers.toString();
    }
}
