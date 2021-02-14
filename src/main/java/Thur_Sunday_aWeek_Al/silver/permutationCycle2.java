package Thur_Sunday_aWeek_Al.silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class permutationCycle2 {
    static int parent[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            parent=new int[n+1];
            for (int i = 1; i < n+1; i++) {
                parent[i]=i; // 초기화
            }
            String str[]=sc.nextLine().split(" ");
//            Integer.parseInt(str[i]);
            for (int i = 1; i <n+1 ; i++) {
                UnionParent(i, Integer.parseInt(str[i-1]));
            }
            Set<Integer> s=new HashSet<>();
            //[ 0,1,1,2,3,4,1,1]
            for (int i = 1; i < n+1; i++) {
//                System.out.print(find(i)+" ");
                s.add(find(i));
            }
            System.out.println(s.size());
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
