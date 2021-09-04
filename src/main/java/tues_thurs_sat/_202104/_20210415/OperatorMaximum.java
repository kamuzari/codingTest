package tues_thurs_sat._202104._20210415;

import java.util.ArrayList;

/*
arr[0]="+";
arr[1]="-";
arr[2]="*";
*/
public class OperatorMaximum {
    public static void main(String[] args) {
       long a= solution("100-200*300-500+20");
        long b=solution("50*6-3*2");
        System.out.println(a);
        System.out.println(b);
    }
    static char op[] = {'+', '-', '*'};
    static char priority[] = new char[3];
    static boolean visited[] = new boolean[3];
    static ArrayList<Long> numbers = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();
    static long answer = 0;



    public static long solution(String expression) {
        String number = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) - '0' >= 0 && expression.charAt(i) - '0' <= 9)
                number += expression.charAt(i);
            else {
                numbers.add(Long.parseLong(number));
                number = "";
                ops.add(expression.charAt(i));
            }
        }
        numbers.add(Long.parseLong(number));
        PriorityOperatePick(0);
        return answer;
    }

    static void PriorityOperatePick(int cnt) {
        if (cnt == 3) {
//            System.out.println(Arrays.toString(priority));
            calc();
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                priority[cnt] = op[i];
                PriorityOperatePick(cnt + 1);
                visited[i] = false;
            }
        }
    }

    static void calc() {
        ArrayList<Long> copyNumbers = new ArrayList<>(numbers);
        ArrayList<Character> copyOps = new ArrayList<>(ops);
        long ans=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < copyOps.size(); j++) {
                if (priority[i] == copyOps.get(j)) {
                    switch (priority[i]) {
                        case '+':
                            ans = copyNumbers.remove(j) + copyNumbers.remove(j);
                            break;

                        case '-':
                            ans = copyNumbers.remove(j) - copyNumbers.remove(j);
                            break;

                        case '*':
                            ans = copyNumbers.remove(j) * copyNumbers.remove(j);
                            break;
                    }
                    copyNumbers.add(j, ans);
                    copyOps.remove(j);
                    j--;
                }
            }
        }
       answer= Math.max(answer,Math.abs(copyNumbers.get(0)));
    }
}
