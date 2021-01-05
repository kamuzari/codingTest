package Wed_aWeek_Study.Al_Study.BruteForce2;

import java.util.Scanner;

public class 로또 {
    static int n;
    static boolean[] visited;
    static int []temp=new int[6];
    static int[]arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=1;
        while (n!=0) {
            String str[] = sc.nextLine().split(" ");
            n = parseInt(str[0]);
            arr = new int[n];
            visited = new boolean[n];

            for (int i = 1; i < str.length; i++) {
                arr[i - 1] = parseInt(str[i]);
            }
            combination(0,0);
            System.out.println();
        }

    }
    static void combination(int idx,int depth)
    {
        if(depth==6)
        {
            print();
        }
        else
        {
            for (int i = 0; i <n ; i++) {
                if(!visited[i])
                {
                    visited[i]=true;
                    temp[depth]=arr[i];
                    if(depth==0)
                        combination(idx,depth+1);
                    if(depth>0 && temp[depth]>temp[depth-1])
                        combination(idx,depth+1);
                    visited[i]=false;
                }

            }
        }
    }
    static void print()
    {
        for (int i = 0; i <temp.length ; i++) {
            System.out.print(temp[i]+" ");
        }
        System.out.println();
    }

    static int parseInt(String str)
    {
        return Integer.parseInt(str);
    }
}
