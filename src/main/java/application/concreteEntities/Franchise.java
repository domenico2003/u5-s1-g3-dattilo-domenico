package application.concreteEntities;

import application.ambstractEntities.ElementoVendibile;

public class Franchise extends ElementoVendibile {

	public Franchise(String nome, double prezzo) {
		super();
		name = nome;
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return name + " [name=" + name + ", prezzo=" + prezzo + "]";
	}

}
