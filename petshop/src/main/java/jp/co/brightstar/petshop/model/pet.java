package jp.co.brightstar.petshop.model;

import lombok.Data;

@Data
public class pet {
	private String petid;
	private String petname;
	private String age;
	private String type;
	private String gender;
	
	public String getAgeStr() {
		return   this.age + "嵗";
	}

	public String getTypeStr() {
		if("1".equals(type)) {
			this.type = "大型動物";
		}else {
			this.type = "小型動物";
		}
		return type;
	}

	public String getGenderStr() {
		if("1".equals(gender)) {
			this.gender = "男";
		}else {
			this.gender = "女";
		}
		return gender;
}
}
