package tues_thurs_sat._20210730;

import java.util.Stack;

public class move110 {
    public static void main(String[] args) {
        solution(new String[]{"11011"});
    }
    public static String[] solution(String[] s) {
        String answer[] = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            int cnt=0;
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s[i].length(); j++) {
                stack.push(s[i].charAt(j));

                if(stack.size()>=3)
                {
                    Character initPop = stack.pop();
                    if(initPop!='0')
                    {
                        stack.push(initPop);
                        continue;
                    }
                    Character twoPop = stack.pop();
                    if(twoPop!='1')
                    {
                        stack.push(twoPop);
                        stack.push(initPop);
                        continue;
                    }
                    Character threePop = stack.pop();
                    if(threePop!='1')
                    {
                        stack.push(threePop);
                        stack.push(twoPop);
                        stack.push(initPop);
                        continue;
                    }
                    cnt++;
                }
            }
            StringBuilder sb=new StringBuilder();
            int position=stack.size();
            boolean flag=false;

            while (!stack.isEmpty())
            {
                Character pop = stack.pop();
                if(!flag && pop=='1') position--;
                if(pop=='0')
                    flag=true;
                sb.insert(0,pop);
            }

            String newAnswer="";
            for (int j = 0; j < cnt; j++) {
                sb.insert(position,"110");
            }
            answer[i]=sb.toString();
        }
        return answer;
    }
}
