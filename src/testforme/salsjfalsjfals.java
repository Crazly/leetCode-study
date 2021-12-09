package testforme;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class salsjfalsjfals {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");

        try {
            Date start = sdf.parse("2021-04-24 00:00:02");
            Date end = sdf.parse("2021-04-24 00:00:00");
            Date yes = sdf.parse("2021-04-24 00:00:01");

            System.out.println(start.after(end));
            System.out.println(start.compareTo(end));
            System.out.println(start.compareTo(yes));

        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
