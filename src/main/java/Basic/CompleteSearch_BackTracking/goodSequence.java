package Basic.CompleteSearch_BackTracking;

import java.util.Scanner;

public class goodSequence {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        pick("");


    }
    static void pick(String str)
    {
        if(str.length()==n)
        {
            System.out.println(str);
            System.exit(0);

        }
        for (int i = 1; i <= 3; i++) {
                if(isGoodSequence(str+i))
                {
                    pick(str+i);
                }
        }
    }
    public static boolean isGoodSequence(String str)
    {
        int len=str.length()/2;
        for (int i = 1; i <=len ; i++) {
            String head=str.substring(str.length()-2*i,str.length()-i);
            String tail=str.substring(str.length()-i);
            if(head.equals(tail))
                return false;
        }
        return true;
    }
}
