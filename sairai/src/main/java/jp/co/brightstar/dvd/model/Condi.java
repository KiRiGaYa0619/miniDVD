package jp.co.brightstar.dvd.model;

import lombok.Data;

@Data
public class Condi {
	/** 貸出状況 */
	private String[] state;
	/** 名称 */
	private String name;
	/** 貸出日付(From) */
	private String fromdate;
	/** 貸出日付(To) */
	private String todate;
	/** 貸出回数 */
	private String count;
	//操作的名称
	private String sousaname;
	//操作的id
		private String sousaid;
	//借出归还操作
	private String sousa;

}
