package baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NumberBinding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        PriorityQueue<Integer> positives = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negatives = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(sc.nextLine());
            if (number <= 0) {
                negatives.add(number);
            } else {
                positives.add(number);
            }
        }

        int postiveMultipleSum = 0;
        while (positives.size() >= 2) {
            if (positives.peek() == 1) {
                break;
            }
            int a = positives.poll();

            if (positives.peek() == 1) {
                positives.add(a);
                break;
            }
            int b = positives.poll();
            postiveMultipleSum += (a * b);
        }

        while (!positives.isEmpty()) {
            postiveMultipleSum += positives.poll();
        }

        int negativeMultipleSum = 0;
        while (negatives.size() >= 2) {

            int a = negatives.poll();
            int b = negatives.poll();
            negativeMultipleSum += (a * b);
        }

        while (!negatives.isEmpty()) {
            negativeMultipleSum += negatives.poll();
        }

        int answer = postiveMultipleSum + negativeMultipleSum;
        System.out.println(answer);
    }
}
