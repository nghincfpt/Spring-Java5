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


import edu.poly.shop.domain.Category;
import edu.poly.shop.model.CategoryDto;
import edu.poly.shop.service.CategoryService;

@Controller
@RequestMapping("admin/categories")
public class CatogoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new CategoryDto());
		return "admin/categories/addOrEdit";
	}

	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") long categoryId) {
		Optional<Category> opt = categoryService.findById(categoryId);
		CategoryDto dto = new CategoryDto();
 
		if (opt.isPresent()) {
			Category entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			
           dto.setIsEdit(true);
           
			model.addAttribute("category", dto);
			return new ModelAndView("admin/categories/addOrEdit", model);
		}
		model.addAttribute("message", "category is not extsted");

		return new ModelAndView("redirect:/admin/categories", model);
	}

	
	@GetMapping("view/{categoryId}")
	public ModelAndView view(ModelMap model, @PathVariable("categoryId") long categoryId) {

		Optional<Category> opt = categoryService.findById(categoryId);

		CategoryDto dto = new CategoryDto();
	
			Category entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			 
			dto.setIsEdit(true);
		model.addAttribute("dto", dto);
		
		return new ModelAndView("redirect:/admin/categories", model);
	}

	@GetMapping("delete/{categoryId}")
	public ModelAndView  delete(ModelMap model,@PathVariable("categoryId") Long categoryId) {
		
		categoryService.deleteById(categoryId);
		
		model.addAttribute("message","category is deleted!");
		
		return new ModelAndView( "forward:/admin/categories/search",model);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") Category dto,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/categories/addOrEdit");
		}

		Category entity = new Category();

		BeanUtils.copyProperties(dto, entity);
		categoryService.save(entity);

		model.addAttribute("message", "category is saved!");
		return new ModelAndView("forward:/admin/categories", model);
	}

	@RequestMapping("")
	public String list(ModelMap model) {
		List<Category> list = categoryService.findAll();

		model.addAttribute("categories", list);
		return "admin/categories/list";
	}

	@GetMapping("search")
	public String search(ModelMap model,
			 @RequestParam(name = "name", required= false) String name) {
		
		 List<Category> list = null;
		if(StringUtils.hasText(name)) {
			 list = categoryService.findByNameContaining(name);
		 }else {
			 list = categoryService.findAll();
		 }
		
		model.addAttribute("categories", list);
		
		return "admin/categories/search";
	}
// phan trang
	@GetMapping("searchpaginated")
	public String search(ModelMap model,
			 @RequestParam(name = "name", required= false) String name,
			 @RequestParam("page") Optional<Integer> page,
			 @RequestParam("size") Optional<Integer> size) {
		
		int currentpage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Pageable pageable = PageRequest.of(currentpage-1, pageSize,Sort.by("name"));
		//Pageable pageable = PageRequest.of(currentpage, pageSize,Sort.by("name"));
		
		Page<Category> resultPage = null;
		
		 
		if(StringUtils.hasText(name)) {
			 resultPage = categoryService.findByNameContaining(name,pageable);
			 model.addAttribute("name",name);
			 System.out.println("ljsdlfjsdf    "+resultPage.getContent().size() + " ----- " + name);
		 }else {
			 resultPage = categoryService.findAll(pageable);
		 }
		
		 int  totaPages = resultPage.getTotalPages();
		 System.out.println("Total page: " + totaPages);
		 if(totaPages > 0) {
			 int start = Math.max(1, currentpage-2);
			 int end = Math.min(currentpage + 2, totaPages);
		
		 if(totaPages >5) {
			 if(end == totaPages) start = end-5;
			 else if (start == 1 ) end = start +5;
		 }
		 List<Integer> pagenumbers = IntStream.rangeClosed(start, end)
				 .boxed()
				 .collect(Collectors.toList());
		model.addAttribute("pagenumbers",pagenumbers);
		 }
		 
		model.addAttribute("categoryPage", resultPage);
		
		return "admin/categories/searchpaginated";
	}
}
