package application.concreteEntities;

import java.util.ArrayList;
import java.util.List;

import application.ambstractEntities.Consumazione;
import lombok.Getter;

@Getter
public class Menu {
	protected List<Consumazione> pizze = new ArrayList<>();
	protected List<Consumazione> bibite = new ArrayList<>();
	protected List<String> aggiunte = new ArrayList<>();
	protected List<Franchise> gadget = new ArrayList<>();

	public void printMenu() {
		System.out.println();
		System.out.println("******************MENU'******************");
		System.out.println();
		System.out.println("PIZZE:");
		System.out.println();

		this.pizze.forEach(el -> {
			System.out.println(el);
			System.out.println();
		});

		System.out.println("BIBITE:");
		System.out.println();

		this.bibite.forEach(el -> {
			System.out.println(el);
			System.out.println();
		});

		System.out.println("AGGIUNTE:");
		System.out.println();

		this.aggiunte.forEach(el -> {
			System.out.println(el);
			System.out.println();
		});

		System.out.println("GADGET:");
		System.out.println();

		this.gadget.forEach(el -> {
			System.out.println(el);
			System.out.println();
		});
	}
}
