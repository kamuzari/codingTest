package Thur_Sunday_aWeek_Al.DFS_BFS;

import java.util.PriorityQueue;
import java.util.Scanner;
// 메모리 초과.
public class findCity {
    static PriorityQueue<Integer> vertaxBox = new PriorityQueue<>();
    static int n;
    static int m;
    static int x;
    static int k;
    static boolean matrix[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //vertax;
        m = sc.nextInt(); // edge

        k = sc.nextInt();//givenDistance
        x = sc.nextInt();//start_city
        matrix = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            matrix[sc.nextInt()][sc.nextInt()] = true;
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
        for (int i = 1; i <=n; i++) {
            if(matrix[x][i])
                DFS(1,x, i);
        }
//        System.out.println(vertaxBox);
        if(!vertaxBox.isEmpty())
        {
            for (Integer q : vertaxBox) {
                System.out.print(q+" ");
            }
        }
        else
        {
            System.out.println("-1");
        }
    }

    static void DFS(int depth,int i, int j) {
        if(depth >k)
        {
            return;
        }
        if (depth == k) {
            vertaxBox.add(j);
            return;
        }
        for (int l = 1; l <= n; l++) {
            if (i != l && matrix[j][l] &&!matrix[x][l]) {
                DFS(depth+1,j,l);
            }
        }
    }


}
