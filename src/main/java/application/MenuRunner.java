package application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.concreteEntities.Menu;

@Component
@Order(0)
public class MenuRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = Application.context();
		Menu menu = (Menu) ctx.getBean("menu");
		menu.printMenu();

	}

}
