package ProgrammersKit.Dev_Mathching;
import java.util.*;
public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0; i<win_nums.length; i++)
        {
            int key=win_nums[i];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        // System.out.println(map);
        for(int i=0; i<lottos.length; i++)
        {
            int key=lottos[i];
            map.put(key,map.getOrDefault(key,0)-1);
        }
        int max=0;
        int min=0;
        int cnt=0;
        if(map.containsKey(0))
        {
            max=Math.abs(map.get(0));
        }
        for(Integer key : map.keySet())
        {
            if(map.get(key)==0)
            {
                cnt++;
            }
        }
        max+=cnt;
        min+=cnt;
        // System.out.println(map);
        max=rank(max);
        min=rank(min);
        return new int[]{max,min};
    }
    static int rank(int a)
    {
        if(a==0)
        {
            return 6;
        }
        else
        {
            return 7-a;
        }
    }
}
