package AlgorithmFoundation.Travel_SalesPerson;

import java.util.*;

public class TSR_Branch_of_Bound
{
    static int N = 4;

    static int optTour[] = new int[N + 1];

    static boolean visited[] = new boolean[N];

    static int res = Integer.MAX_VALUE;

    static void totalPath(int path[])
    {
        for (int i = 0; i < N; i++)
            optTour[i] = path[i];
        optTour[N] = path[0];
    }

    static int firstMin(int adj[][], int i)
    {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < N; k++)
            if (adj[i][k] < min && i != k)
                min = adj[i][k];
        return min;
    }

    static int secondMin(int adj[][], int i)
    {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int j=0; j<N; j++)
        {
            if (i == j)
                continue;

            if (adj[i][j] <= first)
            {
                second = first;
                first = adj[i][j];
            }
            else if (adj[i][j] <= second &&
                    adj[i][j] != first)
                second = adj[i][j];
        }
        return second;
    }

    static void Travel(int adj[][], int curr_bound, int curr_weight,
                       int level, int curr_path[])
    {
        if (level == N)
        {
            if (adj[curr_path[level - 1]][curr_path[0]] != 0)
            {
                int curr_res = curr_weight +
                        adj[curr_path[level-1]][curr_path[0]];

                if (curr_res < res)
                {
                    totalPath(curr_path);
                    res = curr_res;
                }
            }
            return;
        }

        for (int i = 0; i < N; i++)
        {
            if (adj[curr_path[level-1]][i] != 0 &&
                    visited[i] == false)
            {
                int temp = curr_bound;
                curr_weight += adj[curr_path[level - 1]][i];

                if (level==1)
                    curr_bound -= ((firstMin(adj, curr_path[level - 1]) +
                            firstMin(adj, i))/2);
                else
                    curr_bound -= ((secondMin(adj, curr_path[level - 1]) +
                            firstMin(adj, i))/2);

                if (curr_bound + curr_weight < res)
                {
                    curr_path[level] = i;
                    visited[i] = true;

                    Travel(adj, curr_bound, curr_weight, level + 1,
                            curr_path);
                }

                curr_weight -= adj[curr_path[level-1]][i];
                curr_bound = temp;

                Arrays.fill(visited,false);
                for (int j = 0; j <= level - 1; j++)
                    visited[curr_path[j]] = true;
            }
        }
    }

    static void TSP(int adj[][])
    {
        int path[] = new int[N + 1];

        int bound = 0;
        Arrays.fill(path, -1);
        Arrays.fill(visited, false);

        for (int i = 0; i < N; i++)
            bound += (firstMin(adj, i) +
                    secondMin(adj, i));

        bound = (bound==1)? bound/2 + 1 :
                bound/2;

        visited[0] = true;
        path[0] = 0;

        Travel(adj, bound, 0, 1, path);
    }

    public static void main(String[] args)
    {
        int adj[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}    };

        /*for (int i = 0; i < W.length; ++i) {
            for (int j = 0; j < W[i].length; ++j) {
                adj[i][j] = Math.abs(new Random().nextInt()) + 1;
            }
        }*/

        TSP(adj);

        System.out.print("Path : ");
        for (int i = 0; i <= N; i++)
        {
            System.out.print(optTour[i]+" ");
        }
    }
} 