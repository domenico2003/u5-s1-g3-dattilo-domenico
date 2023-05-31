package application.orders;

import application.ambstractEntities.Consumazione;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ElementoOrdine {
	private Consumazione ordinazione;
	private String nota;
}
