package tues_thurs_sat._202109._20210930;
/*
괄호의 성질 : 닫는 괄호가 먼저 올 순 없다. L이 있어야 R이 채워질 수 있다.
*/
public class PGM12929_CorrectBracketNumber {
    int N;
    int answer = 0;
    public int solution(int n) {
        N=n;
        dfs(0,0);
        return answer;
    }
    private void dfs(int l,int r){
        // System.out.println(l+" "+r);
        if(l> N || r >N){
            return;
        }
        if(l<r) return;
        if(l==N && r==N){
            answer++;
            return;
        }
        dfs(l+1,r);
        dfs(l,r+1);
    }
}
