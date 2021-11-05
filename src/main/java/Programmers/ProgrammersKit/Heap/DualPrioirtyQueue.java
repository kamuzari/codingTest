package Programmers.ProgrammersKit.Heap;

import java.util.Collections;
import java.util.LinkedList;

public class DualPrioirtyQueue {
    public static void main(String[] args) {
        String s[] = {"I 16", "D 1"};
//        System.out.println(solution(s));
        String s2[]={"I 7","I 5","I -5","D -1"};
        System.out.println(solution(s2));
    }

    static LinkedList<Integer> dq ;

    public static int[] solution(String[] operations) {
        int len = operations.length;
        dq=new LinkedList<>();
        for (int i = 0; i < len; i++) {

            String s[] = operations[i].split(" ");
            if(s[0].equals("D") )
            {
                if(s[1].equals("1"))
                {
                    if(!dq.isEmpty())
                        dq.pollLast();
                }
                else
                {
                    if(!dq.isEmpty())
                        dq.pollFirst();
                }
            }
            else
            {
                dq.add(Integer.parseInt(s[1]));
            }
            if(!dq.isEmpty())
            {
                Collections.sort(dq);
            }
        }
        if(dq.isEmpty())
            return new int[]{0,0};
        else
        {
            Integer min = dq.peekFirst();
            Integer max = dq.peekLast();
            return new int[]{max,min};
        }
    }
}
