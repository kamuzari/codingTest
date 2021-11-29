package Programmers.LV2;

import java.util.*;

public class FileNameSort {

    /*
       * 정렬순
         1. head(사전순),
         2. number(숫자형 변환 오름차순),
         3. tail(주어진 입력 순으로 정렬(조건 X))
       * 익명학숨 클래스
         - 문자열 (compare 메소드) 재정의
     */
    static final int HEAD = 0;
    static final int NUMBER = 1;
    static final int TAIL = 2;

    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1[] = divide(s1);
                String str2[] = divide(s2);
                int headDiff = str1[0].compareTo(str2[0]);
                if (headDiff == 0) {
                    int num1 = Integer.parseInt(str1[1]);
                    int num2 = Integer.parseInt(str2[1]);
                    return num1 - num2;
                } else {
                    return headDiff;
                }

            }

            /*
             * head, number, tail 분리.
             * @param fileName := 파일명
             * @return String[] := 헤드부분, 숫자부분, 꼬리부분
             */
            public String[] divide(String fileName) {
                StringBuilder head = new StringBuilder();
                StringBuilder number = new StringBuilder();
                StringBuilder tail = new StringBuilder();
                fileName = fileName.toLowerCase();
                int n = fileName.length();
                int flag = 0;
                int idx = 0;
                for (int i = 0; i < n; i++) {
                    char ch = fileName.charAt(i);
                    if (flag == HEAD) {
                        if (!Character.isDigit(ch)) {
                            head.append(ch);
                        } else {
                            flag = NUMBER;
                            i--;
                        }
                    } else if (flag == NUMBER) {
                        if (Character.isDigit(ch)) {
                            number.append(ch);
                        } else {
                            flag = TAIL;
                            i--;
                        }
                    } else if (flag == TAIL) {
                        tail.append(ch);
                    }
                }
                return new String[]{head.toString(), number.toString(), tail.toString()};
            }
        });
        return files;
    }
}
