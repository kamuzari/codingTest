package AL_CS_STUDY.Weekly_30to40.Weekly36;

import java.util.Comparator;
import java.util.LinkedList;

public class MuzziEatingLive {
    class Food{
        int idx;
        int time;
        public Food(int idx,int time)
        {
            this.idx=idx;
            this.time=time;
        }

    }

    Comparator<Food> compTime=new Comparator<Food>(){
        public int compare(Food a,Food b)
        {
            return a.time-b.time;
        }
    };
    Comparator<Food> compIdx=new Comparator<Food>(){
        public int compare(Food a,Food b)
        {
            return a.idx-b.idx;
        }
    };

    public int solution(int[] food_times, long k) {
        int[] foodTimes=food_times;
        LinkedList<Food> foods=new LinkedList<>();
        int n=foodTimes.length;
        for(int i=0; i<n; i++)
        {
            foods.add(new Food(i+1,foodTimes[i]));
        }
        foods.sort(compTime);

        int pretime=0;
        int i=0;
        for(Food f: foods)
        {
            long hegihtDiff=f.time-pretime;
            if(hegihtDiff!=0)
            {
                long spend=hegihtDiff*n;
                if(spend<=k)
                {
                    k-=spend;
                    pretime=f.time;
                } else{
                    k%=n;
                    foods.subList(i,foodTimes.length).sort(compIdx);
                    return foods.get(i + (int)k).idx;
                }
            }
            i++;
            --n;
        }

        return -1;
    }
}
