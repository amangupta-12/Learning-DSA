class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int aliceArriveMonth = Integer.parseInt(arriveAlice.substring(0, 2));
        int aliceArriveDay = Integer.parseInt(arriveAlice.substring(3));
        int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
        int aliceLeaveDay = Integer.parseInt(leaveAlice.substring(3));

        int bobArriveMonth = Integer.parseInt(arriveBob.substring(0, 2));
        int bobArriveDay = Integer.parseInt(arriveBob.substring(3));
        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0, 2));
        int bobLeaveDay = Integer.parseInt(leaveBob.substring(3));

        int startD = 0;
        int startM = 0;
        int endD = 0;
        int endM = 0;
        if (aliceArriveMonth > bobArriveMonth) {
            startD = aliceArriveDay;
            startM = aliceArriveMonth;

        } else if (aliceArriveMonth < bobArriveMonth) {
            startD = bobArriveDay;
            startM = bobArriveMonth;

        } else {
            if (aliceArriveDay > bobArriveDay) {
                startD = aliceArriveDay;
                startM = aliceArriveMonth;

            } else {
                startD = bobArriveDay;
                startM = bobArriveMonth;

            }
        }

        if (aliceLeaveMonth > bobLeaveMonth) {
            endD = bobLeaveDay;
            endM = bobLeaveMonth;
        } else if (aliceLeaveMonth < bobLeaveMonth) {
            endD = aliceLeaveDay;
            endM = aliceLeaveMonth;
        } else {
            if (aliceLeaveDay > bobLeaveDay) {
                endD = bobLeaveDay;
                endM = bobLeaveMonth;
            } else {
                endD = aliceLeaveDay;
                endM = aliceLeaveMonth;
            }
        }

        int days = 0;
        while (startM < endM) {
            days += monthDays[startM - 1] - startD + 1;
            startD = 1;
            startM++;
        }

        if (startM == endM) {
            if (startD < endD) {
                days += endD - startD + 1;
            } else if (startD == endD) {
                days++;
            }
        }
        return days;
    }
}