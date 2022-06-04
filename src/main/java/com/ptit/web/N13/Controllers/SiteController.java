package com.ptit.web.N13.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.web.N13.Models.Room;
import com.ptit.web.N13.Service.RoomService;

@Controller
public class SiteController {
	@GetMapping("/")
	public ModelAndView home(HttpSession session) {
		ModelAndView model = new ModelAndView("index");
		if(session.getAttribute("USERNAME")!=null) {
			model.addObject("isLogin", true);
			model.addObject("USERNAME", session.getAttribute("USERNAME"));
		}
		return model;
	}
	@GetMapping("/news")
	public String news() {
		return "news";
	}
	@GetMapping("/news-details")
	public String newsDetails() {
		return "news-details";
	}
	@GetMapping("/contact")
	public String contact() {
		return "news";
	}
}
