package AL_CS_STUDY.Weekly_20to30.Weekly22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        while (n-->0)
        {
            int state=0;
            String s=br.readLine()  ;
            for (int i = 0; i < s.length(); i++) {
                char ch=s.charAt(i);
                state=State(state,ch);

                if(state==-1)
                    break;
            }
            if(state==0 || state==2 || state==6 || state==7)
            {
                sb.append("YES");
            }
            else
            {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static int State(int state, char ch) {
        if(ch=='0')
        {
            switch (state)
            {
                case 0:
                    return 1;
                case 2:
                    return 1;
                case 3:
                    return 4;
                case 4:
                    return 5;
                case 5:
                    return 5;
                case 6:
                    return 1;
                case 7:
                    return 8;
                case 8:
                    return 5;
            }
        }
        if(ch=='1')
        {
            switch (state)
            {
                case 0:
                    return 3;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 5:
                    return 6;
                case 6:
                    return 7;
                case 7:
                    return 7;
                case 8:
                    return 0;
            }
        }

        return -1;
    }
}
