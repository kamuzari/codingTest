package programmers.lv2;
public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        for(int i=1000; i>=0 ; i--){
            int cnt=0;
            for(int val :citations){
                if(val>=i){
                    cnt++;
                }
            }
            if(cnt>=i){
                return i;
            }
        }
        return answer;
    }
}
