package WeeklyThuseday.Implementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake {
    static int board[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int apple = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < apple; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            board[a - 1][b - 1] = 1; // 사과가 있는 칸 1;
        }

//        for (int i = 0; i < apple; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
        int L = sc.nextInt();
        sc.nextLine();
        int time[] = new int[10001]; // 0 1 2 3 4 5 6 7
        int last_Idx = 0;
        for (int i = 0; i < L; i++) {
            String[] str = sc.nextLine().split(" ");
            int a = Integer.parseInt(str[0]);

            if (str[1].equals("D"))
                time[a] = 1;
            else
                time[a] = -1;
            last_Idx = a + 1; // 시간 끝이 어디인지 확인하기 위해.
        }
//        for (int i = 1; i < last_Idx; i++) {
//            System.out.print(time[i] + " ");
//        }
        // logic
        int idx = 0;
        int dy[] = {0, 1, 0, -1}; //오른쪽 아래 왼쪽 위
        int dx[] = {1, 0, -1, 0};
        Queue<position> q = new LinkedList<>();
        int sX = 0;
        int sY = 0; // 현재 뱀의 위치
        int sDirections = 0;
        board[sX][sY] = -1; // 뱀이 지나간 칸 -1;
        int i = 0;
        q.add(new position(sY, sX));
        while (true) {
            if (time[i] == 0) // 회전이 없으면.
            {
                i++;
                sY += dy[sDirections];
                sX += dx[sDirections];
                boolean flag=false;
                for (position p:q) {
                    if(p.x==sX && p.y==sY)
                    {
//                        System.out.println("발견하였습니다 중복");
//                        System.out.println(i);
                        flag=true;
                        break;
                    }
                }
                System.out.println(sY + " " + sX);
                /*if(q.contains(new position(sY,sX))) // 뱀의 꼬리와 충돌햇나.
                    break;*/
//                System.out.println(q.contains(new position(sY,sX)));
                if (sY>=0&&sY <= n - 1 && sX>=0&& sX <= n - 1  && !flag) {
                    if (board[sY][sX] == 1) {
                        // 사과가 있으면
                        board[sY][sX]=0; // 사과 먹은거..표기
                        q.add(new position(sY, sX));
                    } else {
                        q.poll();
                        q.add(new position(sY, sX));
                    }
                }
                else
                {
                    System.out.println(i);
                    break;
                }
            }
            if (time[i] == 1)// 오른쪽 회전
            {
                sDirections++;
                if (sDirections > 3) {
                    sDirections %= 4;
                }
                time[i]=0;
            }
            if (time[i] == -1) // 왼쪽 회전
            {
                sDirections--;
                if (sDirections < 0) {
                    sDirections=3;
                }
                time[i]=0;

            }

        }
    }

    static class position {
        int y;
        int x;

        public position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
/*
5
0
5
4 D
8 D
12 D
15 D
20 L
* */