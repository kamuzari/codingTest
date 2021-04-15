package tues_thurs_sat._20210415;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public static void main(String[] args) {
    String str[]={"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(solution(3,str));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list  = new ArrayList<>();
        for (String city : cities) {
            city=city.toUpperCase();
                if(list.contains(city))
                {
                    list.remove(city);
                    list.add(city);
                    answer+=1;
                }
                else
                {
                 if(cacheSize!=0 &&list.size()==cacheSize)
                 {
                     list.remove(0);
                 }
                 if(cacheSize!=0)
                    list.add(city);
                 answer+=5;
                }
        }
        return answer;
    }
}
