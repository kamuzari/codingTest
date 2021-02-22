package oneDay_twoSol.Greedy2.InBook.Deepening;

import java.util.*;

public class muzziEatingRoom_Live {
    public static void main(String[] args) {
        int fT[] = {3, 1, 2};
        int k = 5;
        solution(fT, k);
    }

    static class food {
        int index, time;

        @Override
        public String toString() {
            return "food{" +
                    "index=" + index +
                    ", time=" + time +
                    '}';
        }

        public food(int index, int time) {
            this.index = index;
            this.time = time;
        }

    }

    public static int solution(int[] food_times, long k) {
        List<food> foodList = new LinkedList<>();
        int n = food_times.length;
        for (int i = 0; i < n; i++) {
            foodList.add(new food(i + 1, food_times[i]));
        }
        foodList.sort((o1, o2) -> o1.time - o2.time);
        int preTime = 0;
        int i = 0;
        for (food food : foodList) {
            long diff = food.time - preTime;
            if (diff != 0) {
                long spend = diff * n;
                if (spend <= k) {
                    k -= spend;
                    preTime = food.time;
                } else {
                    k %= n;
                    foodList.subList(i,food_times.length).sort((o1, o2) -> o1.index - o2.index);
                    return foodList.get(i+(int)k).index;
                }
            }
            i++;
            n--;
        }
        return -1;
    }
}
