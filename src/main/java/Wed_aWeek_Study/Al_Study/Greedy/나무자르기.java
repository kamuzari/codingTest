package Wed_aWeek_Study.Al_Study.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 나무자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //나무의 개수
        sc.nextLine();
        String str[] = sc.nextLine().split(" ");
        String str2[] = sc.nextLine().split(" ");
        tree arr[] = new tree[n];
        for (int i = 0; i < str.length; i++) {
            arr[i] = new tree(Integer.parseInt(str[i]), Integer.parseInt(str2[i]));
        }
        Arrays.sort(arr);
//        for (tree t:arr) {
//            System.out.println(t.h + "   " +t.g);
//        }
        int j = 1;
        long sum = 0; // 범위 조심합시다...
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].h + arr[i].g * i;
        }
        System.out.println(sum);
        // 6,3 8,16,31
        // 가중치가 작은 순서대로. 자라는 길이가.
    }
    static class tree implements Comparable<tree>{
        int h;
        int g;

        public tree(int h, int g) {
            this.h = h;
            this.g = g;
        }

        @Override
        public int compareTo(tree o) {
            if(this.g>o.g)
                return 1;
            else if(this.g ==o.g)
                return 0;
            else
                return -1;
        }
    }

}