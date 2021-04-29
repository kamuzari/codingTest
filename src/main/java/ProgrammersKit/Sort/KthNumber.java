package ProgrammersKit.Sort;

import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args) {
        int arr[]={1,5,2,6,3,7,4};
        int cmd[][]={
                {2,5,3},
                {4,4,1},
                {1,7,3}
        };
        System.out.println(Arrays.toString(solution(arr,cmd)));;
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i <commands.length ; i++) {
            int arr[]=array.clone();
            Arrays.sort(arr,commands[i][0]-1,commands[i][1]);
            System.out.println(Arrays.toString(arr));
            System.out.println(commands[i][0]-1+commands[i][2]-1);
            answer[i]=arr[commands[i][0]-1+commands[i][2]-1];
        }
        return answer;
    }

}
