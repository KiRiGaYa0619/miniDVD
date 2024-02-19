package jp.co.brightstar.dvd.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.brightstar.dvd.model.Condi;

@Controller
public class pageController {

    @GetMapping("/brightstar/dvd/select")
    public Condi selectPage(Model model) {
        // 这里可以添加逻辑来准备页面需要的数据
    	Condi con = new Condi();
        // 示例中假设您有一个名为dvds的列表数据，将其添加到模型中
        model.addAttribute("con", con);

        // 返回页面的逻辑名称，Thymeleaf会根据该名称找到对应的模板页面
        return con;
    }
}