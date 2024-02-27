package jp.co.brightstar.dvd.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class lendInfo {
	/** 貸出日付 */
	private Date lendDate;
	/** 返却日付 */
	private Date returnDate;
	/** 単価 */
	private int price;
	/** レンタル総額 */
	private int cost;

	public String getLendDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(this.lendDate);
	}

	public String getReturnDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return this.returnDate == null ? "" : sdf.format(this.returnDate);
	}

	public String getPriceStr() {
		return this.price + "元";
	}

	public String getCostStr() {
		return this.cost == 0 ? "" : this.cost + "元";
	}
}

