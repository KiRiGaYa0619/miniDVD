package jp.co.brightstar.petshop.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

import jp.co.brightstar.petshop.model.Orderinfo;

@Mapper
public interface orderMapper {
		Date maxStartDate(String storeid,String spaceStu); 
		Date minEndDate(String storeid,String spaceStu);
		int storeSpace(String storeid,String spaceStu);
		int orderSpace(String storeid,String spaceStu);
		void addBook(Orderinfo order);
}
