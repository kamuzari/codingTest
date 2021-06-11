package WeeklyThuseday._0610;

public class DiffBit {
    public static void main(String[] args) {

    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            if (number % 2 == 0) {
                answer[i] = number + 1;
            } else {
                String binary = Long.toBinaryString(number);
                int tailZero = binary.lastIndexOf("0");
                int headOne = binary.indexOf("1", tailZero);
                if (tailZero == -1) {
                    number++;
                    binary = Long.toBinaryString(number);
                    binary = binary.substring(0, 2) + binary.substring(2).replace("0", "1");
                } else {
                    binary = binary.substring(0, tailZero) + "1" +
                            binary.substring(tailZero + 1, headOne) + "0" +
                            binary.substring(headOne + 1);
                }

                answer[i] = Long.parseLong(binary, 2);
            }
        }
        return answer;
    }
}
