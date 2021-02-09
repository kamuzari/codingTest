package oneDay_twoSol.graphTheory;

import java.util.Scanner;

public class unionFind {
    static int v, e;
    static int parent[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        parent=new int[v+1];
        for (int i = 1; i < v+1; i++) {
            parent[i]=i; // 자기 자신을 root로 초기화
        }

        for (int i = 0; i < e; i++) {
            UnionParent(sc.nextInt(),sc.nextInt());
        }
        for (int i = 1; i <v+1 ; i++) {
            System.out.print(find(i)+" ");
        }



    }
     public static void UnionParent(int a, int b)
     {
         a=find(a);
         b=find(b);
         if(a<b)
             parent[b]=a;
         else
             parent[a]=b;
     }

    private static int find(int a) {
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);// 경로 압축.
    }

}
