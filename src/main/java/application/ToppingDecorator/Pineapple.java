package application.ToppingDecorator;

import application.ambstractEntities.Consumazione;

public class Pineapple extends ToppingDecorator {

	public Pineapple(Consumazione pizza) {
		super(pizza);
		this.name = "ananas";
		this.prezzo = 0.79;
		this.calorie = 24;
	}

	public String StampAdd() {
		return this.name + " = calorie: " + this.calorie + ", prezzo: " + this.prezzo + "$";
	}
}
