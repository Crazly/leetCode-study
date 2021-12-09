import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class test01 {

    public static void main(String[] args) {

//        int[] array = {1,2,3};
//        List<int[]> ints = Arrays.asList(array);
//        System.out.println(ints.size());
//        System.out.println(ints.get(0));
////        System.out.println(ints.get(1));
//        int[] s = (int[])ints.get(0);
//        System.out.println(s[1]);

//        List<Integer> ptOrderItemDtos1 = new ArrayList<>();
//        ptOrderItemDtos1.add(1);
//        ptOrderItemDtos1.add(2);
//        ptOrderItemDtos1.add(3);
//        ptOrderItemDtos1.add(4);
//
//
//        int sum = ptOrderItemDtos1.stream().filter(x->x==5).mapToInt(x -> x).sum();
//        System.out.println(sum);

        String monthNow = "2021080100";
        Date monthStart = stringToDate(monthNow, "yyyyMMddHH");
        Date yesMonthStart = addMonth(monthStart, -1);
        String yesMonthStartStr = dateToString(yesMonthStart, "yyyy-MM-dd");


        Calendar ca = Calendar.getInstance();
        ca.setTime(yesMonthStart);
        ca.set(Calendar.DAY_OF_MONTH,ca.getActualMaximum(Calendar.DAY_OF_MONTH));

        String old = dateToString(ca.getTime(), "yyyy-MM-dd");
        System.out.println("");
    }
    public static Date stringToDate(String dateString, String format) {
            SimpleDateFormat form = new SimpleDateFormat(null == format ? "yyyy-MM-dd" : format);
            Date date = null;

            try {
                date = form.parse(dateString);
            } catch (ParseException var5) {
                var5.printStackTrace();
            }

            return date;

    }
    public static Date addMonth(Date date, long month) {
        LocalDateTime localDate = convertToLocalDateTime(date);
        return convertToDate(localDate.plusMonths(month));
    }
    public static Date convertToDate(LocalDateTime localDateTime) {
        return convertToDate(localDateTime, ZoneId.systemDefault());
    }
    public static LocalDateTime convertToLocalDateTime(Date time) {
        return convertToLocalDateTime(time, ZoneId.systemDefault());
    }
    private static Date convertToDate(LocalDateTime localDateTime, ZoneId zoneId) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }
    public static LocalDateTime convertToLocalDateTime(Date time, ZoneId zoneId) {
        return getZonedDateTime(time, zoneId).toLocalDateTime();
    }
    private static ZonedDateTime getZonedDateTime(Date time, ZoneId zoneId) {
        Objects.requireNonNull(time, "time");
        Objects.requireNonNull(zoneId, "zoneId");
        return time.toInstant().atZone(zoneId);
    }
    public static String dateToString(Date date, String format) {
        if (null == date) {
            return null;
        } else {
            if (null == format) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat form = new SimpleDateFormat(format);
            return form.format(date);
        }
    }
}
