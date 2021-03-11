package Thur_Sunday_aWeek_Al.SW_MaestroReady;

import java.util.Scanner;
import java.util.Stack;

public class SecureString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while (true) {
            String str = sc.nextLine();
            if (str.charAt(0) == '-') {
                break;
            } else {
                char ch[] = str.toCharArray();

                int transCnt = 0;
                Stack<Character> s = new Stack<>();
                int idx = 0;
                for (char c : ch) {
                    if (s.isEmpty() && c == '}') {
                        ch[idx] = '{';
                        s.push(ch[idx]);
                        transCnt++;
                    } else if (!s.isEmpty() && ch[idx] == '}') {
                        s.pop();
                    } else {
                        s.push(c);
                    }
                    idx++;
                }
                if (!s.isEmpty())
                    transCnt += s.size() / 2;
                System.out.println(++cnt + ". " + transCnt);
            }

        }
    }
    // 예외 케이스 (여는괄호 또는 닫는괄호로만 입력이 주어질 경우의 애기는 없다..?)
    /*
    - 스택이 비었을 때 닫는괄호면 여는괄호로 바꿔서 넣어주고
    - 스택이 안비었을 때.
        -닫는괄호면 (밑에 경우 여는 괄호가 스택에 여는괄호가 들어있게 되므로) 짝이 맞아 바로 스택 pop
    - 스택이 비어있지만 여는괄호의 경우 또는 스택이 비어있지 않을 떄 여는괄호면 stack에 넣는다.
    * */
}
