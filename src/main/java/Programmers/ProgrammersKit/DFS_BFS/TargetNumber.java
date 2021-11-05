package Programmers.ProgrammersKit.DFS_BFS;

public class TargetNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1},3));
    }
    static int arr[];
    static int number;
    public static int solution(int[] numbers, int target) {
        arr=numbers;
        number=target;

        return dfs(0,0);
    }
    static int dfs(int cnt,int sum)
    {
        if(cnt==arr.length)
        {
            if(sum==number)
            {
                return 1;
            }
            return 0;
        }
        int a=dfs(cnt+1,sum+arr[cnt]);
        int b=dfs(cnt+1,sum-arr[cnt]);
        return a+b;
    }
}
