//package edu.poly.shop.controller;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import edu.poly.shop.domain.Account;
//import edu.poly.shop.domain.Customer;
//import edu.poly.shop.model.AdminLoginDto;
//import edu.poly.shop.service.AccountService;
//import edu.poly.shop.service.CustomerService;
//
//@Controller
//public class SiteLoginController {
//
//	@Autowired
//	 private CustomerService customerService;
//	 
//		@Autowired
//	 private HttpSession session;
//	 
//		@GetMapping("login")
//		public String login(ModelMap model) {
//			model.addAttribute("customer", new AdminLoginDto());
//			return "/site/customers/login";
//			
//		}
//		
//		@PostMapping("login")
//		public  ModelAndView login(ModelMap model,
//			@Valid @ModelAttribute("customer") AdminLoginDto dto,
//		BindingResult result) {
//			// kiể tra lỗi đã rằng buộc trong bảng
//			if(result.hasErrors()) {
//				return new ModelAndView("/site/customers/login",model);
//			}
//			
//		//	Customer customer = customerService.login(dto.getUsername(),dto.getPassword());
//			
//			if(customer1==null) {
//				model.addAttribute("message","invalid username or password");
//				return new ModelAndView("/site/customers/login",model);
//			}
//			session.setAttribute("username", customer1.getName());
//			
//			Object rurl = session.getAttribute("redirect-uri");
//			if(rurl != null) {
//				session.removeAttribute("redirect-uri");
//				return new ModelAndView("redirect:" + rurl);
//				
//			}
//		
//			return new ModelAndView("forward:/site/customers",model);
//		}
//
//}
