package Al_Study.Basic_implemetation;

import java.util.Scanner;

/*
 * 각 줄에서 가로 막대가 없는 경우에는 ‘*’(별)문자,
 * 있을 경우에는 ‘-’(빼기) 문자로 표시된다.
 * 그리고 감추어진 특정 가로 줄은 길이 k-1인 ‘?’ (물음표) 문자열로 표시되어 있다.
 * */
public class 사다리타기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        String str[] = sc.nextLine().split("");
        print(str);
        String cmd[] = new String[n];
        for (int i = 0; i < n; i++) {
            cmd[i] = sc.next();
        }
        print(cmd);
    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
