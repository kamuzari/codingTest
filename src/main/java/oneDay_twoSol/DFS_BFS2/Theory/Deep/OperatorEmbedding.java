package oneDay_twoSol.DFS_BFS2.Theory.Deep;

import java.util.Scanner;

public class OperatorEmbedding {
    static int number[];
    static int n;
    static int operator[]=new int[4];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        number=new int[n];
        for (int i = 0; i < n; i++) {
            number[i]=sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operator[i]=sc.nextInt();
        }
        recursion(1,number[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static int max=-1_000_000_001;
    static int min=1_000_000_001;
    static void recursion(int cnt,int sum)
    {
        if(cnt==n)
        {
            min=Math.min(sum,min);
            max=Math.max(sum,max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(operator[i]!=0)
            {
                operator[i]--;
                switch (i)
                {
                    case 0:
                        recursion(cnt+1,sum+number[cnt]);
                        break;
                    case 1:
                        recursion(cnt+1,sum-number[cnt]);
                        break;
                    case 2:
                        recursion(cnt+1,sum*number[cnt]);
                        break;
                    case 3:
                        recursion(cnt+1,sum/number[cnt]);
                        break;
                }
                operator[i]++;
            }
        }



    }
}
