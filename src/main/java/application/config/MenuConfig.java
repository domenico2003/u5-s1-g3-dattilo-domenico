package application.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import application.ambstractEntities.Consumazione;
import application.ambstractEntities.ElementoVendibile;
import application.concreteEntities.Drinks;
import application.concreteEntities.Franchise;
import application.concreteEntities.Pizza;

@Configuration
public class MenuConfig {
	@Bean
	public Consumazione margherita() {
		return new Pizza("margherita", 4.99, 1104);
	}

	@Bean
	public Consumazione hawaiiana() {
		Consumazione hawaiiana = new Pizza("hawaiiana", 6.49, 1024);
		((Pizza) hawaiiana).addIngredienti(new ArrayList<String>(Arrays.asList("ham", "pineapple")));
		return hawaiiana;
	}

	@Bean
	public Consumazione salame() {
		Consumazione salame = new Pizza("salame", 5.99, 1160);
		((Pizza) salame).addIngredienti(new ArrayList<String>(Arrays.asList("salame")));
		return salame;
	}

	@Bean
	public Consumazione limonata() {
		return new Drinks("limonata", 128, 1.29, 0.33);
	}

	@Bean
	public Consumazione acqua() {
		return new Drinks("acqua", 0, 1.29, 0.5);
	}

	@Bean
	public Consumazione vino() {
		return new Drinks("vino", 607, 7.49, 0.75);
	}

	@Bean
	public ElementoVendibile shirt() {
		return new Franchise("Shirt", 21.99);
	}

	@Bean
	public ElementoVendibile mug() {
		return new Franchise("mug", 4.99);
	}
}
