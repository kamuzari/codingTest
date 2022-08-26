package programmers.lv2.Stamina;

public class Stamina {
    // 애매모호 회의실 배정이랑 비슷해 보인다.. 무엇을 돌아야할지 모르겠음. 8이니깐 완전 탙색 8!
    int n;
    int temp[];
    int dun[][];
    int answer=0;
    int curHP=0;
    boolean v[];
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        curHP=k;
        n=dungeons.length;
        v=new boolean[n];
        temp=new int[n];
        dun=dungeons;
        pick(0,n);
        return answer;
    }
    public void pick(int cnt,int target){
        if(target==cnt){
            int HP=curHP;
            int count=0;
            for(int stage : temp){
                int needHP=dun[stage][0];
                if(needHP>HP) continue;
                if(HP-dun[stage][1]<0) continue;
                HP-=dun[stage][1];
                count++;
            }
            answer=Math.max(count,answer);
            return;
        }
        for(int i=0; i<n; i++){
            if(!v[i]){
                v[i]=true;
                temp[cnt]=i;
                pick(cnt+1,target);
                v[i]=false;
            }
        }
    }
}
