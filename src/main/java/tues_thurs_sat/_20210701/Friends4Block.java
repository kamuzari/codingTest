package tues_thurs_sat._20210701;

public class Friends4Block {
    static char map[][];

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map=new char[n][m];
        for(int i=0; i<m;i++)
        {
            char ch[]=board[i].toCharArray();
            map[i]=ch.clone();
            // System.out.println(Arrays.toString(map[i]));
        }
        //System.out.println();

        while(true)
        {
            boolean check[][]=IndicationDot(map, m, n);
            int prev_Answer=answer;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++)
                {
                    if(check[i][j])
                    {
                        answer++;
                        map[i][j]='.';
                    }
                }
                //System.out.println(Arrays.toString(map[i]));
            }
            if(prev_Answer==answer)
            {
                break;
            }
            // System.out.println(answer);
            pullMap(map,m,n);

            for(int i=0; i<m ; i++)
            {
                //System.out.println(Arrays.toString(map[i]));
            }
        }

        return answer;
    }

    public char[][] pullMap(char[][] arr,int m,int n)
    {
        for(int i=0; i<n; i++)
        {
            for(int j=m-1; j>0; j--)
            {

                if(arr[j][i]=='.')
                {
                    for(int k=j; k>0; k--)
                    {
                        arr[k][i]=arr[k-1][i];
                    }
                    j++;
                    map[0][i]='-';
                }

            }
        }

        return arr;
    }

    public boolean[][] IndicationDot(char [][]arr,int m, int n)
    {
        boolean erase[][]=new boolean[m][n];
        for(int i=0;i<m-1;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                if(arr[i][j]=='-')
                    continue;

                char check[]=new char[4];
                check[0]=arr[i][j];
                check[1]=arr[i][j+1];
                check[2]=arr[i+1][j];
                check[3]=arr[i+1][j+1];

                if(AllEq(check))
                {
                    erase[i][j]=true;
                    erase[i][j+1]=true;
                    erase[i+1][j]=true;
                    erase[i+1][j+1]=true;
                }

            }
        }
        return erase;

    }
    boolean AllEq(char ch[])
    {
        for(int i=0;i<4;i++)
        {
            int criteria=ch[i];
            for(int j=0; j<4;j++)
            {
                if(i==j)
                    continue;

                if(criteria!=ch[j])
                    return false;
            }
        }
        return true;
    }
}
