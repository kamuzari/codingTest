package programmers.lv2;

import java.util.*;

public class PrimaryCache {
    // LRU := 가장 오랫동안 참조되지 않는 PAGE DELETE
    // 참초된 count update!
    public int solution(int cacheSize, String[] cities) {
        int answer=0;
        LinkedList<String> cache=new LinkedList<>();
        for(String data :cities){
            data=data.toUpperCase();
            if(cache.contains(data)){ //hit
                cache.remove(data);
                cache.add(data);
                answer++;
            }else { // fault
                if(!cache.isEmpty()&&cache.size()>=cacheSize){  // cacheSize==0 이면 NullPointer Error
                    cache.pollFirst();
                }

                if(cacheSize!=0 && cache.size()<cacheSize){
                    cache.add(data);
                }
                answer+=5;
            }
        }
        return answer;
    }
}
