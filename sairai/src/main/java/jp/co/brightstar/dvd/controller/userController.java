package jp.co.brightstar.dvd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jp.co.brightstar.dvd.model.User;
import jp.co.brightstar.dvd.service.loginService;

@Controller
public class userController {
	@Autowired
	private loginService service;

	@GetMapping("/register")
	public String showRegisterForm() {
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView registerUser(@RequestParam("userid") String userId, @RequestParam("password") String password) {
		// 处理用户登录逻辑，验证用户名密码等
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome"); // 设置视图名称为 welcome.html
		mav.addObject("username", userId); // 将用户名添加到 ModelAndView 中
		return mav;
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public ModelAndView login(User user, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// ユーザ認証チェック
		String msg = service.loginCheck(user);

		// 登録されたユーザID、パスワードの組み合わせに誤りがある場合
		if (!"success".equals(msg)) {
			// ユーザ情報保持用セッション情報をクリアする
			session.removeAttribute("userid");

			// エラーメッセージを表示しつつ自画面遷移
			mav.addObject("msg", msg);
			mav.setViewName("login");
		}
		// 登録されたユーザID、パスワードの組み合わせがあっている場合
		else {
			// ユーザIDを保持用セッションに格納（あれば差し替え）
			session.setAttribute("userid", user.getUsername());
			// DBの登録履歴にユーザIDを記入
			service.sendUserIdToDB(user);
			// 次の画面へ遷移
			mav.setViewName("redirect:/dvdindex");
		}

		return mav;
	}
	
	
	
}
