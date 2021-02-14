package oneDay_twoSol.graphTheory;

import java.util.Scanner;

public class travelPlan {
    static int n,m,parent[];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        parent=new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(sc.nextInt()==1)
                {
                    union(i+1,j+1);
                }
            }
        }
        boolean flag=true;
        String str[]=sc.nextLine().split(" ");
        for (int i = 0; i < str.length-1; i++) {
            if(find(Integer.parseInt(str[i]))!=find(Integer.parseInt(str[i+1])))
            {
                flag=false;
                break;
            }
        }
        if(flag)
        {
            System.out.println("YES");

        }
        else
            System.out.println("NO");

    }
    static void union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a<b)
            parent[b]=a;
        else
            parent[a]=b;

    }
    static int find(int a)
    {
        if(a==parent[a])
            return a;
        return parent[a]=find(parent[a]);
    }
}
/*
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 3
* */
