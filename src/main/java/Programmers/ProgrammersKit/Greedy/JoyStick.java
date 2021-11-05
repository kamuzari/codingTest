package Programmers.ProgrammersKit.Greedy;

public class JoyStick {
    public static void main(String[] args) {
//        System.out.println(solution("JAZ"));
        solution("JAAEN");
    }
//     연속된 A의 등장에 따라 최소 움직임이 달라진다는 것이다!
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
            System.out.println(i+len-next+i);
            min=Math.min(min,i+len-next+i);
        }
        answer+=min;
        return answer;

    }
}
