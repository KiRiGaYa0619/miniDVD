package jp.co.brightstar.dvd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.brightstar.dvd.model.Condi;
import jp.co.brightstar.dvd.model.DVD;
import jp.co.brightstar.dvd.service.DVDService;

@Controller
public class DVDController {
	@Autowired
	private DVDService service;

	@GetMapping("/dvdindex")
	public String dvdindex() {
		return "dvdindex";
	}

	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}

	@PostMapping("/insert")
	public ModelAndView insert(String name) {
		ModelAndView mav = new ModelAndView();

		service.insertDVD(name);

		String msg = "DVD「" + name + "」の新規に成功しました！";
		mav.addObject("msg", msg);

		mav.setViewName("insert");

		return mav;
	}



	@GetMapping("/select")
	public ModelAndView select(Condi condi) {
		ModelAndView mav = new ModelAndView("select");
		System.out.println(condi);
		if(condi.getSousaname() != null  ) {
				if("lend".equals(condi.getSousa())) {
					service.lendDVD(condi.getSousaid());
					service.info(condi.getSousaid());
				}else if("delete".equals(condi.getSousa())) {
					service.deleteDVD(condi.getSousaid());
				}
		}
//			List<ValueAndText>stateList = service.getList("state");
//			List<ValueAndText>countList = service.getList("count");
//			mav.addObject("stateList", stateList);
//			mav.addObject("countList", countList);
		List<DVD> dvds = service.selectDVD(condi);
		mav.addObject("dvds",dvds);
//		for (DVD dvd : dvds) {
//			System.out.println(dvd);
//		}

		return mav;
	}

}