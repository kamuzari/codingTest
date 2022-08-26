package programmers.lv2;
import java.util.*;

public class EscapeBoat {
    // Collections.sort(dq) : = 테스트 케이스 4 TLE
    // ArrayDequeue : = PASS
        /*
        Arrays.sort() : = dual pivot Quicksort
        Collections.sort := merge + insert == Timsort
        Quick sort는 배열에서 좋은 성능을 보이지만 Stable 하지 않다.
        만약 stable 이 필요한 Object에는 Collections.sort()가 주로 사용된다.
        */

    // 작은 값 +큰 값 <= limit 이 안되면 작은값 + 작읍값 : = (X)
    // 50 80 > 100 -->
    // 1 2 3 4 5 6  limit:6 -> 큰값 부터 하면 := 4 -> (5,1) -> (4,2) -> (3)5 ,
    //  작은 값 부터 제거하면 : 5번 (1,2) -> 3 -> 4 -> 5 -> 6
    public int solution(int[] people, int limit) {
        int answer = 0;
        LinkedList<Integer> dq=new LinkedList<>();
        // Arrays.sort(people);
        for(int val : people){
            dq.offer(val);
        }
        Collections.sort(dq,(o1,o2)->o1-o2);
        while(!dq.isEmpty()){
            int maxVal=dq.pollLast();// 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다
            if(!dq.isEmpty() && maxVal+dq.peekFirst()<=limit){
                dq.pollFirst();
            }
            answer++;
        }
        return answer;
    }
}
