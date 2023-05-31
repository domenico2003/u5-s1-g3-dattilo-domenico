package application.ToppingDecorator;

import application.ambstractEntities.Consumazione;

public class Cheese extends ToppingDecorator {

	public Cheese(Consumazione pizza) {
		super(pizza);
		this.name = "formaggio";
		this.prezzo = 0.69;
		this.calorie = 92;
	}

}
