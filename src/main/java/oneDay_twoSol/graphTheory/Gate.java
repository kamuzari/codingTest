package oneDay_twoSol.graphTheory;

import java.util.Scanner;

public class Gate {
    static int g,p,parent[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        g=sc.nextInt();
        p=sc.nextInt();
        parent=new int[g+1];
        for (int i = 1; i < g + 1; i++) {
            parent[i]=i;
        }
        int cnt=0;
        for (int i = 0; i < p; i++) {
            int gate=find(sc.nextInt());
            if(gate!=0)
            {
                union(gate,gate-1);
                cnt++;
            }
            else
                break;
        }
        System.out.println(cnt);
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
