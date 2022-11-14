package edu.poly.shop.controller.site;

import java.awt.CheckboxMenuItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import edu.poly.shop.domain.Customer1;
import edu.poly.shop.domain.Product;

import edu.poly.shop.model.ProductDto;
import edu.poly.shop.service.CustomerService;
import edu.poly.shop.service.ProductService;



@Controller
@RequestMapping("site")
public class SanphamControler {
	
	@Autowired
 ProductService productService;

	@Autowired
	CustomerService customerService;
	private HttpSession session;
	
	
	@GetMapping("home")
	public String add(Model model) {
		List<Product> ls = productService.findAll();
		model.addAttribute("products",ls);
		
		
		model.addAttribute("customer", ls);
		return "site/customers/home";
	}
	
	@GetMapping("/viewPro")
    public String viewPro() {
    	return "site/customers/list";
    }
	
	@GetMapping("edit/{productId}")
	public  String edit(ModelMap model, @PathVariable("productId") Long productId) {
		
		Optional<Product> opt = productService.findById(productId);
		ProductDto dto = new ProductDto();

		if (opt.isPresent()) {
			Product entity = opt.get();
			
			BeanUtils.copyProperties(entity, dto);
            
		dto.setProductId(entity.getProductId());
			
	System.out.println("Name:"+dto.getName()+dto.getDescription()+dto.getQuantity());

			model.addAttribute("products", dto);
			return "forward:/site/viewPro";
		}


		return "site/home";
	}

//	@GetMapping("buyProduct/{productid}")
//	public  String card(Model model, @PathVariable("productid") Long productid) {
//		 int nd = (Integer) session.getAttribute("username");
//		 String  user = String.valueOf(nd);
//		 if(user == null) {
//			 return "redirect:/login";
//		 }
//		Optional<Customer1> acc = customerService.findById(nd);
//		 Customer1 cus = acc.get();
//		 Optional<Product> pro = productService.findById(productid);
//		 Product prod = pro.get();
//		 if(prod != null) {
//			 if(session.getAttribute("cart") ==null) {
//				 Item item = new Item();
//				 List<Item> ls = new ArrayList<>();
//				 Cart
//				 
		 
		 
	}
	