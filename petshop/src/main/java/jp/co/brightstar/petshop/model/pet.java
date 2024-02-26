package jp.co.brightstar.petshop.model;

import lombok.Data;

@Data
public class pet {
	private String petid;
	private String petname;
	private String age;
	private String type;
	private String gender;
}
