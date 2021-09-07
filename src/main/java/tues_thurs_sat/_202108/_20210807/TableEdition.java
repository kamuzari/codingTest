package tues_thurs_sat._20210807;

import java.util.*;

public class TableEdition {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove =new Stack();
        int tableSize=n;

        for(int i=0; i<cmd.length; i++)
        {
            char ch=cmd[i].charAt(0);
            if(ch=='U')
            {
                k-=Integer.valueOf(cmd[i].substring(2));
            }
            else if(ch=='D')
            {
                k+=Integer.valueOf(cmd[i].substring(2));
            }
            else if(ch =='C')
            {
                remove.push(k);
                tableSize--;
                if(k==tableSize)
                    k--;
            }
            else
            {
                int unDoRow=remove.pop();
                if(k>=unDoRow)
                    k++;
                tableSize++;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0; i<tableSize; i++)
        {
            sb.append('O');
        }
        while(!remove.isEmpty())
        {
            sb.insert(remove.pop().intValue(),'X');
        }
        return sb.toString();
    }
}
