package Basic.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFIx {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String postFix=br.readLine()    ;

        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        Stack<Double> s=new Stack<>()   ;
        for (int i = 0; i <postFix.length() ; i++) {
            char ch = postFix.charAt(i);
            if(ch>='A' && ch<='Z')
            {
                double d = arr[ch - 'A'];
                s.push(d);
            }
            else
            {
                Double d1 = s.pop();
                Double d2 = s.pop();
                if(ch=='+')
                    d2+=d1;
                else if(ch=='-')
                    d2-=d1;
                else if(ch=='*')
                    d2*=d1;
                else if(ch=='/')
                    d2/=d1;

                s.push(d2);
            }
        }
        System.out.printf("%.2f",s.pop());
    }
}
