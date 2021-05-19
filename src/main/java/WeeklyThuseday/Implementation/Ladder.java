package WeeklyThuseday.Implementation;

import java.util.Scanner;


//https://www.acmicpc.net/problem/2469
public class Ladder {
    static int k;
    static int n;
    static int ladder[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); // 사람 수
        n = sc.nextInt(); // 각 라인
        sc.nextLine();
        char start[]=new char[k];
        for (int i = 0; i < k; i++) {
            start[i] = (char) ('A'+i);
        }

        String str[] = sc.nextLine().split("");
        char end[] = new char[k];
        for (int i = 0; i < k; i++) {
            end[i] = str[i].charAt(0);
        }

//        System.out.println(Arrays.toString(start));
//        System.out.println(Arrays.toString(end));
        int exchangeLine=0;
        ladder = new int[n][k - 1];
        for (int i = 0; i < n; i++) {
            String str2[] = sc.nextLine().split("");
            for (int j = 0; j < k - 1; j++) {
                if (str2[j].equals("*"))
                    ladder[i][j] = 0;
                else if (str2[j].equals("-"))
                    ladder[i][j] = 1;
                else { //?
                    exchangeLine=i;
                    ladder[i][j] = 2;
                } // 모른다.
            }
        }
//        System.out.println("사다리 상태.");
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(ladder[i]));
//        }
//        System.out.println("=========== logic ===========");
        for (int i = 0; i <exchangeLine ; i++) {
            for (int j = 0; j <k-1 ; j++) {
                if(ladder[i][j]==1)
                {
                    char t=start[j];
                    start[j]=start[j+1];
                    start[j+1]=  t;
                }
            }
        }
        for (int i =ladder.length-1; i>exchangeLine  ; i--) {
            for (int j = 0; j <k-1 ; j++) {
                if(ladder[i][j]==1)
                {
                    char t=end[j];
                    end[j]=end[j+1];
                    end[j+1]=t;
                }
            }
        }
//        System.out.println(Arrays.toString(start));
//        System.out.println(Arrays.toString(end));
        char ans[]=new char[k-1];
        for (int i = 0; i <k-1 ; i++) {
            if(start[i]==end[i])
            {
                ans[i]='*';
            }
            else if(start[i]==end[i+1] && start[i+1]==end[i])
            {
                ans[i]='-';
                char t=end[i];
                end[i]=end[i+1];
                end[i+1]=t;

            }
            else
            {
                for (int j = 0; j <k-1 ; j++) {
                    ans[j]='x';
                }
                break;
            }
        }
        for (char c: ans
             ) {
            System.out.print(c);
        }

    }
}
