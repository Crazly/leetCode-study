import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class testForMe {


    public static void main(String[] args) {


        String str ="{\"deliveryRemark\":\"电梯上楼，13楼，平拖距离6米，台阶数: 5\",\"floor\":13,\"haulDistance\":6.00,\"isStep\":0,\"isUnload\":0,\"stepNum\":5,\"upMethod\":1}";

        JSONObject jsonObject = JSONUtil.parseObj(str);
        System.out.println(jsonObject);

//        String date1 = "2020-08-18 00:00:00";
//        String date2 = "2021-08-20 00:00:00";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        try {
//            Date date01 = format.parse(date1);
//            Date date02 = format.parse(date2);
//            String s = convertToTimeStr(date01, date02);
//            System.out.println(s);
////            Calendar instance = Calendar.getInstance().get
//
//        } catch (Exception e) {
//
//
//        }

//        System.out.println("输入参数：");
//        Scanner sc = new Scanner(System.in);
//        String input = sc.next();
//        int hour = Integer.parseInt(input);
//        if (hour!=12&&hour!=0) {
////        if ((hour>0&&hour<12)||(hour>12&&hour<=23)) {
//            System.out.println("输出结果："+Boolean.FALSE);
//        }else {
//            System.out.println("输出结果："+Boolean.TRUE);
//        }


//        String dayTime = "2021082312";
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
//        try {
//            Date parse = format.parse(dayTime);
//            int hours = parse.getHours();
//            System.out.println(hours);
////            Calendar instance = Calendar.getInstance().get
//
//        } catch (ParseException e) {
//
//
//        }
//        String hour = dayTime.substring(8);
//        System.out.println("hour========="+hour);
//        double v = BigDecimal.valueOf(81).divide(BigDecimal.valueOf(70), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println(v);
//            String str = stripscript("测试人员005 13487654675 北京上海测试");
//            String str2 = stripscript("13487654675测试人员005  北京上海测试");
//            int findPhoneIndex = findPhonePostion(str2);
//            if (findPhoneIndex > 0){ //手机号和其他信息杂合在一起了
//                System.out.println(str2.substring(0, findPhoneIndex));
//                System.out.println(str2.substring(findPhoneIndex));
////                dataList.set(i,str.substring(0,findPhoneIndex));
////                dataList.add(i+1,str.substring(findPhoneIndex));
//            }
//            if (findPhoneIndex == 0 && str2.length() > 11){ //不止手机号
//                System.out.println(str2.substring(0, 11));
//                System.out.println(str2.substring(11));
////                dataList.set(i,str.substring(0,11));
////                dataList.add(i+1,str.substring(11));
//            }

//        List<String> skuCodes = new ArrayList<>();
//        skuCodes.add("K12335");
//        skuCodes.add("k45643");
//        skuCodes.add("KKKK45643");
//        skuCodes.add("Q45643");
//        skuCodes.add("q45643");
//
//        System.out.println(JSONUtil.toJsonStr(skuCodes));
//        List<String> collect = skuCodes.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
//        System.out.println(JSONUtil.toJsonStr(collect));


//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.MONTH, 0);
//        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
//        String yyyyMMddHH = DateUtil.format(c.getTime(), "yyyyMMdd");
//        System.out.println(yyyyMMddHH+"00");
//        String first = format.format(c.getTime());
//        Calendar a = Calendar.getInstance();
//        a.set(Calendar.DATE, 1);
//        a.roll(Calendar.DATE, -1);
//        int maxDate = a.get(Calendar.DATE);

//        int i = Calendar.getInstance().get(Calendar.DATE);
//        System.out.println("safsdfa++++++++++"+maxDate);
//        System.out.println("====="+i);
//        System.out.println("======="+BigDecimal.valueOf(i).divide(BigDecimal.valueOf(maxDate), 3, BigDecimal.ROUND_HALF_UP)
//                .multiply(BigDecimal.valueOf(100)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());

//        int i = Calendar.getInstance().get(Calendar.HOUR);
//        int i1 = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
//
//        System.out.println(i);
//        System.out.println(i1);


    }

    public static String convertToTimeStr(Date startTime, Date endTIme) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        int startYear = calendar.get(Calendar.YEAR);
        int startMonth = calendar.get(Calendar.MONTH) + 1;
        int startDay = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.setTime(endTIme);
        int endYear = calendar.get(Calendar.YEAR);
        int endMonth = calendar.get(Calendar.MONTH) + 1;
        int endDay = calendar.get(Calendar.DAY_OF_MONTH);
        if (startYear == endYear) {
            return String.format("%s年%s.%s-%s.%s", startYear, startMonth, startDay, endMonth, endDay);
        }
        return String.format("%s年%s.%s-%s年%s.%s", startYear, startMonth, startDay, endYear, endMonth, endDay);
    }

}
