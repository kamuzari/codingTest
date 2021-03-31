package mon_wed_fri.RT20210329;

public class JadenCase {
    public static void main(String[] args) {
        System.out.println(sol("3people unFollowed me"	));
        System.out.println(sol("for the last week"	));
//        System.out.println("3".toUpperCase());
    }
    public static String solution(String s) {
        String answer = "";
        String arr[]=s.toLowerCase().split("");
//        System.out.println(Arrays.toString(arr));
        boolean isT=true;
        for (String s1 : arr) {
            answer+=isT ? s1.toUpperCase():s1;
//            System.out.println(answer);
            isT= s1.equals(" ");
        }

        return answer;
    }
    public static String sol(String s)
    {
        String ans="";
        boolean isT=true;
        String arr[]=s.toLowerCase().split("");
        for (int i = 0; i < arr.length; i++) {
            char c=s.charAt(i);
            if(i==0 || isT)
            {
                ans+=Character.toUpperCase(c);
                isT=false;
            }
            else
            {
                ans+=c;
            }
            if(c==' ')
            {
                isT=true;
            }
        }
        return ans;
    }
}
