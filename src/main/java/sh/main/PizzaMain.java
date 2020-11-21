package sh.main;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sh.entities.Items;
import sh.services.MenuService;

public class PizzaMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		
//		LoginService service = ctx.getBean(LoginService.class);
//		Customers c = service.fetchCustomer("sun@gmail.com");
//		System.out.println(c);
//		Customers c1 = new Customers(12, "Star", "star", "777777", "xyz", "star@gmail.com");
//		service.addCustomer(c1);

		MenuService service = ctx.getBean(MenuService.class);
//		List<Items> list = service.fetchByTypeAndCat();
		List<Items> list = service.fetchByNonVegItems();
//		List<Items> list = service.fetchByCat();

		System.out.println(list);
		System.out.println(service.fetchById(32));
//		System.out.println(service.fetchByItemPrice(20));
	
//		OrderService service = ctx.getBean(OrderService.class);
//		System.out.println(service.fetchOrderById(1005));
//		System.out.println(service.fetchOrderByTime());	
		ctx.close();
		
	}

}
