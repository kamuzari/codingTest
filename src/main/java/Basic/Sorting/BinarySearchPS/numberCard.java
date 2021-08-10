package Basic.Sorting.BinarySearchPS;
// https://www.acmicpc.net/problem/10815

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class numberCard {

    private static int[] cards;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(target)).append(" ");
        }
        System.out.println(sb.toString());

    }

    static int binarySearch(int target) {
        int s = 0;
        int e = n-1;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (cards[mid] == target) {
                return 1;
            } else if (cards[mid] < target) {
                s = mid + 1;
            } else if (cards[mid] > target) {
                e = mid - 1;
            }
        }
        return 0;
    }
}
