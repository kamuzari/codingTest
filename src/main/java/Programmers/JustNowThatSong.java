package Programmers;

public class JustNowThatSong {
    /*
     * C,D,F,G,A 문자에는 #이 있다. ABC 를 찾는데 "ABC#" indexOf API를 통해 찾게 되면 찾는 가사가        아니다. :=  indexOf API 를 통해 시작위치를 찾고 문자열 길이만큼 더해서 마지막 문자 뒤에 #이          붙어있다면 가사가 아니다라고 판별하면 될 것 같음.
      놓친 부분 :=  C#, F# 등등은 하나의 음이다.
      🎊 C#F#C# -> 악보의 길이 == 3으로 계산을 해야한다.
     */
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime = 0;
        String memory = replaceMelody(m);
        for (int i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(",");
            int startTime = toSeconds(split[0]);
            int endTime = toSeconds(split[1]);
            int playTime = endTime - startTime;
            String title = split[2];
            String melody = replaceMelody(split[3]);
            String totalMelody = extractedMelody(playTime, melody);
            int idx = totalMelody.indexOf(memory);
            if (idx == -1) {
                continue;
            }
            if (maxPlayTime < playTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }
        if (answer.equals("")) {
            return "(None)";
        } else {
            return answer;
        }
    }

    public String replaceMelody(String molody) {
        molody = molody.replace("C#", "H");
        molody = molody.replace("D#", "I");
        molody = molody.replace("F#", "J");
        molody = molody.replace("G#", "K");
        molody = molody.replace("A#", "L");
        return molody;
    }

    public String extractedMelody(int playTime, String melody) {
        StringBuilder totalMelody = new StringBuilder();
        int melodyLength = melody.length();
        for (int i = 0; i < playTime; i++) {
            totalMelody.append(melody.charAt(i % melodyLength));
        }
        return totalMelody.toString();
    }

    public int toSeconds(String time) {
        String[] splitStr = time.split(":");
        int hour = Integer.parseInt(splitStr[0]);
        int minute = Integer.parseInt(splitStr[1]);
        return hour * 60 + minute;
    }
}
