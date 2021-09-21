package tues_thurs_sat._202109._20210921;

import java.util.*;

public class PGM86048_SevenWeekly {
    public static void main(String[] args) {

    }
    public int[] solution(int[] enter, int[] leave) {
        int n=enter.length;
        int[] answer = new int[n];
        List<Integer>room = new ArrayList();
        int idx=0;
        for(int i=0; i<n;i++){
            room.add(enter[i]);
            for(int j=0; j<room.size(); j++){
                if(enter[i]==room.get(j)){
                    answer[room.get(j)-1] = room.size()-1;
                }else{
                    answer[room.get(j)-1]++;
                }
            }
            while(idx<n && room.contains(leave[idx])){
                room.remove(Integer.valueOf(leave[idx++]));
            }
        }

        return answer;
    }
}
