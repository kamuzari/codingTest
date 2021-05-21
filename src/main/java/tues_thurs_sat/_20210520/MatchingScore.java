package tues_thurs_sat._20210520;

import java.util.*;

public class MatchingScore {
    static class Page{
        private int idx,basic,externalLink;
        double matching;

        public Page(int idx, int basic, int externalLink, double matching) {
            this.idx = idx;
            this.basic = basic;
            this.externalLink = externalLink;
            this.matching = matching;
        }
    }
    public static int solution(String word, String[] pages) {
        int answer=0;
        int len=word.length();

        word=word.toLowerCase(  );
        Map<String ,Integer> map=new HashMap<>();
        List<Page> list=new LinkedList<>();
         for (int i = 0; i < pages.length; i++) {
            String s=pages[i].toLowerCase();
          int m=0,l=0,r=0;
          while (m<=l)
          {
              l=s.indexOf("<meta",l+1);
              r=s.indexOf(">",l);
              m=s.lastIndexOf("https://",r);
          }
          r=s.indexOf("\"",m);
          String url=s.substring(m,r);

          // keyword

            l=s.indexOf("<body>",r);
            int basic=0;
            int start=l;
            while (true)
            {
                start=s.indexOf(word,start+1);
                if(start<0)
                    break;
                if(!Character.isLetter(s.charAt(start-1)) &&!Character.isLetter(s.charAt(start+len)))
                {
                    basic++;
                    start+=len;
                }
            }

            int link=0;
            while (true)
            {
                start=s.indexOf("<a href",start+1);
                if(start<0)
                    break;
                link++;
            }
            map.put(url,i);
            list.add(new Page(i,basic,link,(double)basic));
        }
        for (int i = 0; i < pages.length; i++) {
            String page = pages[i];
            int l=0 ,r=0;
            while (true) {
                l = page.indexOf("<a href", r);
                if (l == -1)
                    break;
                l=page.indexOf("https://",l);
                r=page.indexOf("\"",l+8);
                String link=page.substring(l,r);
                if(map.containsKey(link))
                {
                    list.get(map.get(link)).matching+=(double)list.get(i).basic/list.get(i).externalLink;
                }
            }
        }
            list.sort(new Comparator<Page>() {
                @Override
                public int compare(Page o1, Page o2) {
                    if(o1.matching==o2.matching)
                    {
                        return o1.idx-o2.idx;
                    }
                    else if(o2.matching>o1.matching)
                    {
                        return 1;
                    }
                    else
                        return -1;
                }
            });
        answer = list.get(0).idx;
        return answer;
    }
}
// aaabcd  = 3 +3 6
