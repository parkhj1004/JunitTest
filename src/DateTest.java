import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class DateTest
{

    public static void main (String args[])
    {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        long timeStampSecond = instant.getEpochSecond();

        System.out.println("timeStampMillis ::  " +timeStampMillis );
        System.out.println("timeStampSecond ::  " +timeStampSecond );



        DateTest test = new DateTest();

        test.getIntervalYearMonthByYM("" , 0);
        test.getIntervalYearMonthByYM("20170402" , 1);
        test.getIntervalYearMonthByYM("20170402" , -1);

        String a = "2017-10-27 18:24:00";

        System.out.println(a.substring(0,4));
        System.out.println("20171010".substring(0,6));
        System.out.println(a.substring(5,7));
        System.out.println(a.substring(8,10));

        String b = "20171122";

        System.out.println(b.substring(0,4));
        System.out.println(b.substring(4,6));
        System.out.println(b.substring(6,8));


        System.out.println(test.compareToday("20161109"));


    }

    public static String getIntervalYearMonthByYM(String yearMonth, int minVal){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        Calendar cal = Calendar.getInstance();

        if(yearMonth != null && !yearMonth.isEmpty())
        {
            int year = Integer.parseInt(yearMonth.substring(0,4));
            int month = Integer.parseInt(yearMonth.substring(4,6));

            cal.set(year, month+minVal, 0);
        }else
        {
            cal.add(cal.MONTH, minVal);
        }

        String beforeYear = dateFormat.format(cal.getTime()).substring(0,4);
        String beforeMonth = dateFormat.format(cal.getTime()).substring(4,6);

        String retStr = beforeYear + beforeMonth;

        System.out.println("retStr :: " + retStr);

        return retStr;
    }

    public static long compareToday(String target) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        long diffDays = 0;

        // 오늘날짜
        String today = getToday();

        try {
            Date beginDate = formatter.parse(today);
            Date endDate = formatter.parse(target);

            // 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
            long diff = endDate.getTime() - beginDate.getTime();
            diffDays = diff / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return diffDays;

    }

    /**
     * 오늘날짜를 문자열로
     * @return String
     */
    public static String getToday() {

        // 오늘날짜
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1 ;
        int day = cal.get(Calendar.DATE) ;

        // 달이 1~9이면 0을 붙여줌
        String strMonth = (month < 10) ? "0" + String.valueOf(month) : String.valueOf(month);

        // 일이 1~9이면 0을 붙여줌
        String strDay = (day < 10) ? "0" + String.valueOf(day) : String.valueOf(day);

        return String.valueOf(year) + strMonth + String.valueOf(strDay);

    }

}


