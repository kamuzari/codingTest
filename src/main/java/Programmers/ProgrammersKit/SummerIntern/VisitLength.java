package Programmers.ProgrammersKit.SummerIntern;

public class VisitLength {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {
        int answer = 0;

        boolean map[][][]=new boolean[4][11][11];
        int x=5;
        int y=5;
        int dir=0;
        for (int i = 0; i < dirs.length(); i++) {
            char ch=dirs.charAt(i);
            int ny=y;
            int nx=x;
            int ndir=0;
            switch (ch)
            {
                case 'U':
                    ny-=1;
                    dir=0;
                    ndir=1;
                    break;
                case 'D':
                    ny+=1;
                    dir=1;
                    ndir=0;
                    break;
                case 'L':
                    nx-=1;
                    dir=2;
                    ndir=3;
                    break;
                case 'R':
                    nx+=1;
                    dir=3;
                    ndir=2;
                    break;
            }
            if(nx>=0 && nx<11 && ny>=0 && ny<11) {
                if (!map[dir][y][x] && !map[ndir][ny][nx]) {
                    map[dir][y][x]=true;
                    map[ndir][ny][nx]=true;
                    answer++;
                }
                y=ny;
                x=nx;
            }

        }

        return answer;
    }
}
