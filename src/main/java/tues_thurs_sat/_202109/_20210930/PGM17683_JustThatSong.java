package tues_thurs_sat._202109._20210930;

public class PGM17683_JustThatSong {
    public static void main(String[] args) {
        PGM17683_JustThatSong p = new PGM17683_JustThatSong();
        p.solution("ABCDEFG",new String[]{
                "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"
        });
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = pretreatment(m);
        int maxExeTime=-1;
        for (String str : musicinfos) {
            String[] split = str.split(",");
            String t1 = split[0];
            String t2 = split[1];
            String title = split[2];
            String info = pretreatment(split[3]);

            String[] hourAndMinute = t1.split(":");
            int start=Integer.parseInt(hourAndMinute[0])*60+Integer.parseInt(hourAndMinute[1]);
            String[] hourAndMinute2 = t2.split(":");
            int end=Integer.parseInt(hourAndMinute2[0])*60+Integer.parseInt(hourAndMinute2[1]);
            int exeTime=end-start;
            if(exeTime>info.length()){
                StringBuffer newInfo=new StringBuffer();
                for (int i = 0; i <exeTime/info.length(); i++) {
                    newInfo.append(info);
                }
                newInfo.append(info.substring(0,exeTime%info.length()));
                info=newInfo.toString();
            }else{
                info = info.substring(0, exeTime);
            }

            if(info.contains(m) && exeTime>maxExeTime){
                answer=title;
                maxExeTime=exeTime;
            }
        }
        return maxExeTime==-1 ?   "(None)":answer ;
    }

    private String pretreatment(String str) {
        str = str.replaceAll("A#", "H");
        str = str.replaceAll("C#", "I");
        str = str.replaceAll("D#", "J");
        str = str.replaceAll("F#", "K");
        str = str.replaceAll("G#", "L");
        return str;
    }
}
