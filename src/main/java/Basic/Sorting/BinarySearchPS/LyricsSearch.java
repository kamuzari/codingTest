package Basic.Sorting.BinarySearchPS;

import java.util.ArrayList;
import java.util.Collections;

public class LyricsSearch {


    public static void main(String[] args) {
        solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
    }

    static ArrayList<ArrayList<String>> list = new ArrayList<>();
    static ArrayList<ArrayList<String>> reverseList = new ArrayList<>();

    public static int[] solution(String[] words, String[] queries) {
        int answer[] = null;
        for (int i = 0; i < 10001; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            list.get(word.length()).add(word);
            StringBuilder sb = new StringBuilder();
            word = sb.append(word).reverse().toString();
            reverseList.get(word.length()).add(word);
        }

        for (int i = 1; i < 10001; i++) {
            Collections.sort(list.get(i));
            Collections.sort(reverseList.get(i));
        }
        ArrayList<Integer> predicateAnswer = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int result = 0;

            if (query.charAt(0) != '?') {
                String leftValue = query.replaceAll("\\?", "a");
                String rightValue = query.replaceAll("\\?", "z");

                result = upperBound(list.get(query.length()), rightValue) - lowerBound(list.get(query.length()), leftValue);
            } else {
               StringBuilder sb = new StringBuilder();
                String reverseQuery = sb.append(query).reverse().toString();
                String leftValue = reverseQuery.replaceAll("\\?", "a");
                String rightValue = reverseQuery.replaceAll("\\?", "z");
                result = upperBound(reverseList.get(query.length()), rightValue) - lowerBound(reverseList.get(query.length()), leftValue);
            }
            predicateAnswer.add(result);
        }
        System.out.println(predicateAnswer);
        return answer;
    }

    static int lowerBound(ArrayList<String> stringArrayList, String target) {
        int start = 0;
        int end = stringArrayList.size();
        while (start < end) {
            int mid = (start + end) / 2;

            if (stringArrayList.get(mid).compareTo(target) >= 0) // 사전순 뒤쪽.
            {
                end = mid;
            } else if (stringArrayList.get(mid).compareTo(target) < 0) {
                start = mid + 1;
            }
        }
        return end;
    }

    static int upperBound(ArrayList<String> stringArrayList, String target) {
        int start = 0;
        int end = stringArrayList.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (stringArrayList.get(mid).compareTo(target) > 0) {
                end = mid;
            } else if (stringArrayList.get(mid).compareTo(target) <= 0) {
                start = mid + 1;
            }

        }
        return end;
    }
}
