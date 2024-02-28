package jp.co.brightstar.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jp.co.brightstar.petshop.model.Orderinfo;
import jp.co.brightstar.petshop.model.customer;
import jp.co.brightstar.petshop.model.pet;
import jp.co.brightstar.petshop.service.loginService;
@Controller
public class pageController {
	@Autowired
	private loginService service;
	
	@GetMapping("/index")
	public String index(Model model, HttpSession session) {
	    // 检查用户是否已登录，并将登录状态添加到模型中
	    boolean isLoggedIn = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
	    model.addAttribute("isLoggedIn", isLoggedIn);
	    // 其他逻辑...
	    return "index";
	}

	
	@GetMapping("/contact")
	public String showContactForm() {
		return "contact";
	}
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	@GetMapping("/mypage")
	public ModelAndView mypage(Model model, HttpSession session,customer cus) {
	    // 检查用户是否已登录，并将登录状态添加到模型中
	    boolean isLoggedIn = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
	    model.addAttribute("isLoggedIn", isLoggedIn);
	    ModelAndView mav = new ModelAndView();
	    String userid = (String) session.getAttribute("userid");
	    customer customer = service.findCustomerById(userid);
	    List<pet> pet = service.findPetById(userid);
	    mav.addObject("customer", customer);
	    mav.addObject("pet", pet);
	    mav.setViewName("mypage");
	    return mav;
	    
	}
	@GetMapping("/booking1")
	public ModelAndView bookForm(Model mode,HttpSession sessionl) {
		 boolean isLoggedIn = sessionl.getAttribute("isLoggedIn") != null && (boolean) sessionl.getAttribute("isLoggedIn");
		 mode.addAttribute("isLoggedIn", isLoggedIn);
		Orderinfo order = new Orderinfo();
		mode.addAttribute("order", order);
	    ModelAndView mav = new ModelAndView();
	    String userid = (String) sessionl.getAttribute("userid");
	    List<pet> pet = service.findPetById(userid);
	    mav.addObject("pet", pet);
	    mav.setViewName("booking1");
	    return mav;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    // 将作用中的 "isLoggedIn" 属性删除，退出登录
	    session.removeAttribute("isLoggedIn");
	    session.removeAttribute("msg");
	    
	    return "redirect:/index"; 

	}
	@GetMapping("/about")
	public String about(Model model, HttpSession session) {
	    // 检查用户是否已登录，并将登录状态添加到模型中
	    boolean isLoggedIn = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
	    model.addAttribute("isLoggedIn", isLoggedIn);
	    // 其他逻辑...
	    return "about";
	}
	@GetMapping("/service")
	public String service(Model model, HttpSession session) {
	    // 检查用户是否已登录，并将登录状态添加到模型中
	    boolean isLoggedIn = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
	    model.addAttribute("isLoggedIn", isLoggedIn);
	    // 其他逻辑...
	    return "service";
	}

}
