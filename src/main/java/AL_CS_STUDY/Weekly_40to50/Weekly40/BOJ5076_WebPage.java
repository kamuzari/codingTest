package AL_CS_STUDY.Weekly_40to50.Weekly40;
import java.util.*;
import java.io.*;
public class BOJ5076_WebPage {
    static final String OPEN="<";
    static final String COMMON_END=">";
    static final String CLOSE="</";
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuffer answers=new StringBuffer();
        while (true){
            String input=br.readLine();
            if(input.equals("#")) break;
            Stack<String> stack=new Stack<>();
            final int n = input.length();
            for (int i = 0; i < n; i++) {
                StringBuffer sb=new StringBuffer();
//                System.out.println("i : "+input.charAt(i));
                if(input.charAt(i)=='<'){
                    if(input.charAt(i+1)=='/') {
                        i++;
                        while (true) {
                            i++;
                            if (input.charAt(i) == '>') break;
                            sb.append(input.charAt(i));
                        }
                        if (!stack.isEmpty() && stack.peek().equals(sb.toString())) {
                            stack.pop();
                        } else {
                            answers.append("illegal\n");
                            break;
                        }
                    }else{
                        int not=0,blank=0;
                        while (true){
                            i++;
                            char ch=input.charAt(i);
                            if(ch=='/' && input.charAt(i+1)=='>') not++;
                            if(ch==' ') blank++;
                            if(ch=='>') break;
                            if(blank==0&& not==0) sb.append(ch);
                        }
                        if(not==0&&blank==0) stack.push(sb.toString());
                    }
                }
                if(stack.isEmpty() && i==n-1){
                    answers.append("legal\n");
                    break;
                }else if(!stack.isEmpty()&& i==n-1){
                    answers.append("illegal\n");
                    break;
                }
            }
        }
        System.out.println(answers);
    }
}
