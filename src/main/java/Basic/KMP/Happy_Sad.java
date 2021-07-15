package Basic.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Happy_Sad {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String sentence=br.readLine();
        int length = sentence.length();
        String happy=":-)";
        int happyCnt=0;
        String sad=":-(";
        int sadCnt=0;
        int start=0;
        for (int i = 0; i <length ; i++) {
            int idx = sentence.indexOf(happy,start);
            if(idx==-1)
                break;
            happyCnt++;
            start=idx+1;
        }
        start=0;
        for (int i = 0; i <length ; i++) {
            int idx = sentence.indexOf(sad,start);
            if(idx==-1)
                break;
            sadCnt++;
            start=idx+1;
        }
        if(happyCnt==0 && sadCnt==0)
            System.out.println("none");
        else if(happyCnt==sadCnt)
            System.out.println("unsure");
        else if(happyCnt>sadCnt)
            System.out.println("happy");
        else if(happyCnt<sadCnt)
            System.out.println("sad");




    }
}
