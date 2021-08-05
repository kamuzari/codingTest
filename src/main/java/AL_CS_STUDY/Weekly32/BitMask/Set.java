package AL_CS_STUDY.Weekly32.BitMask;

import java.io.*;
public class Set {
    static final String ADD="add";
    static final String REMOVE ="remove";
    static final String CHECK="check";
    static final String TOGGLE="toggle";
    static final String ALL="all";
    static final String EMPTY="empty";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        int bit=0;
        while (n-->0)
        {
            String str[]=br.readLine().split(" ");
            int number;
            if(str[0].equals(ADD))
            {
                number=Integer.parseInt(str[1]);
                bit|=(1<<(number-1));
            }
            else if(str[0].equals(REMOVE))
            {
                number=Integer.parseInt(str[1]);
                bit=bit & ~(1<<(number-1));
            }
            else if(str[0].equals(CHECK))
            {
                number=Integer.parseInt(str[1]);
                sb.append((bit&(1<<(number-1))) == 0 ? 0:1).append("\n");
            }
            else if(str[0].equals(TOGGLE))
            {
                number=Integer.parseInt(str[1]);
                bit^=(1<<(number-1));
            }
            else if(str[0].equals(ALL))
            {
                bit|=(~0);
            }
            else if(str[0].equals(EMPTY))
            {
                bit&=0;
            }
        }
        System.out.println(sb);
    }
}
