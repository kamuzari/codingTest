package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly27;

import java.io.*;

public class TimeConcept {
    static class Time {
        int h, m, s;

        public Time(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
        }

        public int secondsDto()
        {
            return h*3600 +m*60+s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {

            String cur[] = br.readLine().split(":");
            String pro[] = br.readLine().split(":");
            Time current = null, promise = null;
            current = new Time(Integer.parseInt(cur[0])
                    , Integer.parseInt(cur[1]), Integer.parseInt(cur[2]));
            promise = new Time(Integer.parseInt(pro[0])
                    , Integer.parseInt(pro[1]), Integer.parseInt(pro[2]));
            int now = current.secondsDto();
            int next = promise.secondsDto();
            int gap=next-now;
            if(gap<=0)
                gap+=3600*24;

            int h=gap/3600;
            int m=(gap-3600*h)/60;
            int s=(gap-3600*h)%60;

            System.out.printf("#%d %02d:%02d:%02d\n",testCase,h,m,s);
        }
    }
}
