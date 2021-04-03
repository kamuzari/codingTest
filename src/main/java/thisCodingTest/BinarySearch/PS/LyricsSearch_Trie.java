package thisCodingTest.BinarySearch.PS;

import java.util.Arrays;

public class LyricsSearch_Trie {
    public static void main(String[] args) {
        String word[] = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String q[] = {"pro?","????o", "fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(solution(word, q)));
    }

    public static int[] solution(String[] words, String[] queries) {
        TrieNode[] trie=new TrieNode[10001];
        TrieNode[] Rtrie=new TrieNode[10001];

        for (String word : words) {
            int len=word.length();
            if(trie[len]==null) {
                trie[len]=new TrieNode();
            }
            trie[len].insert(word.toCharArray());

            word=(new StringBuffer(word)).reverse().toString();
            if(Rtrie[len]==null)
            {
                Rtrie[len]=new TrieNode();
            }
            Rtrie[len].insert(word.toCharArray());
        }
        int ans[]=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q=queries[i];
            if(q.indexOf('?')==0) //prefix
            {

                q=(new StringBuffer(q)).reverse().toString();
                if(Rtrie[q.length()]==null)
                    ans[i]=0;
                else
                    ans[i]= Rtrie[q.length()].search(q.toCharArray());
            }
            else
            {
                if(trie[q.length()]==null)
                    ans[i]=0;
                else
                    ans[i]= trie[q.length()].search(q.toCharArray());
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
class TrieNode{
    int cnt;
    TrieNode child[];

    public TrieNode() {
        cnt=0;
        child=new TrieNode[26];
    }
  public void insert(char[] word)
  {
      TrieNode cur=this;
      for (char c : word) {
          cur.cnt++;
          if(cur.child[c-'a']!=null)
          {
              cur=cur.child[c-'a'];
          }
          else
          {
              cur.child[c-'a']=new TrieNode();
              cur=cur.child[c-'a'];
          }
      }
  }

  public int search(char[] query)
  {
      TrieNode cur=this;
      for (char q : query) {
          if(q=='?')
          {
              return cur.cnt;
          }
          if(cur.child[q-'a']!=null)
          {
              cur=cur.child[q-'a'];
          }
          else
          {
              return 0;
          }
      }
      return cur.cnt;
  }
}
