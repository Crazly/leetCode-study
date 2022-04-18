package leetedCode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class Massage {

    public int massage(int[] nums) {


        return 0;
    }

    /**
     * 判断是否为回文字字符串
     * @param
     * @return
     */
    public static boolean check(String s){

        int first = 0;
        int end = s.length()-1;
        if (first<end) {
            if (s.charAt(first)!=s.charAt(end)) {
                return false;
            }else {
                s=s.substring(1,s.length()-1);
                check(s);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String str ="abc   ";
        System.out.println(str.length());
        System.out.println(str);
        System.out.println(str.trim());

    }


}
