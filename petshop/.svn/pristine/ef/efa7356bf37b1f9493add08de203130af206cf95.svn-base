package jp.co.brightstar.petshop.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jp.co.brightstar.petshop.mapper.orderDao;

public class dateCheckSystem {


    public static boolean dateCheck(Orderinfo order,int storeSpace) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //String型轉Localdate型
        LocalDate startDate = LocalDate.parse(order.getStartDate(), formatter);
        LocalDate endDate = LocalDate.parse(order.getEndDate(), formatter);
        //包含用戶輸入的開始結束中間所有日期弄成一個List 
        List<LocalDate> datesBetween = dateUtils.getDatesBetween(startDate, endDate);
        List<DateRanger> dateRanges = orderDao.getDateFromDatabase(order);
        boolean leanable = true;

        //當門店某一類型的縂空位
        outerloop:
        for (LocalDate date : datesBetween) {
            int count = 0;
            for (DateRanger dateRange : dateRanges) {
                if ((date.isBefore(dateRange.getStartDate()) || date.isAfter(dateRange.getEndDate().plusDays(1))) ? false : true) {
                    count++;
                    if (count == storeSpace) {
                        leanable = false;
                        break outerloop;
                    }
                }
            }
        }

        return leanable;
    }
}
