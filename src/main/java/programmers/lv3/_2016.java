package programmers.lv3;

public class _2016 {
    /**
     * a월 b일은? 몇요일인가?
     * logic : 들어온 a달 만큼 day 를 추가하고 %7 모듈러 연산을 하고 해당 나머지 값으로 1월 1일 금요일 부터 count 진행
     */
    static int months[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String days[] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public String solution(int a, int b) {
        String answer = "";
        int currentDayIndex = 4;
        int totalDay = b - 1;
        for (int month = 1; month < a; month++) {
            totalDay += months[month - 1];
        }
        totalDay %= 7;
        for (int cnt = 1; cnt <= totalDay; cnt++) {
            currentDayIndex = (currentDayIndex + 1) % 7;
        }
        return days[currentDayIndex];
    }
}
