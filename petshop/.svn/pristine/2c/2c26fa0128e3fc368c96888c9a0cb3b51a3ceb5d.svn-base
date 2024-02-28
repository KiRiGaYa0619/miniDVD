package jp.co.brightstar.petshop.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * 將一個包含頭尾日期的數組擴充到包含中間所有日期
 */
public class dateUtils {
	 public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
	        List<LocalDate> datesBetween = new ArrayList<>();
	        LocalDate currentDate = startDate;
	        while (!currentDate.isAfter(endDate)) {
	            datesBetween.add(currentDate);
	            currentDate = currentDate.plusDays(1); // 将当前日期增加一天
	        }
	        return datesBetween;
}
}
