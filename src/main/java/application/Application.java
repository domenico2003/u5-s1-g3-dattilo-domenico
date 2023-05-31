package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {
	static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		ctx.close();

	}

	public static AnnotationConfigApplicationContext context() {
		return ctx;
	}

}
