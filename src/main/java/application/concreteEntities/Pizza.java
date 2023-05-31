package application.concreteEntities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.ambstractEntities.Consumazione;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Pizza extends Consumazione {
	protected List<String> ingredienti = new ArrayList<>(Arrays.asList("pomodoro", "mozzarella"));

	public Pizza(String nome, double prezzo, long calorie) {
		super();
		name = nome;
		this.prezzo = prezzo;
		this.calorie = calorie;
	}

	public void addIngredienti(List<String> ingredienti) {
		ingredienti.addAll(ingredienti);
	}

	@Override
	public String toString() {
		return name + " [calorie=" + calorie + ", name=" + name + ", prezzo=" + prezzo + "]";
	}

}
