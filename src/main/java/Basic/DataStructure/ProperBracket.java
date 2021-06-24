package Basic.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ProperBracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Stack<String> s = new Stack<>();
        String input[] = br.readLine().split("");
        int a = 2;
        int b = 3; // () , []
        boolean flag = false;
        ArrayList<Integer> arr = new ArrayList<>(); // 저장 공간.
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(") || input[i].equals("[")) {
                s.push(input[i]);
            } else {
                // 다른 것이 들어 올 때 ( "]" , ")" ) 닫는 괄호 라는 구간.
                if (s.isEmpty()) {
                    flag=true;
                    break;
                }

                if (input[i].equals(")")) {
                    if (!s.isEmpty() && s.peek().equals("(")) {
                        s.pop();
                        s.push("2");
                    } else {
                        while (!s.isEmpty() &&!s.peek().equals("(")) {
                            if(s.peek().equals("[") ||s.peek().equals("]"))
                            {
                                break;
                            }
                            else
                                sum += Integer.parseInt(s.pop());
                        }
                        if(!s.isEmpty() && s.peek().equals("("))
                        {
                            s.pop();
                            sum = sum * 2;
                            String strSum = Integer.toString(sum);
                            s.push(strSum);
                        }
                        else
                        {
                            flag=true;
                            sum=0;
                            break;
                        }
                        sum = 0;
                    }
                } else if (input[i].equals("]")) {
                    if (!s.isEmpty() &&s.peek().equals("[")) {
                        s.pop();
                        s.push("3");
                    } else {
                        while (!s.isEmpty() &&!s.peek().equals("[")) {
                            if(s.peek().equals(")") ||s.peek().equals("("))
                            {
                                break;
                            }
                            else
                                sum += Integer.parseInt(s.pop());
                        }
                        if(!s.isEmpty()&& s.peek().equals("[")) {
                            s.pop();
                            sum = sum * 3;

                            String strSum = Integer.toString(sum);
                            s.push(strSum);
                        }
                        else{
                            flag=true;
                            sum=0;
                            break;
                        }
                        sum = 0;
                    }
                }
            }
        }
        while (!s.isEmpty() && !flag)
        {
            if(s.peek().equals("[")||s.peek().equals("]")||s.peek().equals("(")||s.peek().equals(")"))
            {
                System.out.println("0");
                return;
            }
            int x=Integer.parseInt(s.pop());
            sum+=x;
        }
        System.out.println(sum);
    }
}
