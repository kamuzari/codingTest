package tues_thurs_sat._202110._20211005;

public class PGM49993_SkillTree {
    public static void main(String[] args) {
        PGM49993_SkillTree p = new PGM49993_SkillTree();
        System.out.println(p.solution("CBD",new String[]{
                "BACDE", "CBADF", "AECB", "BDA"
        }));
    }
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int n=skill.length();
        for(String str : skill_trees){
            int prevIdx=str.length();
            boolean flag=true;
            for(int i=n-1; i>=0; i--){
                char ch=skill.charAt(i);
                int pos=str.indexOf(ch);

                if(pos==-1){
                    continue;
                }else{
                    if(prevIdx>pos){
                        prevIdx=pos;
                    }else{
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}
