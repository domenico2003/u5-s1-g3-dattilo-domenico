package application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.ambstractEntities.Consumazione;
import application.orders.ElementoOrdine;
import application.orders.Ordine;
import application.orders.OrdineStatus;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(1)
public class OrdiniRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = Application.context();
		Ordine ordine = createOrdine(ctx, 6, OrdineStatus.pronto);
		ordine.addOrdine(new ElementoOrdine((Consumazione) ctx.getBean("margherita"), "test1"));
		ordine.addOrdine(new ElementoOrdine((Consumazione) ctx.getBean("acqua"), "test2"));

		log.info(ordine.toString());

	}

	public static Ordine createOrdine(AnnotationConfigApplicationContext ctx, int coperti, OrdineStatus stato) {
		Ordine o1 = ctx.getBean(Ordine.class);
		o1.setNumeroCoperti(coperti);
		o1.init();
		o1.setStato(stato);

		return o1;
	}

}