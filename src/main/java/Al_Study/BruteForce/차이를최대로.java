package Al_Study.BruteForce;

import java.util.Scanner;

public class 차이를최대로 {
    static int[] arr;
    static int[] temp;
    static boolean visited[];
    static int n;
    static int max=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        temp=new int[n];
        visited=new boolean[n];
        sc.nextLine();
        String str[]=sc.nextLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        permutation(n,0);
        System.out.println(max);
    }
    static void permutation(int n, int depth)
    {
        if(depth== 차이를최대로.n)
        {
            print();
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i])
            {
                visited[i] = true;
                temp[depth]=arr[i]; // 뽑힌 수(==뽑힌 값. 저장)
                permutation(n, depth + 1);
                visited[i] = false;
            }

        }
    }
    static void print()
    {
     /*   for (int i = 0; i <temp.length ; i++) {
            System.out.print(temp[i]+" ");
        }
        System.out.println();*/
        int sum=0;
        for (int i = 0; i < temp.length-1; i++) {
            sum+=Math.abs(temp[i]-temp[i+1]);
        }
        max=sum>max ? sum:max;
    }

}

