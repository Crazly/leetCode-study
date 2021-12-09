package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class getMiniDate {

    public static void main(String[] args) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date now = null;
//        try {
//             now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2021-04-26 01:00:00");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        //当前时间，默认凌晨一点

        Date now = new Date();
        System.out.println("now :-----------"+df.format(now));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        //昨天
        Date time = calendar.getTime();
        System.out.println("yesterday :--------------"+df.format(time));

        //已经过期的商品 yesterday < sku < now

        Calendar calendar1 = Calendar.getInstance();
        //明天
        calendar1.add(Calendar.DAY_OF_MONTH,1);
        Date tomorrow = calendar1.getTime();
        System.out.println("tomorrow :--------------"+df.format(tomorrow));
        //后天
        calendar1.add(Calendar.DAY_OF_MONTH,1);
        Date afterTomorrow = calendar1.getTime();
        System.out.println("afterTomorrow :--------------"+df.format(afterTomorrow));

        //即将过期的商品 tomorrow < sku < afterTomorrow

    }


}
