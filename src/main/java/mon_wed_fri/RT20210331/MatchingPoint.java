package mon_wed_fri.RT20210331;

import java.util.*;

public class MatchingPoint {
    public static void main(String[] args) {

    }

    static Map<String, Page> tasdoasd;// <웹 페이지의 링크, index>

    public int solution(String word, String[] pages) {
        Map<String, Integer> map = new HashMap<>();
        List<Page> pageList = new ArrayList<>();
        int answer = 0;
        word = word.toLowerCase();
        for (int i = 0; i < pages.length; i++) {
            String s = pages[i] = pages[i].toLowerCase();
            int mid = 0;
            int l = 0;
            int r = 0;
            // url 구하는 과정.
            while (mid <= l) {
                l = s.indexOf("<meta", l + 1);
                r = s.indexOf(">", l);
                mid=s.lastIndexOf("https://",r);
            }
            r=s.indexOf("\"");
            String url=s.substring(mid,r);
            // 점수 구하기 body 찾기
            l=s.indexOf("<body>",r);
            int basicScore=0;
            for (int j = l;;) {
                j=s.indexOf(word,j+1);
                if(j==-1)
                    break;
                if(!Character.isLetter(s.charAt(j-1)) && !Character.isLetter(s.charAt(j+word.length())))
                {
                    basicScore++;
                    j+=word.length();
                }
            }

            int link=0;
            for (int j = l;;) {
                j=s.indexOf("<a href",j+1);
                if(j==-1)
                    break;
                link++;
            }
            map.put(url,i);
            pageList.add(new Page(i,basicScore,link,(double) basicScore));// 추가로 링크 점수 더해줌.
        }
        for (int i = 0; i <pages.length ; i++) {
            String s=pages[i];
            for (int posl,posr=0;;) {
                posl=s.indexOf("<a href",posr);
                if(posl==-1)
                    break;

                posl=s.indexOf("https://",posl);
                posr=s.indexOf("\"",posl);
                String RefUrl=s.substring(posl,posr);

               int idx=map.get(RefUrl);
               if(map.containsKey(RefUrl))
               {
                   pageList.get(idx).score+=(double) pageList.get(i).basic/pageList.get(i).link;
               }
            }
        }
        pageList.sort(new Comparator<Page>() {
            @Override
            public int compare(Page o1, Page o2) {
                if(o1.score==o2.score)
                    return o1.idx-o2.idx;
                else if (o2.score>o1.score)
                        return 1;
                else
                    return -1;
            }
        });
        return pageList.get(0).idx;
    }

    static class Page {
        int idx;
        int basic, link;
        double score;

        public Page(int idx, int basic, int link, double score) {
            this.idx = idx;
            this.basic = basic;
            this.link = link;
            this.score = score;
        }
    }
}
