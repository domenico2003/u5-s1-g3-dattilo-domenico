package application.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import application.ToppingDecorator.Cheese;
import application.ToppingDecorator.Ham;
import application.ToppingDecorator.Onions;
import application.ToppingDecorator.Pineapple;
import application.ToppingDecorator.Salami;
import application.ambstractEntities.Consumazione;
import application.concreteEntities.Drinks;
import application.concreteEntities.Franchise;
import application.concreteEntities.Menu;
import application.concreteEntities.Pizza;

@Configuration
public class MenuConfig {
	@Bean
	@Scope("singleton")
	public Menu menu() {
		Menu men = new Menu();

		men.getPizze().add(margherita());
		men.getPizze().add(hawaiiana());
		men.getPizze().add(salame());

		men.getBibite().add(acqua());
		men.getBibite().add(vino());
		men.getBibite().add(limonata());

		men.getGadget().add(mug());
		men.getGadget().add(shirt());

		men.getAggiunte().add(cheese().StampAdd());
		men.getAggiunte().add(pineapple().StampAdd());
		men.getAggiunte().add(ham().StampAdd());
		men.getAggiunte().add(onions().StampAdd());
		men.getAggiunte().add(salami().StampAdd());
		return men;
	}

	@Bean
	@Scope("singleton")
	public Consumazione margherita() {
		return new Pizza("margherita", 4.99, 1104);
	}

	@Bean
	@Scope("singleton")
	public Cheese cheese() {
		return new Cheese(margherita());
	}

	@Bean
	@Scope("singleton")
	public Ham ham() {
		return new Ham(margherita());
	}

	@Bean
	@Scope("singleton")
	public Salami salami() {
		return new Salami(margherita());
	}

	@Bean
	@Scope("singleton")
	public Onions onions() {
		return new Onions(margherita());
	}

	@Bean
	@Scope("singleton")
	public Pineapple pineapple() {
		return new Pineapple(margherita());
	}

	@Bean
	@Scope("singleton")
	public Consumazione hawaiiana() {
		Consumazione hawaiiana = new Pizza("hawaiiana", 6.49, 1024);
		((Pizza) hawaiiana).addIngredienti(new ArrayList<String>(Arrays.asList("ham", "pineapple")));
		return hawaiiana;
	}

	@Bean
	@Scope("singleton")
	public Consumazione salame() {
		Consumazione salame = new Pizza("salame", 5.99, 1160);
		((Pizza) salame).addIngredienti(new ArrayList<String>(Arrays.asList("salame")));
		return salame;
	}

	@Bean
	@Scope("singleton")
	public Consumazione limonata() {
		return new Drinks("limonata", 128, 1.29, 0.33);
	}

	@Bean
	@Scope("singleton")
	public Consumazione acqua() {
		return new Drinks("acqua", 0, 1.29, 0.5);
	}

	@Bean
	@Scope("singleton")
	public Consumazione vino() {
		return new Drinks("vino", 607, 7.49, 0.75);
	}

	@Bean
	@Scope("singleton")
	public Franchise shirt() {
		return new Franchise("Shirt", 21.99);
	}

	@Bean
	@Scope("singleton")
	public Franchise mug() {
		return new Franchise("mug", 4.99);
	}
}
