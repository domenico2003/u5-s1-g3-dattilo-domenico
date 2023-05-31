package application.ToppingDecorator;

import application.ambstractEntities.Consumazione;

public class Ham extends ToppingDecorator {

	public Ham(Consumazione pizza) {
		super(pizza);
		this.name = "prosciutto";
		this.prezzo = 0.99;
		this.calorie = 35;
	}

}
