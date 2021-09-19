package tues_thurs_sat._202109._20210919;

public class PGM12984_LandEdit {
    private int n,m;
    private long build=0,cut=0;
    public long solution(int[][] land, int P, int Q) {
        long answer = -1;
        n=land.length;
        m=land[0].length;
        build=P;
        cut=Q;
        long maxBlock=0,minBlock=Long.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                maxBlock=Math.max(maxBlock,land[i][j]);
                minBlock=Math.min(minBlock,land[i][j]);
            }
        }
        // System.out.println(maxBlock+" "+minBlock);
        long s=minBlock;
        long e=maxBlock;
        while(s<=e){
            long mid=(s+e)>>1;

            long left= CalculationCost(mid,land);
            long right = CalculationCost(mid+1,land);
            if(left<=right){
                answer=left;
                e=mid-1;
            }else {
                answer=right;
                s=mid+1;
            }
        }
        return answer;

    }
    public long CalculationCost(long target,int map[][]){
        int temp[][]=copy(map);
        long sum=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
            {
                long diff=target-map[i][j];

                if(diff==0){ continue;}
                else if(diff>0){
                    sum+=build*Math.abs(diff);
                }else if(diff<0){
                    sum+=cut*Math.abs(diff);
                }
            }
        }
        return sum;
    }
    public int[][] copy(int map[][]){
        int temp[][]=new int[map.length][map[0].length];
        for(int i=0; i<n; i++){
            temp[i]=map[i].clone();
        }
        return temp;
    }
}
