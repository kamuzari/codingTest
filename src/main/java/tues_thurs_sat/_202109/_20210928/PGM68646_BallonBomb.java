package tues_thurs_sat._202109._20210928;

public class PGM68646_BallonBomb {
    public int solution(int[] a) {
        int answer = 2;
        int n=a.length;
        int rightMin[]=new int[n];
        rightMin=a.clone();
        for(int i=n-2; i>0; i--){
            rightMin[i]=Math.min(rightMin[i],rightMin[i+1]);
        }
        int leftMin=a[0];
        for(int i=1; i<n-1; i++){
            if(a[i]>leftMin && a[i]>rightMin[i+1])
            {
                continue;
            }
            answer++;
            leftMin=Math.min(leftMin,a[i]);
        }

        return answer;
    }
}
