//package edu.poly.shop.controller.site;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import edu.poly.shop.domain.Account;
//import edu.poly.shop.domain.Customer;
//import edu.poly.shop.domain.Customer1;
//import edu.poly.shop.model.AccountDto;
//import edu.poly.shop.model.CustomerDto;
//import edu.poly.shop.service.AccountService;
//import edu.poly.shop.service.CustomerService;
//
//@Controller
//@RequestMapping("site/accounts")
//public class CustomerController {
//	@Autowired
//	CustomerService customerService;
//
//	@GetMapping("add")
//	public String add(Model model) {
//		CustomerDto dto = new CustomerDto();
//		dto.setIsEdit(false);
//		
//		model.addAttribute("customer1", dto);
//		return "site/accounts/addOrEdit";
//	}
//	
//	@PostMapping("saveOrUpdate")
//	public ModelAndView saveOrUpdate(ModelMap model,
//			@Valid @ModelAttribute("customer1") Customer1 dto,
//			BindingResult result) {
//		dto.setRegisteredDate(new Date());
//		if (result.hasErrors()) {
//		
//			return new ModelAndView("site/customers/addOrEdit");
//		}
//		
//		Customer1 customer = new Customer1();
//		
//		BeanUtils.copyProperties(dto, customer);
//	 
//		customerService.save(customer);
//		model.addAttribute("message","customer is saved!!");
//		return new ModelAndView("forward:/site/customers", model);
//	}
//	@RequestMapping("")
//	public String list(ModelMap model) {
//		List<Customer1> list = customerService.findAll();
//
//		model.addAttribute("customers1", list);
//		return "site/customers/list";
//	}
//
//	@GetMapping("edit/{customerId}")
//	public ModelAndView edit(ModelMap model, @PathVariable("customerId") String customerId) {
//		
//		Optional<Customer1> opt = customerService.findById(customerId);
//		
//		CustomerDto dto = new CustomerDto();
// 
//		if (opt.isPresent()) {
//			Customer1 entity = opt.get();
//			BeanUtils.copyProperties(entity, dto);
//			
//           dto.setIsEdit(true);
//           
//           // k gửi thông tin password về
//           dto.setPassword("");
//           
//			model.addAttribute("customer1", dto);
//			return new ModelAndView("site/customers/addOrEdit", model);
//		}
//		model.addAttribute("message", "account is not extsted");
//
//		return new ModelAndView("forward:/site/customers", model);
//	}
//	@GetMapping("delete/{customerId}")
//	public ModelAndView  delete(ModelMap model,@PathVariable("customerId") String customerId) {
//		
//		customerService.deleteById(customerId);
//		
//		model.addAttribute("message","customer is deleted!");
//		
//		return new ModelAndView( "forward:/site/customers",model);
//	}

	
	

