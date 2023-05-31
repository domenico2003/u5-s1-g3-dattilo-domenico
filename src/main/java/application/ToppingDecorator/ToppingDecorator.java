package application.ToppingDecorator;

import application.ambstractEntities.Consumazione;

public class ToppingDecorator extends Consumazione {
	protected Consumazione pizza;

	public ToppingDecorator(Consumazione pizza) {
		this.pizza = pizza;
	}

	public String getName() {
		return pizza.getName() + " + " + name;
	}

	public double getPrezzo() {
		return pizza.getPrezzo() + prezzo;
	}

	public long getCalorie() {
		return pizza.getCalorie() + calorie;
	}

	@Override
	public String toString() {
		return "pizza" + getName() + ", prezzo =" + getPrezzo() + ", calorie = " + getCalorie();
	}

}
