package Basic.DataStructure;

import java.util.Stack;
import java.io.*;

public class BalanceWorld {
    public static void main(String args[]) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        Stack<Character> s=new Stack<Character>();

        while (!str.equals("."))
        {
            str=br.readLine();

            if(str.equals("."))
                break;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)=='[' || str.charAt(i)=='(')
                {
                    s.push(str.charAt(i));
                    if(i==str.length()-1 && !s.isEmpty())
                    {
                        System.out.println("no");
                        break;
                    }
                }
                else if(s.isEmpty()&&(str.charAt(i)==']' || str.charAt(i)==')'))
                {
                    System.out.println("no");
                    break;
                }
                else if(!s.isEmpty() &&s.peek()=='['&& str.charAt(i)==']')
                {
                    s.pop();
                    if(i==str.length()-1 && s.isEmpty())
                    {
                        System.out.println("yes");
                        break;
                    }
                }
                else if(!s.isEmpty() && s.peek()=='('&& str.charAt(i)==')')
                {
                    s.pop();
                    if(i==str.length()-1 && s.isEmpty())
                    {
                        System.out.println("yes");
                        break;
                    }
                }
                else if(!s.isEmpty() && s.peek()=='('&& str.charAt(i)==']')
                {
                    System.out.println("no");
                    break;
                }
                else if(!s.isEmpty() && s.peek()=='['&& str.charAt(i)==')')
                {
                    System.out.println("no");
                    break;
                }

                else if(i==str.length()-1 && s.isEmpty())
                {
                    System.out.println("yes");
                }
                else if(i==str.length()-1 && !s.isEmpty())
                {
                    System.out.println("no");
                    break;
                }
                else
                {
                    continue;
                }
            }

            s.clear();
        }

    }
}
