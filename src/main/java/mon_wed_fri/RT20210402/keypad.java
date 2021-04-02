package mon_wed_fri.RT20210402;

import java.util.TreeMap;

public class keypad {
    public static void main(String[] args) {
        int a[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int b[] = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int c[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println(solution(a, "right"));
        System.out.println(solution(b, "left"));
        System.out.println(solution(c, "right"));

    }

    static TreeMap<Integer, int[]> treeMap = new TreeMap<>();

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        treeMap.put(1, new int[]{0, 0});
        treeMap.put(2, new int[]{0, 1});
        treeMap.put(3, new int[]{0, 2});
        treeMap.put(4, new int[]{1, 0});
        treeMap.put(5, new int[]{1, 1});
        treeMap.put(6, new int[]{1, 2});
        treeMap.put(7, new int[]{2, 0});
        treeMap.put(8, new int[]{2, 1});
        treeMap.put(9, new int[]{2, 2});
        treeMap.put(0, new int[]{3, 1});
        treeMap.put(-1,new int[]{3,0});
        treeMap.put(-2,new int[]{3,2});
        int previousL = -1;
        int previousR = -2;
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (x == 1 || x == 4 || x == 7) {
                answer += "L";
                previousL = x;
            } else if (x == 3 || x == 6 || x == 9) {
                answer += "R";
                previousR = x;
            } else {
                    int[] posit = treeMap.get(x);
                    int[] a = treeMap.get(previousL);
                    int[] b = treeMap.get(previousR);
                    int distA = Math.abs(posit[0] - a[0]) + Math.abs(posit[1] - a[1]);
                    int distB = Math.abs(posit[0] - b[0]) + Math.abs(posit[1] - b[1]);
                    if (distA > distB) {
                        previousR = x;
                        answer += "R";
                    } else if (distA < distB) {
                        answer += "L";
                        previousL = x;
                    } else {
                        if (hand.equals("right")) {
                            previousR = x;
                            answer += "R";
                        } else {
                            answer += "L";
                            previousL = x;
                        }
                    }
            }
        }
        return answer;
    }
}
// 1 4 7