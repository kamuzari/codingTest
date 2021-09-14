package tues_thurs_sat._202108._20210807;

public class binaryLoop {
    public static void main(String[] args) {

    }
    public int[] solution(String s)
    {
        int answer[] = {};
        int cntZero=0;
        int turnCnt=0;
        while (!s.equals("1"))
        {
            int cntOne=0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='1')
                    cntOne++;
                else
                    cntZero++;
            }
            s=Integer.toBinaryString(cntOne);
            turnCnt++;
        }
        return new int[]{turnCnt,cntZero};
    }
}
