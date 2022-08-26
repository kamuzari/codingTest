package programmers.lv2;

public class ExpectDraw {
    // 작은 수 왼쪽에 배치되면서 홀수번쨰를 갖는 성질 고려 , A_B 매칭시 무조건 1차이
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int l=a>b ? b:a;
        int r=a<b ? b:a;
        while(true){
            if(l%2==1 &&r-l==1) break;
            l=(l+1)/2;
            r=(r+1)/2;
            answer++;
        }
        return answer;
    }
}
