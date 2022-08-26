package programmers.kakao2022;

public class NotDestroyBuildingTLE {
    static final int DESTROY=1;
    static final int CURE=2;
    static int b[][];
    public int solution(int[][] board, int[][] skill) {
        b=board;
        for(int [] behavior : skill){
            buildSkill(behavior);
        }
        int answer = 0;
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b[i].length; j++){
                if(b[i][j]>0){
                    answer++;
                }
            }
        }
        return answer;
    }

    /**
     * TODO : 효율성 시간 초과
     *
     * @param skill
     */
    public void buildSkill(int[] skill){
        int type=skill[0];
        int r1=skill[1];
        int c1=skill[2];
        int r2=skill[3];
        int c2=skill[4];
        int degree=skill[5];
        if(type==DESTROY){
            go(r1,c1,r2,c2,-degree);
        }else if(type==CURE){
            go(r1,c1,r2,c2,degree);
        }
    }

    public void go(int r1,int c1,int r2,int c2,int degree){
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                b[i][j]+=degree;
            }
        }
    }

}
