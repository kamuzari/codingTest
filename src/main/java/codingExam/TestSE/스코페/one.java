package codingExam.TestSE.스코페;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node arr[][] = new Node[n][2]; // start - end
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[] = sc.nextLine().split("~");
            String str2[];
            for (int j = 0; j < str.length; j++) {
                str[j]=str[j].trim();
                str2 = str[j].split(":");
                int h,m;
                if (str2[0].equals("00"))
                    h = 0;
                else
                    h = Integer.parseInt(str2[0]);
                if(str2[0].equals("00"))
                    m=0;
                else
                    m = Integer.parseInt(str2[1]);
                arr[i][j] = new Node(h, m);
            }
        }
        for (int i = 0; i < n; i++) {
                System.out.println(arr[i][0].toString()+"  "+arr[i][1].toString());
        }
        Arrays.sort(arr, new Comparator<Node[]>() {
            @Override
            public int compare(Node[] o1, Node[] o2) {
                if (o1[1].h - o2[1].h == 0) {
                    if (o1[1].m == o2[1].m) {
                        if (o1[0].h == o2[0].h) {
                            return o1[0].m - o2[0].m;
                        } else {
                            return o1[0].h - o2[0].h;
                        }
                    } else
                        return o1[1].m - o2[1].m;
                }
                return o1[1].h - o2[1].h;
            }
        });
        System.out.println("c=======x");
        for (int i = 0; i < n; i++) {
                System.out.println(arr[i][0].toString()+"  "+arr[i][1].toString());
        }


        int cnt = 0;
        int endH = -1;
        int endM = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i][0].h >= endH && arr[i][0].m >= endM) {
                endH = arr[i][1].h;
                endM = arr[i][1].m;
                cnt++;
            }
        }
        System.out.println(endH+"  "+endM);
        System.out.println(cnt);

    }

    static class Node {
        private int h, m;

        public Node(int h, int m) {
            this.h = h;
            this.m = m;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "h=" + h +
                    ", m=" + m +
                    '}';
        }
    }
}
