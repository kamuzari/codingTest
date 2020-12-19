package AlgorithmFoundation.Knapsack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Item {
    float weight;
    int profit;
    int idx;
    public Item() {}
    public Item(int value, float weight,
                int idx)
    {
        this.profit = value;
        this.weight = weight;
        this.idx = idx;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + profit +
                ", idx=" + idx +
                '}';
    }
}

class Node {
    float ub;
    float lb;
    int level; // node level
    boolean flag;
    float totalValue;
    float totalWeight;
    public Node() {}
    public Node(Node cpy)
    {
        this.totalValue = cpy.totalValue;
        this.totalWeight = cpy.totalWeight;
        this.ub = cpy.ub;
        this.lb = cpy.lb;
        this.level = cpy.level;
        this.flag = cpy.flag;
    }
}

class sortByC implements Comparator<Node> {
    public int compare(Node a, Node b)
    {
        boolean temp = a.lb > b.lb;
        return temp ? 1 : -1;
    }
}

class sortByRatio implements Comparator<Item> {
    public int compare(Item a, Item b)
    {
        boolean temp = (float)a.profit
                / a.weight
                > (float)b.profit
                / b.weight;
        return temp ? -1 : 1;
    }
}

public class BranchOfBound {

    private static int N;
    private static float Weight;

    static float upperBound(float totalValue, float totalWeight,
                            int idx, Item arr[])
    {
        float value = totalValue;
        float weight = totalWeight;
        for (int i = idx; i < N; i++) {
            if (weight + arr[i].weight
                    <= Weight) {
                weight += arr[i].weight;
                value -= arr[i].profit;
            }
            else {
                value -= (float)(Weight
                        - weight)
                        / arr[i].weight
                        * arr[i].profit;
                break;
            }
        }
        return value;
    }

    static float lowerBound(float totalValue, float totalWeight,
                            int index, Item arr[])
    {
        float value = totalValue;
        float weight = totalWeight;
        for (int i = index; i < N; i++) {
            if (weight + arr[i].weight
                    <= Weight) {
                weight += arr[i].weight;
                value -= arr[i].profit;
            }
            else {
                break;
            }
        }
        return value;
    }

    static void assign(Node a, float ubound, float lowerb,
                       int level, boolean flag,
                       float totalValue, float totalWeight)
    {
        a.lb = lowerb;
        a.level = level;
        a.flag = flag;
        a.totalValue = totalValue;
        a.totalWeight = totalWeight;
    }

    public static void Knapsack(Item arr[])
    {
        Arrays.sort(arr, new sortByRatio());

        Node current, left, right;
        current = new Node();
        left = new Node();
        right = new Node();

        float minLB = 0;
        float finalLB = Integer.MAX_VALUE;

        current.totalValue = current.totalWeight = current.ub
                = current.lb = 0;
        current.level = 0;
        current.flag = false;

        PriorityQueue<Node> pq
                = new PriorityQueue<Node>(
                new sortByC());

        pq.add(current);

        boolean currPath[] = new boolean[N];
        boolean Path[] = new boolean[N];

        while (!pq.isEmpty()) {
            current = pq.poll();
            if (current.ub > minLB
                    || current.ub >= finalLB) {
                continue;
            }

            if (current.level != 0)
                currPath[current.level - 1]
                        = current.flag;

            if (current.level == N) {
                if (current.lb < finalLB) {
                    // Reached last level
                    for (int i = 0; i < N; i++)
                        Path[arr[i].idx]
                                = currPath[i];
                    finalLB = current.lb;
                }
                continue;
            }

            int level = current.level;

            assign(right, upperBound(current.totalValue,
                    current.totalWeight,
                    level + 1, arr),
                    lowerBound(current.totalValue, current.totalWeight,
                            level + 1, arr),
                    level + 1, false,
                    current.totalValue, current.totalWeight);

            if (current.totalWeight + arr[current.level].weight
                    <= Weight) {

                left.ub = upperBound(
                        current.totalValue
                                - arr[level].profit,
                        current.totalWeight
                                + arr[level].weight,
                        level + 1, arr);
                left.lb = lowerBound(
                        current.totalValue
                                - arr[level].profit,
                        current.totalWeight
                                + arr[level].weight,
                        level + 1,
                        arr);
                assign(left, left.ub, left.lb,
                        level + 1, true,
                        current.totalValue - arr[level].profit,
                        current.totalWeight
                                + arr[level].weight);
            }

            else {

                left.ub = left.lb = 1;
            }

            minLB = Math.min(minLB, left.lb);
            minLB = Math.min(minLB, right.lb);

            if (minLB >= left.ub)
                pq.add(new Node(left));
            if (minLB >= right.ub)
                pq.add(new Node(right));
        }
        System.out.println("최적 아이템들의 정보");
        for (int i = 0; i < N; i++) {
                System.out.println(arr[i].toString());
        }
        System.out.println("Max Profit "+ (-finalLB));
    }

    // Driver code
    public static void main(String args[])
    {
        N = 4;
        Weight = 15;

        Item arr[] = new Item[N];
        arr[0] = new Item(10, 2, 0);
        arr[1] = new Item(10, 4, 1);
        arr[2] = new Item(12, 6, 2);
        arr[3] = new Item(18, 9, 3);

        Knapsack(arr);
    }
}