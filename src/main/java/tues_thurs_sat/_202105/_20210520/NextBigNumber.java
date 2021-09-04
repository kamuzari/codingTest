package tues_thurs_sat._202105._20210520;

public class NextBigNumber {
    public static void main(String[] args) {

    }
    public int solution(int n) {
        int answer = 0;
        int orginalBitCOunt=Integer.bitCount(n);
        for (int i = n+1;; i++) {
            int nextBitCount=Integer.bitCount(i);
            if(orginalBitCOunt==nextBitCount)
            {
                answer=i;
                break;
            }
        }
        return answer;
    }
}
