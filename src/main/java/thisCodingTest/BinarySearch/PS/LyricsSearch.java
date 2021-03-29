package thisCodingTest.BinarySearch.PS;

import java.util.*;

public class LyricsSearch {
    public static void main(String[] args) {
        String word[]={"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String q[]={"????o","fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(solution(word,q)));
    }

    static ArrayList<ArrayList<String>> arr = new ArrayList<>();
    static ArrayList<ArrayList<String>> revArr = new ArrayList<>();

    public static int[] solution(String[] words, String[] queries) {
        ArrayList<Integer> result=new ArrayList<>();
        // 가사에 담긴 단어 , 찾고자 하는 단어(중복 될 수 있음 -> 메모이 제이션? queries 에 담겨서 나오는 수들을 맵으로 관리)

        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<>());
            revArr.add(new ArrayList<>());
        }
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            arr.get(w.length()).add(w);
            w = (new StringBuffer(w)).reverse().toString();
            revArr.get(w.length()).add(w);
        }
        for (int i = 0; i < 10001; i++) {
            Collections.sort(arr.get(i));
            Collections.sort(revArr.get(i));
        }

        for (int i = 0; i < queries.length; i++) {
            String w = queries[i];
            int ans = 0;
            if (w.charAt(0) != '?') {
                // 접미사인 경우
                ans = range(arr.get(w.length()), w.replaceAll("\\?", "a"), w.replaceAll("\\?", "z"));
            } else {
                w = (new StringBuffer(w)).reverse().toString();
                ans = range(revArr.get(w.length()), w.replaceAll("\\?", "a"), w.replaceAll("\\?", "z"));
            }
            result.add(ans);
        }
        int []answer=new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i]=result.get(i);
        }
        result.clear();

        return answer;
    }

    static int range(ArrayList<String> searchKeyword, String left, String right) {
        int r=upperBound(searchKeyword,0,searchKeyword.size()-1,right);
        int l=upperBound(searchKeyword,0,searchKeyword.size()-1,left);
        return r-l;
    }

    static int upperBound(ArrayList<String> arr, int s, int e, String target) {
        while (s<=e)
        {
            int mid=(s+e)/2;
            if(arr.get(mid).compareTo(target)>0)
                e=mid-1;
            else
                s=mid+1;
        }
        return e;
    }

    static int lowerBound(ArrayList<String> arr, int s, int e, String target) {
        while (s<=e)
        {
            int mid=(s+e)/2;
            if(arr.get(mid).compareTo(target)>=0)
                e=mid-1;
            else
                s=mid+1;
        }
        return e;
    }
}
