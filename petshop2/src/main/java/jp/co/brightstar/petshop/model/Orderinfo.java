package jp.co.brightstar.petshop.model;

import lombok.Data;

@Data
public class Orderinfo {
	
	
	private String name;
	private String tel;
	private String mail;
	private String startDate;
	private String endDate;
	private String storeid;
	private String spaceStu;
	//0=未開始服務 1=服務中 2=已變更 3= 已取消 9=已完成
	private String orderSta;

}
	
