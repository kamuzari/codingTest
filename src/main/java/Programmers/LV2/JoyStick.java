package Programmers.LV2;

public class JoyStick {
    public static int solution(String name) {
        int answer = 0;
        int len=name.length();
        int min=len-1;
        for (int i = 0; i < len; i++) {
            answer+=Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            int next=i+1;
            while (next<len && name.charAt(next)=='A')
            {
                next++;
            }
            //
            min=Math.min(min,i+len-next+i); // 기존 i번 움직인 값과 맨  i만큼 첫자리로 돌아와 len-next;
        }
        answer+=min;
        return answer;

    }
}
