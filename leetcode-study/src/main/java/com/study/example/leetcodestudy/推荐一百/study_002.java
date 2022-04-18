package com.study.example.leetcodestudy.推荐一百;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class study_002 {
    /**
     * no 20. 有效的括号
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * 示例 1：
     * 输入：s = '()'
     * 输出：true
     * 示例 2：
     * 输入：s = '()[]{}'
     * 输出：true
     * 示例 3：
     * 输入：s = '(]'
     * 输出：false
     * 示例 4：
     * 输入：s = '([)]'
     * 输出：false
     * 示例 5：
     * 输入：s = '{[]}'
     * 输出：true
     * 提示：
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     *
     */

    public static boolean checkStr(String str){

        Map<Character,Character> characterMap = new HashMap<>();
        characterMap.put(')','(');
        characterMap.put(']','[');
        characterMap.put('}','{');

        char[] chars = str.toCharArray();
        LinkedList<Character> characterList = new LinkedList<>();
        Character character1 = characterMap.get(chars[0]);
        if (null!=character1) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            Character character = characterMap.get(chars[i]);
            if (!characterList.isEmpty()&&characterList.getFirst().equals(character)) {
                characterList.removeFirst();
            }else {
                characterList.addFirst(chars[i]);
            }
        }
        if (characterList.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str ="({})[]";
        System.out.println(checkStr(str));
    }

}
