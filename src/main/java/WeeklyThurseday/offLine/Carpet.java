package WeeklyThurseday.offLine;

public class Carpet {
    public static void main(String[] args) {

    }
    public  int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width=0;
        int height=0;
        int yellowCnt=0;
        for (height = 3; height <(brown+4)/2 ; height++) {
            width=(brown+4)/2-height;
            if(width<height)
                break;
            yellowCnt=(width-2)*(height-2);
            if(yellowCnt==yellow)
                break;
        }
        answer[0]=width;
        answer[1]=height;
        return answer;
    }
}

