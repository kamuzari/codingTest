package WeeklyThuseday._0610;

import java.util.Arrays;
import java.util.Comparator;

public class FileNameSorting {
    public static void main(String[] args) {
        String[] solution = solution(new String[]{
                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
        });
        System.out.println(solution);
    }
    public static  String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] one=divide(o1);
                String[] two=divide(o2);
                int head=one[0].compareTo(two[0]);
                if(head==0)
                {
                    int oneInt = Integer.parseInt(one[1]);
                    int twoInt = Integer.parseInt(two[1]);

                    return oneInt-twoInt;
                }
                return head;
            }


            private String[] divide(String str)
            {
                String head="";
                String number="";
                String tail="";
                int idx=0;
                for (int i = idx; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if(Character.isDigit(ch))
                        break;
                    head+=ch;
                    idx++;
                }

                for (int i = idx; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if(!Character.isDigit(ch))
                        break;
                    number+=ch;
                    idx++;
                }

                tail=str.substring(idx);
                String file[]={head.toLowerCase(),number,tail};
                return file;
            }
        });
        return files;
    }
}
