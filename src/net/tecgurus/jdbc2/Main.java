package net.tecgurus.jdbc2;


import java.sql.SQLException;
import java.util.Scanner;

import net.tecgurus.jdbc2.model.Menu;
import net.tecgurus.jdbc2.service.AlumnoService;
import net.tecgurus.jdbc2.service.CursoService;

public class Main {
	public static char opc;
	public static String entrada;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println(" Ejercicio Menu ");
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);

		do {
			menu.limpiaMenu();
			menu.mostrarMenu();
			entrada = sc.nextLine();
			if (entrada != null) {
				menu.setOpcion(entrada);
				opc = menu.getOpcion();
				// System.out.println("Valor en Main: " + opcMain);
			} else {
				opc = '0';
			}

			switch (opc) {
			case '1':
				AlumnoService as = new AlumnoService();
				as.controla();
				break;
			case '2':
				CursoService cs = new CursoService();
				cs.controla();
				break;
			case '3':
				menu.salir();
				break;
			default:
				System.out.println("Debe ingresar una opción del 1 al 3 ");
				break;
			}

		} while (opc!= '3');
		{

			System.exit(0);
			sc.close();
			System.out.println(" BYE ");
		}

	}
}
