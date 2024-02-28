package jp.co.brightstar.petshop.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.brightstar.petshop.mapper.orderMapper;
import jp.co.brightstar.petshop.model.Orderinfo;

@Service
public class orderService {
	@Autowired
	private  orderMapper mapper;
public  int storeSpace(Orderinfo order) {
		
		return mapper.storeSpace(order.getStoreid(),order.getSpaceStu());
		
	}
public int orderSpace(Orderinfo order) {
	
	return mapper.orderSpace(order.getStoreid(),order.getSpaceStu());
	
}
public Date maxStartDate(Orderinfo order) {
	
	return mapper.maxStartDate(order.getStoreid(),order.getSpaceStu());
	
}
public Date minEndDate(Orderinfo order) {
	
	return mapper.minEndDate(order.getStoreid(),order.getSpaceStu());
	
}
public void addBook(Orderinfo order) {
}
}
