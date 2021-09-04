package tues_thurs_sat._202104._20210408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
//https://www.acmicpc.net/problem/2922
public class JoyfulWords {
    static Map<Character, Integer> moum = new HashMap<>();
    static String req="";
    static int reqLen=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        req = br.readLine();
        reqLen= req.length();
        int consonant = 0; // 자음
        int collection = 0; // 모음
        int L=0;
        moum.put('A',0);
        moum.put('E',0);
        moum.put('I',0);
        moum.put('O',0);
        moum.put('U',0);

        long ans=pick(collection,consonant,L,0);
        System.out.println(ans);
    }

    public static long pick(int collection,int consonant, int L,int idx)
    {
        if(consonant>=3)
            return 0;
        if(collection>=3)
            return 0;
        if(idx==reqLen)
        {
            if(L==0)
                return 0;
            else
            {
                return 1;
            }
        }
        long ans=0;
        if(req.charAt(idx)!='_')
        {
            if(moum.containsKey(req.charAt(idx)))
            {
                ans=pick(collection+1,0,L,idx+1);
            }
            else
            {
                if(req.charAt(idx)=='L')
                    ans=pick(0,consonant+1,L+1,idx+1);
                else
                {
                    ans=pick(0,consonant+1,L,idx+1);
                }
            }
        }
        else
        {
            ans+=(20*pick(0,consonant+1,L,idx+1));

            ans+=(5*pick(collection+1,0,L,idx+1));

            ans+=pick(0,consonant+1,L+1,idx+1);
        }

        return ans;
    }
}
