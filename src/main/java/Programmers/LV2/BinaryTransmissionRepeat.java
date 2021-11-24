package Programmers.LV2;

public class BinaryTransmissionRepeat {
    static final String TARGET="1";
    public int[] solution(String s) {
        int[] answer = new int[2];
        int turn=0;
        int removeZero=0;
        while(!s.equals(TARGET)){
            StringBuilder result=new StringBuilder();
            int cntOne=0;
            for(int i=0; i<s.length(); i++){
                char ch=s.charAt(i);
                if(ch=='0'){
                    removeZero++;
                    continue;
                }else{
                    cntOne++;
                }
            }
            s=Integer.toBinaryString(cntOne);
            turn++;
        }
        answer[0]=turn;
        answer[1]=removeZero;
        return answer;
    }
}
