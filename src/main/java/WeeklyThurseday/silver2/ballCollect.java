package WeeklyThurseday.silver2;

import java.util.Scanner;

public class ballCollect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char ch[] = new char[n];
        sc.nextLine();
        String str = sc.nextLine();
        ch = str.toCharArray();
        int rCnt = 0;
        int bCnt = 0;
        int ans = (int) 1e9;

        for (int i = 0; i < n; i++) {
            if (ch[i] == 'R')
                rCnt++; //5
            else
                bCnt++; //4
        }
        int cnt = 0;
        // R 모두 오른쪽
        for (int j = 0; j < n; j++) {
            if (ch[j] == 'R')
                cnt++;
            else
                break;
        }
        ans = Math.min(ans, rCnt - cnt); // 4
        // R 모두 왼쪽
        cnt = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (ch[j] == 'R') {
                cnt++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, rCnt - cnt);
        // B 모두 오른쪽
        cnt = 0;
        for (int j = 0; j < n; j++) {
            if (ch[j] == 'B')
                cnt++;
            else
                break;
        }
        ans = Math.min(ans, bCnt - cnt);
        // B 모두 왼쪽
        cnt = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (ch[j] == 'B') {
                cnt++;
            } else {
                break;
            }
        }
        ans = Math.min(ans, bCnt - cnt);
        System.out.println(ans);


    }
}
