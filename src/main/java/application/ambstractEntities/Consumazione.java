package application.ambstractEntities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Consumazione extends ElementoVendibile {
	protected long calorie;
}
