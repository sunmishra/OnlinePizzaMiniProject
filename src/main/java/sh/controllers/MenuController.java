package sh.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sh.entities.Items;
import sh.entities.Pricing;
import sh.entities.SizeandPrice;
import sh.models.SelectedSizePrice;
import sh.services.MenuService;

@Controller
public class MenuController {

	@Autowired
	private MenuService ms;
	
	@RequestMapping("/menu")
	public String menuList(Model model) {
//		List<Items> menuListVeg = ms.fetchByVegItems();
//		List<Items> menuListNonVeg = ms.fetchByNonVegItems();
//		model.addAttribute("VegList",menuListVeg);
//		model.addAttribute("NonVegList",menuListNonVeg);
		return "menu";
	}
	
	@RequestMapping("/menuVeg")
	public String vegItems(Model model) {
		List<Items> menuListVeg = ms.fetchByVegItems();
		model.addAttribute("vegList",menuListVeg);
		return "veg";
	}
	
	@RequestMapping("/menuNonVeg")
	public String nonVegItems(Model model) {
		List<Items> menuListNonVeg = ms.fetchByNonVegItems();
		model.addAttribute("nonVegList",menuListNonVeg);
		return "nonveg";
	}
	
	@RequestMapping("/details")
	public String itemDetails( @RequestParam("id")int id, Model model) {//here id is used to capture incoming data from veg/nonveg.jsp
		Items item = ms.fetchById(id);
		model.addAttribute("item", item);
		List<SizeandPrice> sp = new ArrayList<SizeandPrice>();
		for(Pricing p : item.getPricingList()) {
			sp.add(ms.pricing_size(p));
		}
		model.addAttribute("spList", sp);
		
		model.addAttribute("sp", new SelectedSizePrice());
		return "details";
	}
	
	
	
	
//	public String itemDetails(@RequestParam("id")int id, Model model) {//here id is used to capture incoming data from jsp
//		Items item = ms.fetchById(id);
//		model.addAttribute("item", item);
//		List<SizeandPrice> sp = new ArrayList<SizeandPrice>();
//		for(Pricing p : item.getPricingList()) {
//			sp.add(ms.pricing_size(p));
//		}
//		model.addAttribute("spList", sp);
//		
//		model.addAttribute("sp", new SelectedSizePrice());
//		return "details";
//	}
}
