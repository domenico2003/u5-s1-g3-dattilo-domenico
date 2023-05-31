package application.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Tavolo {
	private int numero;
	private int copertiMassimi;
	private StatoTavolo stato;
}
