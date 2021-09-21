package tues_thurs_sat._202109._20210921;

import java.util.*;

public class PGM17685_AutoComplete {
    public static void main(String[] args) {
        final PGM17685_AutoComplete sol = new PGM17685_AutoComplete();
        sol.solution(new String[]{"go","gone","guild"});
    }

    Node root = new Node();

    class Node {
        private Map<Character, Node> childs = new HashMap<>();
        private int childCnt = 0;

        Node put(char ch) {
            childCnt++;
            if (!childs.containsKey(ch)) {
                childs.put(ch, new Node());
            }
            return childs.get(ch);
        }
    }

    public int solution(String[] words) {
        int answer = 0;
        for (String word : words) {
            insert(word);
        }
        return search(root,0);
    }


    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
             Node newNode = cur.put(word.charAt(i));
             cur=newNode;
        }
        cur.put('-');
    }

    static int search(Node root,int cnt){
        if(root.childCnt==1)
            return cnt;
        int count=0;
        for (Character key : root.childs.keySet()) {
            if(key=='-') {
                count += cnt;
            }else{
                count+=search(root.childs.get(key),cnt+1);
            }
        }
        return count;
    }
}
