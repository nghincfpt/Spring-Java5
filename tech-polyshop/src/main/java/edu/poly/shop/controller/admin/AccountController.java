package edu.poly.shop.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.Category;
import edu.poly.shop.model.AccountDto;
import edu.poly.shop.service.AccountService;
import edu.poly.shop.service.CategoryService;

@Controller
@RequestMapping("admin/accounts")
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping("add")
	public String add(Model model) {
		
		model.addAttribute("account", new AccountDto());
		return "admin/accounts/addOrEdit";
	}
	

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("account") Account dto,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/accounts/addOrEdit");
		}

		Account entity = new Account();
// copy thông tin ng dùng nhập vào form
		BeanUtils.copyProperties(dto, entity);
		accountService.save(entity);

		model.addAttribute("message", "account is saved!");
		return new ModelAndView("forward:/admin/accounts", model);
	}
	

	@RequestMapping("")
	public String list(ModelMap model) {
		List<Account> list = accountService.findAll();

		model.addAttribute("accounts", list);
		return "admin/accounts/list";
	}


	@GetMapping("edit/{username}")
	public ModelAndView edit(ModelMap model, @PathVariable("username") String username) {
		
		Optional<Account> opt = accountService.findById(username);
		
		AccountDto dto = new AccountDto();
 
		if (opt.isPresent()) {
			Account entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			
           dto.setIsEdit(true);
           
           // k gửi thông tin password về
           dto.setPassword("");
           
			model.addAttribute("account", dto);
			return new ModelAndView("admin/accounts/addOrEdit", model);
		}
		model.addAttribute("message", "account is not extsted");

		return new ModelAndView("forward:/admin/accounts", model);
	}

	@GetMapping("delete/{username}")
	public ModelAndView  delete(ModelMap model,@PathVariable("username") String username) {
		
		accountService.deleteById(username);
		
		model.addAttribute("message","account is deleted!");
		
		return new ModelAndView( "forward:/admin/accounts",model);
	}

	
	//th:if="${#fields.hasErrors('password')}"
	
	//   th:if="${#fields.hasErrors('username')}"
//	@PostMapping("saveOrUpdate")
//	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("account") Category dto,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			return new ModelAndView("admin/accounts/addOrEdit");
//		}
//
//		Category entity = new Category();
//
//		BeanUtils.copyProperties(dto, entity);
//		categoryService.save(entity);
//
//		model.addAttribute("message", "account is saved!");
//		return new ModelAndView("forward:/admin/accounts", model);
//	}
//
//	@RequestMapping("")
//	public String list(ModelMap model) {
//		List<Category> list = categoryService.findAll();
//
//		model.addAttribute("accounts", list);
//		return "admin/accounts/list";
//	}
//
//	@GetMapping("search")
//	public String search(ModelMap model,
//			 @RequestParam(name = "name", required= false) String name) {
//		
//		 List<Category> list = null;
//		if(StringUtils.hasText(name)) {
//			 list = categoryService.findByNameContaining(name);
//		 }else {
//			 list = categoryService.findAll();
//		 }
//		
//		model.addAttribute("accounts", list);
//		
//		return "admin/accounts/search";
//	}
//// phan trang
//	@GetMapping("searchpaginated")
//	public String search(ModelMap model,
//			 @RequestParam(name = "name", required= false) String name,
//			 @RequestParam("page") Optional<Integer> page,
//			 @RequestParam("size") Optional<Integer> size) {
//		
//		int currentpage = page.orElse(1);
//		int pageSize = size.orElse(5);
//		
//		Pageable pageable = PageRequest.of(currentpage-1, pageSize,Sort.by("name"));
//		//Pageable pageable = PageRequest.of(currentpage, pageSize,Sort.by("name"));
//		
//		Page<Category> resultPage = null;
//		
//		 
//		if(StringUtils.hasText(name)) {
//			 resultPage = categoryService.findByNameContaining(name,pageable);
//			 model.addAttribute("name",name);
//			 System.out.println("ljsdlfjsdf    "+resultPage.getContent().size() + " ----- " + name);
//		 }else {
//			 resultPage = categoryService.findAll(pageable);
//		 }
//		
//		 int  totaPages = resultPage.getTotalPages();
//		 if(totaPages > 0) {
//			 int start = Math.max(1, currentpage-2);
//			 int end = Math.min(currentpage + 2, totaPages);
//		
//		 if(totaPages >5) {
//			 if(end == totaPages) start = end-5;
//			 else if (start == 1 ) end = start +5;
//		 }
//		 List<Integer> pagenumbers = IntStream.rangeClosed(start, end)
//				 .boxed()
//				 .collect(Collectors.toList());
//		model.addAttribute("pagenumbers",pagenumbers);
//		 }
//		 
//		model.addAttribute("categoryPage", resultPage);
//		
//		return "admin/accounts/searchpaginated";
//	}
}
