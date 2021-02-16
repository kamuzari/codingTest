package oneDay_twoSol.graphTheory.Grouping;

import java.util.Scanner;

public class teamProject {
    static int parent[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while (T-->0)
        {
            int n=sc.nextInt();

        }
    }
    static boolean union(int a,int b)
    {
        a=find(a);
        b=find(b);
        if(a!=b)
        {
            return false;
        }
        if(a<b)
            parent[b]=a;
        else
            parent[a]=b;
        return true;
    }
    static int find(int a)
    {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
}
