package kakaoInternship._2020;

import java.util.ArrayList;

public class operateMaximum {
    public static void main(String[] args) {
        String exp="100-200*300-500+20";
        System.out.println(solution(exp));
    }
    static char op[]={'+','-','*'};
    static ArrayList<Long> digits=new ArrayList<>();
    static ArrayList<Character> operations=new ArrayList<>();
    static boolean visited[]=new boolean[3];
    static char priority[]=new char[3];
    public static long solution(String expression) {
        String number="";
        for (int i = 0; i < expression.length(); i++) {
            char ch=expression.charAt(i);
            if(ch-'0'>=0 && ch-'0'<=9)
                number+=ch;
            else {
                long val=Long.parseLong(number);
                digits.add(val);
                number="";
                operations.add(ch);
            }
        }
        digits.add(Long.parseLong(number));
        doPrioriy(0);
        return max;
    }
    static void doPrioriy(int cnt)
    {
        if(cnt==3)
        {
            calc();
            return;
        }
        for (int i = 0; i < 3; i++) {
            if(!visited[i])
            {
                visited[i]=true;
                priority[cnt]=op[i];
                doPrioriy(cnt+1);
                visited[i]=false;
            }
        }
    }
    static long max=0;
    static void calc()
    {
        ArrayList<Long> copyDigits=new ArrayList<>(digits);
        ArrayList<Character> copyOp=new ArrayList<>(operations);
        long ans=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < copyOp.size(); j++) {
                if(priority[i]== copyOp.get(j))
                {
                    switch (priority[i])
                    {
                        case '+':
                            ans=copyDigits.remove(j)+copyDigits.remove(j);
                            break;
                        case '-':
                            ans=copyDigits.remove(j)-copyDigits.remove(j);
                            break;
                        case '*':
                            ans=copyDigits.remove(j)*copyDigits.remove(j);
                            break;
                    }
                    copyDigits.add(j,ans);
                    copyOp.remove(j);
                    j--;
                }
            }
        }
        max=Math.max(max,Math.abs(copyDigits.get(0)));
    }
}
