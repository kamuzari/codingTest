package SW_Maestro;

public class BigSquare {
    public static void main(String[] args) {
        int x[][]={{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int k=solution(x);
        System.out.println(k);
    }
    public static int solution(int [][]board)
    {
        int answer=0;
        int n=board.length;
        int m=board[0].length;

        int dp[][]=new int[n][m];
        if(n==1 && m==1)
        {
            return board[0][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(board[i][j]==1)
                {
                    board[i][j]=min(board[i-1][j],board[i-1][j-1],board[i][j-1])+1;
                    answer= Math.max(answer, board[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }


        return (int)Math.pow(answer,2);
    }
    public static int min(int a,int b,int c)
    {
        a= Math.min(a, b);
        return Math.min(a, c);
    }
}
