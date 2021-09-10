package AL_CS_STUDY.Weekly_30to40.Weekly37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LyricsSearch {

    private final int MAX_WORD_LEGNTH = 10_001;

    public static void main(String[] args) {
        String words[] = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String q[]=
        {
            "fro??", "????o", "fr???", "fro???", "pro?"
        } ;
        LyricsSearch lyricsSearch = new LyricsSearch();
        System.out.println(Arrays.toString(lyricsSearch.solution(words, q)));
    }

    List<List<String>> lyrics = new ArrayList<>(); // 가사 단어 길이 별 리스트
    List<List<String>> reverseLyrics = new ArrayList<>(); // **

    public int[] solution(String[] words, String[] queries) {
        int[] answers = new int[queries.length];

        for (int i = 0; i < MAX_WORD_LEGNTH; i++) {
            lyrics.add(new ArrayList<>());
            reverseLyrics.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            lyrics.get(word.length()).add(word);
            StringBuffer sb = new StringBuffer(word);
            String reverseWord = sb.reverse().toString();
            reverseLyrics.get(reverseWord.length()).add(reverseWord);
        }

        for (int i = 0; i < MAX_WORD_LEGNTH; i++) {
            Collections.sort(lyrics.get(i));
            Collections.sort(reverseLyrics.get(i));
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int result = 0;

            if (query.charAt(0) != '?') {
                String mostLeftWord = query.replaceAll("\\?", "a");
                String mostRightWord = query.replaceAll("\\?", "z");
                result = upperBound(lyrics.get(query.length()), mostRightWord)
                        - lowerBound(lyrics.get(query.length()), mostLeftWord);
            } else {
                String reverseWord = new StringBuffer(query).reverse().toString();
                String mostLeftWord = reverseWord.replaceAll("\\?", "a");
                String mostRightWord = reverseWord.replaceAll("\\?", "z");
                result = upperBound(reverseLyrics.get(reverseWord.length()), mostRightWord)
                        - lowerBound(reverseLyrics.get(reverseWord.length()), mostLeftWord);
            }

            answers[i] = result;
        }
        return answers;
    }

    private int lowerBound(List<String> lyricList, String mostLeftWord) {
        int s = 0;
        int e = lyricList.size();
        while (s < e) {
            int mid = (s + e) >> 1;
            if (lyricList.get(mid).compareTo(mostLeftWord) >= 0) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return e;
    }

    private int upperBound(List<String> lyricList, String mostRightWord) {
        int s = 0;
        int e = lyricList.size();
        while (s < e) {
            int mid = (s + e) >> 1;
            if (lyricList.get(mid).compareTo(mostRightWord) > 0) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return e;
    }
}
