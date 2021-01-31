package Thur_Sunday_aWeek_Al.StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class amazingString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new LinkedHashSet<>();
        String str="";
        while (!( str=br.readLine()).equals("*") ) {
            System.out.print(str+" ");
            boolean flag = true;
            for (int i = 1; i < str.length(); i++) {
                set.clear();
                for (int j = 0; j < str.length()-i; j++) {
                    String temp = "" + str.charAt(j) + str.charAt(j + i);
                        if (!set.contains(temp)) {
                            set.add(temp);
                        } else {
                            flag = false;
                            break;
                        }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                System.out.println("is surprising.");
            }
            else if(!flag)
                System.out.println("is NOT surprising.");
        }
    }
}
