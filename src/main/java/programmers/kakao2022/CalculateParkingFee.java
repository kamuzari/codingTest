package programmers.kakao2022;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CalculateParkingFee {

    static final String IN = "IN";
    static final String OUT = "OUT";

    Map<String, Integer> parking = new LinkedHashMap<>();
    Map<String, Integer> results = new TreeMap<>();
    int defaultHour, defaultFee, unitHour, unitFee;

    public int[] solution(int[] fees, String[] records) {
        init(fees);
        for (String record : records) {
            String split[] = record.split(" ");
            String time = split[0];
            String carNumber = split[1];
            String status = split[2];
            if (status.equals(IN)) {
                parking.put(carNumber, toMinute(time));
            } else if (status.equals(OUT)) {
                int in = parking.get(carNumber);
                int out = toMinute(time);
                /*
                 * 1. 기본 시간(분인지)이하 인지 := 기본요금
                 * 2. 기본 시간 초과 인지 := 기본요금 + 기본시간을 뺀 나머지 시간 [올림 처리] * 단위 요금
                 */
                int diff = out - in;
                results.put(carNumber, results.getOrDefault(carNumber, 0) + diff);
                parking.remove(carNumber);
            }
        }
        // 소비 하고 비워줌
        for (String carNumber : parking.keySet()) {
            int in = parking.get(carNumber);
            int out = toMinute("23:59");
            int diff = out - in;
            results.put(carNumber, results.getOrDefault(carNumber, 0) + diff);
        }
        int[] answer = new int[results.size()];
        int idx = 0;
        for (String carNumber : results.keySet()) {
            answer[idx++] = calculateFee(results.get(carNumber));
        }
        return answer;
    }

    public int calculateFee(int diff) {
        int result = diff;
        if (result <= defaultHour) {
            return defaultFee;
        } else if (result > defaultHour) {
            int restTime = result - defaultHour;
            if (restTime % unitHour > 0) {
                return defaultFee + (restTime / unitHour + 1) * unitFee;
            }
            return defaultFee + (restTime / unitHour) * unitFee;
        }
        throw new RuntimeException("BUG");
    }

    public void init(int[] fees) {
        defaultHour = fees[0];
        defaultFee = fees[1];
        unitHour = fees[2];
        unitFee = fees[3];
    }

    public int toMinute(String time) {
        String split[] = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int minute = Integer.parseInt(split[1]);
        return hour + minute;
    }

}
