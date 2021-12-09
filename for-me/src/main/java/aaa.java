import com.alibaba.fastjson.JSON;
import com.baj.common.session.SessionLocal;
import com.baj.common.util.CollectionUtil;
import com.baj.common.util.DateUtil;
import com.baj.common.util.StringUtil;
import org.springframework.beans.BeanUtils;
import price.IcsArticlePriceDataExchangeDto;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class aaa {

    // 英文字母大小写，数字0-9，所有中文
//    public final static String KEY="[A-Za-z0-9\\u4e00-\\u9fa5]";
    public final static String KEY="[A-Za-z0-9,]";

    public static boolean specialSymbols(String str){
        return str.matches(KEY);
    }

    public static void main(String[] args) {

//        IcsArticlePriceDataExchangeDto ics1 = new IcsArticlePriceDataExchangeDto();
////        ics1.setId(1l);
//        ics1.setEffectiveTime(DateUtil.stringToDate("20211123",DateUtil.Format_7));
//        Date endTime4= DateUtil.stringToDate("20220302", DateUtil.Format_7);
//        ics1.setEndTime(endTime4);
//        ics1.setSalesPrice(BigDecimal.valueOf(4));
//
//        dealSalePrice(ics1);

//        compareDate();

//        List<String> shopCodes = new ArrayList<>();
//        shopCodes.add("1004");
//        shopCodes.add("C003");
//        StringBuffer codes = new StringBuffer("");
//        shopCodes.forEach(x->{
//            codes.append(x);
//        });
//        System.out.println(codes.toString());
//        System.out.println(StringUtil.join(",",shopCodes));
//
//        StringJoiner joiner = new StringJoiner(",");
//        shopCodes.forEach(x->{
//            joiner.add(x);
//        });
//        System.out.println(joiner.toString());
//        Integer i = new Integer(0);
        Long s = new Long(2);
        long w = 2l;
        System.out.println(s.equals(w));

    }


    public static void dealSalePrice(IcsArticlePriceDataExchangeDto item) {
        try {
//            List<IcsArticlePriceDataExchangeDto> icsPriceList = getIcsPrice(item.getSapSkuNo(), item.getShopCode(), item.getUnitCode(), item.getPriceType());
            List<IcsArticlePriceDataExchangeDto> icsPriceList = new ArrayList<>();
            IcsArticlePriceDataExchangeDto ics1 = new IcsArticlePriceDataExchangeDto();
            ics1.setId(1l);
            ics1.setEffectiveTime(DateUtil.stringToDate("20211123",DateUtil.Format_7));
            Date endTime4= DateUtil.stringToDate("20220202", DateUtil.Format_7);
            ics1.setEndTime(endTime4);
            ics1.setSalesPrice(BigDecimal.valueOf(1));

            IcsArticlePriceDataExchangeDto ics2 = new IcsArticlePriceDataExchangeDto();
            ics2.setId(2l);
            ics2.setEffectiveTime(DateUtil.stringToDate("20220203",DateUtil.Format_7));
            Date endTime2= DateUtil.stringToDate("99991231", DateUtil.Format_7);
            ics2.setEndTime(endTime2);
            ics2.setSalesPrice(BigDecimal.valueOf(2));

            IcsArticlePriceDataExchangeDto ics3 = new IcsArticlePriceDataExchangeDto();
            ics3.setId(3l);
            ics3.setEffectiveTime(DateUtil.stringToDate("20220102",DateUtil.Format_7));
            Date endTime3= DateUtil.stringToDate("99991231", DateUtil.Format_7);
            ics3.setEndTime(endTime3);
            ics3.setSalesPrice(BigDecimal.valueOf(3));


            icsPriceList.add(ics1);
            icsPriceList.add(ics2);
//            icsPriceList.add(ics3);


            icsPriceList.removeIf(icsDto -> (icsDto.getEffectiveTime() == null || icsDto.getEndTime() == null));
            IcsArticlePriceDataExchangeDto curIcsPrice = new IcsArticlePriceDataExchangeDto();
            if (CollectionUtil.isEmpty(icsPriceList)) {
//                mergeImportVoToIcsDto(item, curIcsPrice);
//                Long id = icsArticlePriceDataExchangeWriteService.add(curIcsPrice);
//                syncPrice(id);
                return;
            }
            Collections.sort(icsPriceList, new Comparator<IcsArticlePriceDataExchangeDto>() {
                @Override
                public int compare(IcsArticlePriceDataExchangeDto o1, IcsArticlePriceDataExchangeDto o2) {
                    return o1.getEffectiveTime().compareTo(o2.getEffectiveTime());
                }
            });
            BeanUtils.copyProperties(icsPriceList.get(0), curIcsPrice);
            curIcsPrice.setId(null);
//            curIcsPrice.setDeleteFlag("");
            Date startTime = item.getEffectiveTime();
            Date endTime = item.getEndTime();
            curIcsPrice.setEffectiveTime(startTime);
            curIcsPrice.setEndTime(endTime);
            curIcsPrice.setSalesPrice(item.getSalesPrice());
            List<IcsArticlePriceDataExchangeDto> updateList = new ArrayList<>();
            List<IcsArticlePriceDataExchangeDto> insertList = new ArrayList<>();
            insertList.add(curIcsPrice);

            List<Long> deleteIds = new ArrayList<>();
            IcsArticlePriceDataExchangeDto startCurDto = null;
            for (int i = 0;i < icsPriceList.size();i ++) {
                IcsArticlePriceDataExchangeDto icsPrice  = icsPriceList.get(i);
                if (startTime.after(icsPrice.getEndTime())){
                    deleteIds.add(icsPrice.getId());
                    continue;
                }
                Date sourceEndTime = icsPrice.getEndTime();
                if (startCurDto == null) {
                    if (startTime.after(icsPrice.getEffectiveTime())) {
                        Date endT = DateUtil.addDay(startTime, -1);
                        icsPrice.setEndTime(endT);
                        icsPrice.setEndTimeStr(DateUtil.dateToString(endT,DateUtil.Format_1));
//                        icsPrice.setUpdatedBy(SessionLocal.getUserId() + "");
                        updateList.add(icsPrice);
                    } else {
                        deleteIds.add(icsPrice.getId());
                    }
                    startCurDto = icsPrice;
                }

                if (endTime.before(sourceEndTime)) {
                    IcsArticlePriceDataExchangeDto insertDto = new IcsArticlePriceDataExchangeDto();
                    BeanUtils.copyProperties(icsPrice, insertDto);
                    insertDto.setId(null);
                    insertDto.setEndTime(sourceEndTime);
                    insertDto.setEndTimeStr(DateUtil.dateToString(sourceEndTime,DateUtil.Format_1));
                    Date eff = DateUtil.addDay(endTime, 1);
                    insertDto.setEffectiveTime(eff);
                    insertDto.setEffectiveTimeStr(DateUtil.dateToString(eff,DateUtil.Format_1));
//                    insertDto.setUpdatedBy(SessionLocal.getUserId() + "");
                    insertList.add(insertDto);
                    deleteIds.add(icsPrice.getId());
                    break;
                } else if (endTime.equals(sourceEndTime)) {
                    if (startCurDto != icsPrice) {
                        deleteIds.add(icsPrice.getId());
                    }
                    break;
                }else if( endTime.after(sourceEndTime)&&startCurDto != icsPrice){
                    deleteIds.add(icsPrice.getId());
                }
            }

            //删除价格数据
            if (CollectionUtil.isNotEmpty(deleteIds)) {
                List<Long> collect = deleteIds.stream().distinct().collect(Collectors.toList());
                System.out.println("删除数据："+ JSON.toJSON(collect).toString());
            }

//            for (Long id : deleteIds) {
////                icsArticlePriceDataExchangeWriteService.deleteById(id);
//            }
            //插入价格
            if (CollectionUtil.isNotEmpty(insertList)) {
                System.out.println("插入数据："+JSON.toJSON(insertList).toString());
            }
//            for (IcsArticlePriceDataExchangeDto insertDto : insertList) {
////                Long id = icsArticlePriceDataExchangeWriteService.add(insertDto);
////                insertDto.setId(id);
//            }
            // 更新价格数据
            if (CollectionUtil.isNotEmpty(updateList)) {
                System.out.println("更新数据："+JSON.toJSON(updateList).toString());
            }
//            for (IcsArticlePriceDataExchangeDto updateDto : updateList) {
////                icsArticlePriceDataExchangeWriteService.updateById(updateDto);
//            }

//            //及时同步商品价格
//            List<IcsArticlePriceDataExchangeDto> allList = new ArrayList<>();
//            allList.addAll(insertList);
//            allList.addAll(updateList);
//            Date now = new Date();
//            for(IcsArticlePriceDataExchangeDto dto : allList){
////                if(!"X".equals(dto.getDeleteFlag()) && now.after(dto.getEffectiveTime())
////                        && now.before(DateUtil.getDayEnd(dto.getEndTime()))){
////                    try {
//////                        syncPrice(dto.getId());
////                    }catch (Exception e){
//////                        logger.error("syncPrice error",e);
////                    }
////                }
//            }
        } catch (Exception e) {

        }
    }


    public static void compareDate(){

        String dateStr = "20211122";
        String dateStr2 = "20211123";

        Date date1 = DateUtil.stringToDate(dateStr, DateUtil.Format_7);
        Date date2 = DateUtil.stringToDate(dateStr2, DateUtil.Format_7);

        if (date2.before(date1)) {
            System.out.println("111111111");
        }else {
            System.out.println("222222222");
        }


    }



}
