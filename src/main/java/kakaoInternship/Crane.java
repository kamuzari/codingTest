package kakaoInternship;

import java.util.Stack;

public class Crane {
    public static void main(String[] args) {
        int b[][]={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int m[]={1,5,3,5,1,2,1,4}; // 3 5
        System.out.println(solution(b,m));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i < moves.length; i++) {
                    int idx=moves[i]-1;
                for (int k = 0; k <board.length; k++) {
                    if(board[k][idx]==0)
                        continue;
                    else
                    {
                        if(s.isEmpty()) {
                            s.push(board[k][idx]);
                            board[k][idx]=0;
                        }
                        else
                        {
                            if(s.peek()==board[k][idx]) {
                                s.pop();
                                answer++;
                            }
                            else
                            {
                                s.push(board[k][idx]);
                            }
                            board[k][idx]=0;
                        }
                        break;
                    }
            }

        }
        return answer*2;
    }
}
