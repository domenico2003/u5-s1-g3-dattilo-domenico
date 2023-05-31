package application.orders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
@Scope("prototype")
@PropertySource("classpath:application.properties")
public class Ordine {

	private int NumeroOrdine = new Random().nextInt();
	private OrdineStatus stato;
	private int numeroCoperti;
	private final LocalDateTime oraDiAcquisizione = LocalDateTime.now();
	private List<ElementoOrdine> ordini = new ArrayList<>();

	@Value("${GodFatherPizzaApplication.costoCoperto}")
	private int costoCoperto;

	private double totale;

	public void init() {
		System.out.println(numeroCoperti);
		totale = costoCoperto * numeroCoperti;
	}

	public void totale() {
		double costOrdini = 0;
		for (ElementoOrdine eo : this.ordini) {
			costOrdini += eo.getOrdinazione().getPrezzo();
		}
		this.setTotale(costOrdini + (costoCoperto * numeroCoperti));
	}

	public void addOrdine(ElementoOrdine ordinazione) {
		ordini.add(ordinazione);
		this.totale();
	}

}
