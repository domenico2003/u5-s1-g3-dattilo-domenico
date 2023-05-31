package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
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
		// Ordine ordine = createOrdine(ctx, 6, OrdineStatus.pronto);
//		ordine.addOrdine(new ElementoOrdine((Consumazione) ctx.getBean("margherita"), "test1"));
//		ordine.addOrdine(new ElementoOrdine((Consumazione) ctx.getBean("acqua"), "test2"));
//		salvaOrdine(ctx, ordine);
//		log.info(ordine.toString());

		Scanner scan = new Scanner(System.in);
		int enter = -1;
		while (enter != 0) {
			System.out.println("scegli l'opzione");
			System.out.println();
			System.out.println("0. esci");
			System.out.println("1. crea ordine");
			System.out.println("2. leggi tutte le ordinazioni");

			enter = scan.nextInt();
			scan.nextLine();
			switch (enter) {
			case 1:
				System.out.println("inserisci numero coperti: ");
				int coperti = scan.nextInt();
				scan.nextLine();
				System.out.println("inserisci stato dell'ordine(in_corso, pronto, servito): ");
				String stato = scan.nextLine();
				Ordine ordine = createOrdine(ctx, coperti, OrdineStatus.valueOf(stato));

				System.out.println("ORDINE: ");
				System.out.println(ordine.toString());

				int orderEnter = 0;
				while (orderEnter == 1 | orderEnter == 0) {
					System.out.println("scegli opzione: ");
					System.out.println("1. aggiungi ordinazione");
					System.out.println("2. salvare l'ordine");
					orderEnter = scan.nextInt();
					scan.nextLine();
					switch (orderEnter) {
					case 1:
						System.out.println("scegli pizza o bibita");
						String alimento = scan.nextLine();
						System.out.println("inserisci nota:");
						String nota = scan.nextLine();

						ordine.addOrdine(new ElementoOrdine((Consumazione) ctx.getBean(alimento), nota));
						break;
					}

				}
				salvaOrdine(ctx, ordine);
				break;

			case 2:
				System.out.println("ELENCO ORDINAZIONI:");
				String[] ordini = leggiOrdini(ctx);
				for (String el : ordini) {
					System.out.println();

					System.out.println(el);

				}
				System.out.println();
				break;
			}

		}
		scan.close();
	}

	public static Ordine createOrdine(AnnotationConfigApplicationContext ctx, int coperti, OrdineStatus stato) {
		Ordine o1 = ctx.getBean(Ordine.class);
		o1.setNumeroCoperti(coperti);
		o1.init();
		o1.setStato(stato);

		return o1;
	}

	public static void salvaOrdine(AnnotationConfigApplicationContext ctx, Ordine dato) {

		File file = (File) ctx.getBean("file");
		try {
			FileUtils.writeStringToFile(file, dato.toString() + ";" + System.lineSeparator(), "UTF-8", true);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static String[] leggiOrdini(AnnotationConfigApplicationContext ctx) {
		File file = (File) ctx.getBean("file");
		String[] ordini = null;
		try {
			ordini = FileUtils.readFileToString(file, "UTF-8").split(";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordini;
	}
}