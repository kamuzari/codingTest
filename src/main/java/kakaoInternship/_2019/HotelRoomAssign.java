package kakaoInternship._2019;

import java.util.*;

public class HotelRoomAssign {
    public static void main(String[] args) {

    }
    static Map<Long,Long> map=new LinkedHashMap<>();
    public long[] solution(long k, long[] room_number) {
        long answer[]=new long[room_number.length];
        parent=new long[(int)k+1];
        for (int i = 0; i < room_number.length; i++) {
            answer[i]=Find(room_number[i]);
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
    static long parent[];
    // 압축기법은 k가 10^12 21억개를 10^8 *21 ==21억 ..까지 가능하다. 하지만 10^12=천억...
    private long Find(long val)
    {
        if(parent[(int)val]==0)
        {
            parent[(int)val]=val+1;
            return val;
        }
        return parent[(int)val]=Find(parent[(int)val]);
    }
}
