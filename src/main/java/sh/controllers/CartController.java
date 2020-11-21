package sh.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sh.entities.Pricing;
import sh.models.SelectedSizePrice;
import sh.services.MenuService;

@Controller
public class CartController {
	
	@Autowired
	MenuService ms; 

	
	@RequestMapping("/addCart")
	public String addToCart(@RequestParam("type")String type, SelectedSizePrice price, HttpSession session) {//here SelectedSizePrice is only get binded by through spring form tags if we dont use sf: then we wont get data from form
		List<Integer> cart = (List<Integer>) session.getAttribute("cart"); 
		for(String priceId : price.getSp()) {
			int pId = Integer.parseInt(priceId);
			cart.add(pId);
		}
		System.out.println("TYPE ------------------------------------>" + type);
		//String t = request.getParameter("type");
		if (type.equals("Veg"))
			return "forward:menuVeg";
		else
			return "forward:menuNonVeg";
	}
	
	@RequestMapping("/showCart")
	public String showCart(Model model, HttpSession session) {
		List<Pricing> itemPrice = new ArrayList<Pricing>();
		List<Integer> cart = (List<Integer>)session.getAttribute("cart");//getting the cart +nt in the session
		for(int priceId : cart) {
			Pricing p = ms.fetchByItemPrice(priceId);
			itemPrice.add(p);
		}
		model.addAttribute("priceList", itemPrice);
		return "cart";
	}
	
	
//	public String showCart(Model model, HttpSession session) {
//		List<Items> itemList = new ArrayList<Items>();
//		List<Integer> cart = (List<Integer>)session.getAttribute("cart");//getting the cart +nt in the session
//		for(int itemId : cart) {
//			Items item = ms.fetchById(itemId);
//			//System.out.println("showCart--> "+item);
//			itemList.add(item);
//		}
//		model.addAttribute("itemList", itemList);
//		return "cart";
//	}
	
}
