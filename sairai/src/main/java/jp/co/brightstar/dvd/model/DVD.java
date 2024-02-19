package jp.co.brightstar.dvd.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

/**
 * DVD
 */
@Data
public class DVD {
	/** 序号 */
	private int id;
	/** 名称 */
	private String name;
	/** 状态：0 → 可借、1 → 已借出 */
	private int state;
	/** 借出日期 */
	private Date date;
	/** 借出次数 */
	private int count;

	public String getNameStr() {
		return "《" + this.name + "》";
	}

	public String getStateStr() {
		String[] states = { "可借", "已借出" };
		return states[this.state];
	}

	public String getDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return this.date == null ? "" : sdf.format(this.date);
	}

	public String getCountStr() {
		return this.count + "次";
	}
}
