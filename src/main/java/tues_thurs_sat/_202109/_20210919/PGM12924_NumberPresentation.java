package tues_thurs_sat._202109._20210919;

public class PGM12924_NumberPresentation {
    public static void main(String[] args) {
        PGM12924_NumberPresentation sol = new PGM12924_NumberPresentation();
        sol.solution(15);
    }
    public int solution(int n) {
        int answer = 0;
        int s=0;
        int e=0;
        int sum=0;
        int arr[]=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        while(true){
            if(e>n){
                break;
            }
            if(sum<n){
                sum+=arr[e++];
            }else if(sum==n){
                sum+=arr[e++];
                answer++;
            }else {
                sum-=arr[s++];
            }

        }
        return answer;
    }
}
