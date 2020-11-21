package sh.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sh.entities.Customers;
import sh.models.Login;
import sh.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService ls ;
	
	@RequestMapping("/login")
	public String login(Model model) {
		Login login = new Login();
		model.addAttribute("command", login);
		return "index";
	}
	
	@RequestMapping("/auth")
	public String authentication(@RequestParam("email")String email, @RequestParam("password")String password, HttpSession session) {
		Customers customer = ls.findCustomer(email, password);
		if(customer != null ) {//handle NoResultFound Ex for email
			session.setAttribute("customer", customer);
			session.setAttribute("cart", new ArrayList<Integer>());
			return "menu";
		}
		else 
			return "failed";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
}
