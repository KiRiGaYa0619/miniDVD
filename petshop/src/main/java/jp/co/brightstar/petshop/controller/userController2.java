package jp.co.brightstar.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jp.co.brightstar.petshop.model.customer;
import jp.co.brightstar.petshop.service.loginService;

@Controller
public class userController2 {
	@Autowired
	private loginService service;

	@PostMapping("/index")
	public ModelAndView userSignIn(customer cus) {
		ModelAndView mav = new ModelAndView("index");
		System.out.println(cus);
		return mav;
	}

	@PostMapping("/login")
	public ModelAndView goToMyPage(customer cus, HttpSession session) {
		// 在登录成功后
		session.setAttribute("userid", cus.getUserid());
	    ModelAndView mav = new ModelAndView();
	    String pwd = service.pwdCheck(cus.getUserid());
	    String msg = null;
	    if (cus.getPwd().equals(pwd)) {
	        msg = "登录成功！";
	        // 设置重定向到index页面
	        session.setAttribute("msg", msg);
	        session.setAttribute("isLoggedIn", true);
	        mav.setViewName("redirect:/index");
	        // 设置用户已登录状态
	    } else {
	        msg = "密码错误";
	        // 密码错误时重定向到登录页面
	        session.setAttribute("msg", msg);
	        mav.setViewName("redirect:/login");
	    }
	   
	    return mav;
	}



}
