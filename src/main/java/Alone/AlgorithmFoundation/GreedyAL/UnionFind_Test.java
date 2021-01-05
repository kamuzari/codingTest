package Alone.AlgorithmFoundation.GreedyAL;

public class UnionFind_Test {
    static int parent[]=new int[9];
    public static void main(String[] args) {
        // 초기화 과정
        for (int i = 1; i <=8 ; i++) {
            parent[i]=i;
        }

        union(1,2);
        union(2,3);
        boolean x=inSameParent(1,3);
        System.out.println(x);

    }
    public static void union(int x,int y)
    {
        x=find(x);
        y=find(y);
        if(x!=y)
        {
            if(y>x)
                parent[y]=x;
            else
                parent[x]=y;
        }
    }

    public static boolean inSameParent(int x,int y)
    {
        x=find(x);
        y=find(y);
        if(x==y)
        {
            return true;
        }

        return false;
    }
    public static int find(int x)
    {
        if(parent[x]==x)
            return x;
        else
            return find(parent[x]);
    }
}
