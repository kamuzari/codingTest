package WeeklyThurseday.KakaoWinter_Intern;

import java.util.*;

public class HotelRoom_Arranging {
    static HashMap<Long,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        int k=10;
        long r[]={1,3,4,1,3,1};
//        long ans[]=solution(k,r);
        long ans[]=efficient_solution(k,r);
        System.out.println(Arrays.toString(ans));
    }
    static HashMap<Long,Long> map2=new HashMap<>();
    // 효율성 0점 o(n) 이라.. 다음번에 선택할 때 스캔을 최소.?
    public static long[] solution(long k, long[] room_number) {
        for (int i = 0; i <room_number.length ; i++) {
            long key=room_number[i];
            if(!map.containsKey(key))
            {
                map.put(key,i+1);
            }
            else
            {

                while (true)
                {
                    key++;
                    if(!map.containsKey(key))
                    {
                        map.put(key,i+1);
                        break;
                    }
                }
            }
        }

        List<Long> keySetList=new ArrayList<>(map.keySet());
//        System.out.println(keySetList);
        Collections.sort(keySetList,(o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
//        System.out.println(keySetList);

        long[] answer = new long[keySetList.size()];
       int i=0;
        for (long key:keySetList) {
            answer[i++]=key;
        }
        return answer;
    }
//<방 번호 : 다음 방 번호>

    public static long[] efficient_solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }

        return answer;
    }

    private static long findEmptyRoom(long room) {
        if (!map2.containsKey(room)) {
            map2.put(room, room + 1);
            return room;
        }

        long nextRoom = map2.get(room);
        long emptyRoom = findEmptyRoom(nextRoom);
        map2.put(room, emptyRoom);
        return emptyRoom;
    }
}
