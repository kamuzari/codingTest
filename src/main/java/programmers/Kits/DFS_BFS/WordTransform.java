package programmers.Kits.DFS_BFS;

public class WordTransform {
    public static void main(String[] args) {
        String s[]={
                "hot", "dot", "dog", "lot", "log", "cog"
        };
        String start="hit";
        String end="cog";
        System.out.println(solution(start,end,s));
    }
    static String original;
    static String targetWord;
    static String [] wordlist;
    static boolean v[];
    static int answer;
    public static int solution(String begin, String target, String[] words) {
        original=begin;
        targetWord=target;
        wordlist=words;
        v=new boolean[words.length];
        answer=Integer.MAX_VALUE;
        pick(begin,0);
        if(answer==Integer.MAX_VALUE)
            return 0;
        return answer;
    }
    public static void pick(String cur,int cnt)
    {
        if(cur.equals(targetWord))
        {
            answer=Math.min(answer,cnt);
            return;
        }
        for (int i = 0; i < wordlist.length; i++) {
            if(!v[i] && check(cur,wordlist[i]))
            {
                v[i]=true;
                pick(wordlist[i],cnt+1);
                v[i]=false;
            }
        }
    }

    private static boolean check(String cur, String s) {
        int cnt=0;
        for (int i = 0; i < s.length(); i++) {
            if(cur.charAt(i)!=s.charAt(i))
            {
                cnt++;
            }
            if(cnt>1)
            {
                return false;
            }
        }
        return true;
    }

}
