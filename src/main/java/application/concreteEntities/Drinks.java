package application.concreteEntities;

import application.ambstractEntities.Consumazione;
import lombok.Data;

@Data
public class Drinks extends Consumazione {
	private double grandezza;

	public Drinks(String name, long calorie, double prezzo, double size) {

		this.name = name;
		this.calorie = calorie;
		this.prezzo = prezzo;
		grandezza = size;
	}

	@Override
	public String toString() {
		return name + " [grandezza=" + grandezza + ", calorie=" + calorie + ", name=" + name + ", prezzo=" + prezzo
				+ "]";
	}

}
