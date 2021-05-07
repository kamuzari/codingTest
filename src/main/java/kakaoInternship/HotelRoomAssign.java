package kakaoInternship;

import java.util.*;

public class HotelRoomAssign {
    public static void main(String[] args) {

    }
    static Map<Long,Long> map=new LinkedHashMap<>();
    public long[] solution(long k, long[] room_number) {
        long answer[]=new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i]=find(room_number[i]);
        }
        return answer;
    }

    private long find(long l) {
        if(!map.containsKey(l)) {
            map.put(l,l+1);
            return l;
        }
        long next = map.get(l);
        long empty=find(next);
        map.put(l,empty);
        return empty;
    }
}
