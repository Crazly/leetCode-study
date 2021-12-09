import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {

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
//
//        List<String> skuCodes = new ArrayList<>();
//        skuCodes.add("K12335");
//        skuCodes.add("k45643");
//        skuCodes.add("KKKK45643");
//        skuCodes.add("Q45643");
//        skuCodes.add("q45643");
//
//
//        List<String> collect = skuCodes.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
//        System.out.println();


//        Integer f1=100,f2=100,f3=150,f4=150;
//
////        System.out.println(f1==f2);
////        System.out.println(f3==f4);
//
//        String s1 = new StringBuilder("ja").append("va").toString();
//        String intern = s1.intern();
//        System.out.println(intern == s1);
        long l1 = 1000l;
        long l2 = 800l;
        long l3 = Math.subtractExact(l2, l1);
        Double compare = getCompare(l3, l2);
        System.out.println(l3);
        System.out.println(compare);
    }
    private static Double getCompare(Long compare, Long compared) {
        if (compare == null || compared == null
                || compare == 0 || compared == 0) {
            return 0.0;
        }
        return BigDecimal.valueOf(compare).divide(BigDecimal.valueOf(compared), 2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100)).doubleValue();

    }



    /**
     * 查找手机号所在位置
     * @param ss
     * @return
     */
    public static int findPhonePostion(String ss){
        int pos = -1;
        Pattern pt = Pattern.compile("(86-[1][0-9]{10}) | (86[1][0-9]{10})|([1][0-9]{10})");
        Matcher mt=pt.matcher(ss);
//        mt.lookingAt();
        // mt.matches();
        while(mt.find()){
            pos = mt.start();
//            Log.i("ysl","findPhonePostion==" + mt.group(0) + "|||" + mt.start());
        }
        return pos;
    }

    public static String stripscript(String s) {
//        Log.i("ysl", "s 处理前===" + s);
        Pattern p = Pattern.compile("(\\d{3})\\-(\\d{4})\\-(\\d{4})$*");
        Matcher m = p.matcher(s);
        s = m.replaceAll("$1$2$3");
//        Log.i("ysl", "s 处理中===" + s);

        String pattern = "[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“’。，、？-]";
        String rs = "";
        for (int i = 0; i < s.length(); i++) {
            rs = rs + s.substring(i, i + 1);
            rs = regReplace(rs, pattern, " ");
        }
        rs = regReplace(rs, "/[\\r\\n]/g", "");

//        Log.i("ysl", "s 处理后===" + rs);
        return rs;
    }

    /**
     * 正则表达式字符串替换
     * @param content 字符串
     * @param pattern 正则表达式
     * @param newString 新的替换字符串
     * @return 返回替换后的字符串
     */
    public static String regReplace(String content,String pattern,String newString){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        String result = m.replaceAll(newString);
        return result;
    }
    public static boolean isPhoneNumber(String number) {
        String telRegex = "(86-[1][0-9]{10}) | (86[1][0-9]{10})|([1][0-9]{10})";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
//        String telRegex = "[1][1234567890]\\d{9}";
        if (StringUtil.isEmpty(number))
            return false;
        else
            return number.matches(telRegex);
    }
}
