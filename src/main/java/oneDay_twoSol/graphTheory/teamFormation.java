package oneDay_twoSol.graphTheory;

import java.util.Scanner;

public class teamFormation {
    static int parent[];
    public static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a<b)
            parent[b]=a;
        else
            parent[a]=b;
    }
    public static int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]); // 경로 압축
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        parent=new int[n+1];
        // init
        for (int i = 1; i <n+1 ; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < m; i++) {
                int command=sc.nextInt();
                int a=sc.nextInt();
                int b=sc.nextInt();

                if(command==0)
                {
                    union(a,b);
                }
                else
                {
                    if(find(a)!=find(b))
                    {
                        System.out.println("NO");
                    }
                    else
                        System.out.println("YES");
                }
        }
    }
    /*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
    */
}
