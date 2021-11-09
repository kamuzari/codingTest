package Programmers.LV2;
import java.util.*;

public class PrimeSearch {
    static final int MAX=10_000_000;
    static boolean primes[]=new boolean[MAX];
    static int target,len;
    static int temp[];
    static String globalNumbers;
    static boolean v[];
    static Set<Integer> set=new HashSet<>();
    static int answer=0;
    public int solution(String numbers) {
        len=numbers.length();
        v=new boolean[len];
        globalNumbers=numbers;

        eratos();
        for(int i=1; i<=len; i++)
        {
            temp=new int[i];
            target=i;
            pick(0);
        }
        return set.size();
    }
    public void pick(int cnt)
    {
        if(cnt==target)
        {
            // System.out.println(Arrays.toString(temp));
            StringBuilder sb=new StringBuilder();
            for(int val:temp)
            {
                sb.append(val);
            }
            int idx=Integer.parseInt(sb.toString());
            if(primes[idx])
            {
                set.add(idx);
            }
            return;
        }

        for(int i=0; i<len; i++ )
        {
            if(!v[i])
            {
                v[i]=true;
                temp[cnt]=globalNumbers.charAt(i)-'0';
                pick(cnt+1);
                v[i]=false;
            }
        }

    }
    private void eratos()
    {
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int i=2; i*i<MAX; i++)
        {
            if(primes[i])
            {
                for(int j=i*i; j<MAX; j+=i)
                {
                    primes[j]=false;
                }
            }
        }
    }
}
