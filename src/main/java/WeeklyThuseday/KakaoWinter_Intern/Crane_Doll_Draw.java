package WeeklyThuseday.KakaoWinter_Intern;

import java.util.Stack;

public class Crane_Doll_Draw {
    public static void main(String[] args) {
        int a[][] = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        // s ->   4  3  1  1  3   5  0  1  0 4
        int m[] = {1, 5, 3, 5, 1, 2, 1, 4};
        int x=solution(a,m);
        System.out.println(x);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i <moves.length ; i++) {
            // pick doll
            for (int j = 0; j < board.length ; j++) {
                int doll=board[j][moves[i]-1];
                if(doll!=0)
                {
                    board[j][moves[i]-1]=0;
                    if(s.isEmpty())
                        s.push(doll);
                    else if(!s.isEmpty() && s.peek()==doll)
                    {
                        s.pop();
                        answer+=2;
                    }
                    else
                        s.push(doll);
//                    s.push(doll); [4, 3, 1, 1, 3, 2, 4]
                    break;
                }
            }
        }
        System.out.println(s);
        return answer;
    }
}
