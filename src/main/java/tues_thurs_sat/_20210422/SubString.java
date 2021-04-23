package tues_thurs_sat._20210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubString {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String sub=br.readLine();
        //시간 초과 O(str길이 * sub 길이) ==100만 * 100만
        int i = str.indexOf(sub);
        if(i==-1)
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(1);
        }
    }
}
