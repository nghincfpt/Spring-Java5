package edu.poly.shop.controller.site;

import java.util.Collection;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.domain.Product;
import edu.poly.shop.model.CartItem;
import edu.poly.shop.model.ProductDto;
import edu.poly.shop.service.ProductService;
import edu.poly.shop.service.ShoppingCartService;

@Controller
@RequestMapping("shoppingCart")
public class ShoppingController {
	
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ShoppingCartService cartService;
	
	
	@GetMapping("danhsach")
	public String list( Model model) {
      Collection<CartItem> cartItems =  cartService.getCartltems();
       
      model.addAttribute("cartItems", cartItems);
      model.addAttribute("total",cartService.getAmount());
      model.addAttribute("noOfItem",cartService.getCount());
		 
		return "site/shoppingCart/danhsach";
	}
 @GetMapping("add/{productId}")
	public String add(@PathVariable ("productId") Long productId) {
	 
	 Optional<Product> productDto =  productService.findById(productId);
	 if(productDto != null) {
		 	Product product = productDto.get();
			 CartItem item = new CartItem();
			 BeanUtils.copyProperties(product, item);
			 item.setQuantity(1);
			 cartService.add(item);
			
		}
		return "redirect:/shoppingCart/danhsach";
		
	}

 @GetMapping("remove/{productId}")
 public String remove(@PathVariable("productId") Long productId) {
	 cartService.remove(productId);
	 return "redirect:/shoppingCart/danhsach";
 }
 @PostMapping("update")
 public String update( @RequestParam("productId") Integer productId,
		 @RequestParam("quantity") Integer quantity) {
	 cartService.update(productId, quantity);
	 
	 return "redirect:/shoppingCart/danhsach";
 }
 @GetMapping("clear")
 public String clear() {
	 return "redirect:/shoppingCart/danhsach";
 }
 @GetMapping("acount/{productId}")
 public String acount(@PathVariable("productId") Integer productId) {
	 cartService.getAmount();
	 return "redirect:/shoppingCart/danhsach";
 }
}
