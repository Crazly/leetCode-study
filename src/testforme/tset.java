package testforme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tset {

    private String s ;
    private String b;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int i = s.hashCode();
        return super.hashCode();
    }

    public static void main(String[] args) {

//            String str = stripscript("测试人员005 13487654675 北京上海测试");
        String str2 = stripscript("13487654675测试人员005  北京上海测试");
        int findPhoneIndex = findPhonePostion(str2);
        if (findPhoneIndex > 0) { //手机号和其他信息杂合在一起了
            System.out.println(str2.substring(0, findPhoneIndex));
            System.out.println(str2.substring(findPhoneIndex));
//                dataList.set(i,str.substring(0,findPhoneIndex));
//                dataList.add(i+1,str.substring(findPhoneIndex));
        }
        if (findPhoneIndex == 0 && str2.length() > 11) { //不止手机号
            System.out.println(str2.substring(0, 11));
            System.out.println(str2.substring(11));
//                dataList.set(i,str.substring(0,11));
//                dataList.add(i+1,str.substring(11));
        }
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

}
