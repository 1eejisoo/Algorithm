import java.util.TreeMap;

class Time {
    private int inTime;
    private int outTime;
    private boolean isIn;
    private boolean isOut;

    Time(int in) {
        this.inTime = in;
    }

    public void setIn(int in) {
        this.inTime = in;
        this.isIn = true;
        this.isOut = false;
    }

    public void setOut(int out) {
        this.outTime = out;
        this.isOut = true;
    }

    public boolean isOut() {
        return isOut;
    }

    int calcCumulativeTime() {
        return outTime - inTime;
    }
}

class Solution {
    int standard_time;
    int standard_fee;
    int unit_time;
    int unit_fee;
    TreeMap<String, Time> parkMap = new TreeMap<>();    // 주차 시각 저장용
    TreeMap<String, Integer> timeMap = new TreeMap<>();  // 주차 누적 시간 저장용

    public int[] calcFee() {
        int[] result = new int[timeMap.size()];
        int idx = 0;

        for (String cn : timeMap.keySet()) {
            int cumulative_time = timeMap.get(cn);
            if (cumulative_time <= standard_time) {
                result[idx] = standard_fee;
            } else {
                int tmp = ((cumulative_time - standard_time) % unit_time > 0) ? (cumulative_time - standard_time) / unit_time + 1 : (cumulative_time - standard_time) / unit_time;
                int fee = standard_fee + tmp * unit_fee;
                result[idx] = fee;
            }
            idx++;
        }
        return result;
    }

    public int[] solution(int[] fees, String[] records) {

        standard_time = fees[0];
        standard_fee = fees[1];
        unit_time = fees[2];
        unit_fee = fees[3];

        for (String record : records) {
            String[] oneRecord = record.split(" ");
            String[] time_str = oneRecord[0].split(":");

            int time = Integer.parseInt(time_str[0]) * 60 + Integer.parseInt(time_str[1]);  // 시각
            String carNum = oneRecord[1];  // 차량 번호
            String cmd = oneRecord[2];  // 내역

            if (cmd.equals("IN")) {
                if (parkMap.containsKey(carNum)) {
                    parkMap.get(carNum).setIn(time);
                    continue;
                }
                parkMap.put(carNum, new Time(time));
                timeMap.put(carNum, 0);
                continue;
            }
            if (cmd.equals("OUT")) {
                parkMap.get(carNum).setOut(time);
                int cumulativeTime = parkMap.get(carNum).calcCumulativeTime();  // 주차누적시간 계산
                timeMap.put(carNum, timeMap.get(carNum) + cumulativeTime);
            }
        }
        // 출차하지 않은 주차의 출차 시각을 23:59로 세팅
        for (String cn : parkMap.keySet()) {
            if (!parkMap.get(cn).isOut()) {
                parkMap.get(cn).setOut(23 * 60 + 59);
                timeMap.put(cn, timeMap.get(cn) + parkMap.get(cn).calcCumulativeTime());
            }
        }

        return calcFee();
    }
}