package programmers.Kits.KakaoBlind;

public class newIDPrefer {
    public String solution(String new_id) {
        String answer= "";
        String newId=new_id.toLowerCase();
        String newId2="";
        for(int i=0; i<new_id.length();i++)
        {
            char ch=newId.charAt(i);
            if(ch=='-' || ch=='_' || ch=='.' || Character.isDigit(ch) || Character.isAlphabetic(ch))
            {
                newId2+=ch;
            }
        }

        while(newId2.contains(".."))
        {
            newId2=newId2.replace("..",".");
        }

        int first=newId2.indexOf('.');
        int len=newId2.length();
        if(first==0)
            newId2=newId2.substring(1,len);
        len=newId2.length();
        int last=newId2.lastIndexOf('.');
        if(last!=-1 &&last==len-1)
            newId2=newId2.substring(0,len-1);

        if(newId2.equals(""))
            newId2="a";

        len=newId2.length();
        if(len>15)
        {
            newId2=newId2.substring(0,15);
        }
        len=newId2.length();
        int idx=newId2.lastIndexOf('.');
        if(idx==len-1)
            newId2=newId2.substring(0,len-1);
        while(newId2.length()<3)
        {
            len=newId2.length();
            newId2+=newId2.charAt(len-1);
        }
        return newId2;


    }
}
