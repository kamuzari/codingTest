package oneDay_twoSol.graphTheory.Grouping;

import java.util.ArrayList;
import java.util.Scanner;

public class SetExpression {
    static int n,m,parent[];
    static class Node{
        int a,b,cmd;

        public Node( int cmd,int a, int b) {
            this.cmd = cmd;
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();
        m=sc.nextInt();
        parent=new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i]=i;
        }
        ArrayList<Node> arrayList=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            arrayList.add(new Node(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        for (Node node : arrayList) {
            int command=node.cmd;
            switch (command)
            {
                case 0:
                    union(node.a,node.b);
                    break;
                case 1:
                    if(find(node.a)==find(node.b))
                    {
                        System.out.println("YES");
                    }
                    else
                    {
                        System.out.println("NO");
                    }
                    break;
            }
        }
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
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
}
