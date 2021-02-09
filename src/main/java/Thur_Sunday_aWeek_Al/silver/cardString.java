package Thur_Sunday_aWeek_Al.silver;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class cardString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Deque<Character> dq=new LinkedList<>();
            int n = sc.nextInt();
            char str[] = new char[n];
            for (int i = 0; i <n ; i++) {
                str[i]=sc.next().charAt(0);
            }
            System.out.println(Arrays.toString(str));
            char crieteria=str[0];
            dq.add(str[0]);
            for (int i = 1; i <n ; i++) {
                if(crieteria<str[i]) // 사전순으로 뒤에 있으면 뒤로
                {
                    dq.addLast(str[i]);
                }
                else {
                    crieteria=str[i];
                    dq.addFirst(str[i]);
                }
            }
            for (Character character : dq) {
                System.out.print(character);
            }
            System.out.println();

        }
    }
}
