package tues_thurs_sat._202109._20210914;

public class VisitLegnth {
    final int UP=1;
    final int RIGHT=2;
    final int DOWN=3;
    final int LEFT=4;

    public static void main(String[] args) {
        VisitLegnth visitLegnth = new VisitLegnth();
        visitLegnth.solution("ULURRDLLU");
    }
    public int solution(String dirs) {

        int answer = 0;
        boolean map[][][]=new boolean[5][11][11];

        int startX=5;
        int startY=5;
        int prevDir=0;
        for(int i=0; i<dirs.length(); i++) {
            char cmd = dirs.charAt(i);
            int ny=startY;
            int nx=startX;
            int nextDir=-1;
            if(cmd=='U'){
                ny-=1;
                prevDir=3;
                nextDir=1;

            }else if(cmd=='R'){
                nx+=1;
                prevDir=4;
                nextDir=2;
            }else if(cmd=='D'){
                ny+=1;
                prevDir=1;
                nextDir=3;
            }else if(cmd=='L')
            {
                nx-=1;
                prevDir=2;
                nextDir=4;
            }

            if(nx>=0 && ny>=0 && ny<11 && nx<11)
            {
                if(!map[prevDir][startY][startX] && !map[nextDir][ny][nx])
                {
                    map[prevDir][startY][startX]=true;
                    map[nextDir][ny][nx]=true;
                    answer++;
                }
                startY=ny;
                startX=nx;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
