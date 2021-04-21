package tues_thurs_sat._20210421;

import java.util.Arrays;
import java.util.Comparator;

public class FilenameSorting {
    public static void main(String[] args) {
        String files[] = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(solution(files));
    }

    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String a[] = divide(s1);
                String b[] = divide(s2);

                int head = a[0].compareTo(b[0]);
                if (head == 0) {
                    return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
                } else {
                    return head;
                }
            }

            private String[] divide(String str) {
                String head = "";
                String number = "";
                String tail = "";

                int idx = 0;
                for (; idx < str.length(); ++idx) {
                    char ch = str.charAt(idx);
                    if (Character.isLetter(ch)) {
                        head += ch;
                    }
                    else
                        break;
                }

                for (; idx < str.length(); ++idx) {
                    char ch = str.charAt(idx);
                    if (ch>='0' && ch<='9')
                    {
                        number += ch;
                    }
                    else
                        break;
                }

                for (; idx < str.length(); ++idx) {
                    char ch = str.charAt(idx);
                    tail += ch;
                }

                String[] file = {head.toLowerCase(), number, tail};

                return file;
            }
        });
        return files;
    }

}
