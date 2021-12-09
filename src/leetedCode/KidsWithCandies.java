package leetedCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 */
public class KidsWithCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        if (candies==null|| candies.length<2) {
            return Arrays.asList(false);
        }
        List<Boolean> resultList = new ArrayList<>();
        int[] compare = candies.clone();
        Arrays.sort(compare);
        for (int candy : candies) {
            int addExact = Math.addExact(candy, extraCandies);
            if (addExact>=compare[compare.length-1]) {
                resultList.add(true);
            }else {
                resultList.add(false);
            }

        }
        return resultList;
    }

    public static List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {

        if (candies==null|| candies.length<2) {
            return Arrays.asList(false);
        }
        List<Boolean> resultList = new ArrayList<>(candies.length);
        int max = candies[0];
        for (int i = 0; i < candies.length; i++) {
            max= max >candies[i]?max:candies[i];
        }
        for (int i = 0; i < candies.length; i++) {
            if ((candies[i]+extraCandies)>=max) {
                resultList.add(true);
            }else {
                resultList.add(false);
            }
        }
        return resultList;
    }




    public static void main(String[] args) {

        int[] candies = {2,4,8,6,4,9};
        int num =1;
//        List<Boolean> booleans = kidsWithCandies(candies, num);
//        System.out.println(booleans);
        List<Boolean> booleans = kidsWithCandies2(candies, num);
        System.out.println(booleans);

    }


}
