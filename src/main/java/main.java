import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class main {
    static HashMap<Integer,Integer> mapY;
    static HashMap<Integer,Integer> mapX;
    public static void main(String[] args) {
        int a[][]={
                {1,2},
                {3,4},
                {3,10},
        };
        solution(a);
        int b[][]={
                {1,1},
                {2,2},
                {1,2}
        };
        solution(b);
    }
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        mapX=new HashMap<>();
        mapY=new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                int a=v[i][j];
               if(j==0)
               {
                   if(!mapX.containsKey(a))
                   {
                       mapX.put(a,1);
                   }
                   else
                   {
                       mapX.put(a,mapX.getOrDefault(a,0)+1);
                   }
               }
               else{
                   if(!mapY.containsKey(a))
                   {
                       mapY.put(a,1);
                   }
                   else
                   {
                       mapY.put(a,mapY.getOrDefault(a,0)+1);
                   }
               }
            }
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : mapX.entrySet()) {
            if(integerIntegerEntry.getValue()!=2)
            {
                answer[0]=integerIntegerEntry.getKey();
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : mapY.entrySet()) {
            if(integerIntegerEntry.getValue()!=2)
            {
                answer[1]=integerIntegerEntry.getKey();
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
