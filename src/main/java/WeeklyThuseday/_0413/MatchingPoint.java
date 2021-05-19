package WeeklyThuseday._0413;

import java.util.*;

public class MatchingPoint {
    public static void main(String[] args) {
        String pages[]={"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        String word="blind";
        System.out.println(solution(word,pages));

        String word2="Muzi";
        String pages2[]={"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        System.out.println(solution(word2,pages2));
    }

    public static int solution(String word, String[] pages) {
        int wsize=word.length();
        Map<String,Integer> pageMap=new LinkedHashMap<>(); //url,pageIndex;
        List<Page> list=new ArrayList<>(); //
        word=word.toLowerCase();
        for (int i = 0; i < pages.length; i++) {
            String s=pages[i]=pages[i].toLowerCase();
            int mid=0; int l=0;int r=0;
            // 해당 l 안에 있어야 한다.
            while (mid<=l)
            {
                l=s.indexOf("<meta",l+1);
                r=s.indexOf(">",l);
                mid=s.lastIndexOf("https://",r);
            }
            r=s.indexOf("\"",mid);
            String url=s.substring(mid,r);

            // keyword 찾기

            l=s.indexOf("<body>",r);
            int basic=0;
            for(int start=l;;)
            {
                start=s.indexOf(word,start+1);
                if(start==-1)
                    break;
                if(!Character.isLetter(s.charAt(start-1))&& !Character.isLetter(s.charAt(start+wsize)))
                {
                    basic++;
                    start+=wsize;
                }
            }

            int link=0;
            for(int start=l; ;)
            {
                start=s.indexOf("<a href",start+1);
                if(start==-1)
                    break;
                link++;
            }
            pageMap.put(url,i);
            list.add(new Page(i,basic,link,(double)basic));
        }
        // 매칭 링크 점수 구하기

        for (int i = 0; i < pages.length; i++) {
            String s=pages[i];
            int l=0,r=0;
            while (true) {
                l=s.indexOf("<a href",r);
                if(l==-1)
                    break;
                l=s.indexOf("https://",l);
                r=s.indexOf("\"",l);
                String link=s.substring(l,r);
                if(pageMap.containsKey(link))
                {
                    list.get(pageMap.get(link)).score+=(double)list.get(i).basic/list.get(i).link;
                }
            }
        }

       list.sort((a, b) -> {
           if(a.score == b.score) {
               return a.idx - b.idx;
           } else if(a.score < b.score) {
               return 1;
           } else {
               return -1;
           }
       });


        int answer = list.get(0).idx;

        return answer;
    }
    static class Page implements Comparable<Page>{
        private int idx,basic,link;
        double score;

        public Page(int idx, int basic, int link, double score) {
            this.idx = idx;
            this.basic = basic;
            this.link = link;
            this.score = score;
        }

        @Override
        public int compareTo(Page page) {
            if(score==page.score)
                return idx-page.idx;
            if(score<page.score)
                return 1;
            else
                return -1;
        }
    }

}
