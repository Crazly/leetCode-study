import java.util.*;

public class adfadsfsd {
    public static void main(String[] args) {


//        String format = String.format("订单数量大于平台库存，没有有效临采供应商,无法下单， sku: %s", "3341233");
//        System.out.println(format);

//        String[] validTime = new String[]{"123","s56y"};
//
//        System.out.println(validTime.length);
//        System.out.println(validTime[0]);
//        System.out.println(validTime[1]);

//        Map<String,String> sku = new HashMap<String, String>();
//
//        sku.put("","");
//        sku.put("",null);
//        sku.put("",null);
//        sku.put(null,"");
//        sku.put(null,"");
//        sku.put(null,null);
//
//        System.out.println(sku.toString());
        int totalPage = totalPage(5001, 5000);
        System.out.println(totalPage);

        for (int i = 1; i <= totalPage; i++) {
            System.out.println("cur:"+i+"pageSize:"+5000);

        }

    }

    public static int totalPage(int totalCount, int pageSize) {
        if (pageSize == 0) {
            return 0;
        } else {
            return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        }
    }
}
