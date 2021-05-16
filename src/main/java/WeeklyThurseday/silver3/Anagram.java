package WeeklyThurseday.silver3;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        sc.nextLine();
        while (n-->0)
        {
            boolean flag=true;
            HashMap<Character,Integer> hashMap=new HashMap<>();
            String str[]=sc.nextLine().split(" ");
            for (String s : str) {
                for (int i = 0; i <s.length() ; i++) {
                    hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i),0)+1);
                }
            }
            for (Integer value : hashMap.values()) {
                if(value%2!=0)
                {
                    flag=false;
                    break;
                }
            }

            if(flag)
              sb.append(str[0]).append(" & ").append(str[1]).append(" are anagrams.\n");
            else
                sb.append(str[0]).append(" & ").append(str[1]).append(" are NOT anagrams.\n");
        }
        System.out.println(sb);

    }
}
