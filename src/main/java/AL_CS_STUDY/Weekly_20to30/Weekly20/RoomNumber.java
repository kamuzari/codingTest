package AL_CS_STUDY.Weekly_20to30.Weekly20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoomNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int min=50;
        int idx=-1;
        int [] bookstore=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bookstore[i]=Integer.parseInt(st.nextToken());
            if(min>=bookstore[i])
            {
                min=bookstore[i];
                idx=i;
            }
        }

        int money=Integer.parseInt(br.readLine());
        char [] digits=new char[51];
        int cnt=0;
        while (money>=min)
        {
            digits[cnt++]=(char)(idx+'0');
            money-=min;
        }
        int s=0;
        for (int i = 0; i < cnt; i++) {
            for (int j =n-1; j >=0 ; j--) {
                if(bookstore[j]<=money+min)
                {
                    digits[i]=(char)(j+'0');
                    money+=min-bookstore[j];
                    break;
                }
            }
            if(digits[s]=='0')
            {
                s++;
                money+=min;
            }
        }
        if(s==cnt)
        {
            System.out.println(0);
            return;
        }
        String answer=""    ;
        for (int i = s; i <cnt ; i++) {
            answer+=digits[i];
        }
        System.out.println(answer);

    }
}
