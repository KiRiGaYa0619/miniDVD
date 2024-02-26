package jp.co.brightstar.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.brightstar.petshop.model.Orderinfo;
import jp.co.brightstar.petshop.model.dateCheckSystem;
import jp.co.brightstar.petshop.service.orderService;

@Controller
public class orderController {
	@Autowired
	private orderService service;

	@PostMapping("/booking1")
	public ModelAndView booking(Orderinfo order) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("order", order)	;
		int orderSpace = service.orderSpace(order);
		int storeSpace = service.storeSpace(order);
		String msg = null;
		msg = (orderSpace < storeSpace || dateCheckSystem.dateCheck(order,storeSpace)) ? "預約成功" : "所選日期無可預約時間";
		System.out.println(msg);
		mav.addObject("msg", msg);
		return mav;
	}

}
