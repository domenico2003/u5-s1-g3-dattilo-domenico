package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import application.ambstractEntities.ElementoVendibile;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		System.out.println((ElementoVendibile) ctx.getBean("shirt"));
		ctx.close();
	}
}
