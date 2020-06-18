package net.tecgurus.jdbc2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import net.tecgurus.jdbc2.dao.AlumnoDao;
import net.tecgurus.jdbc2.model.Menu;


public class Main {

	public static void main (String[] args) throws SQLException {		
		System.out.println(" Ejercicio Menu ");		
		Menu menu=new Menu();
		Scanner sc = new Scanner(System.in);
		int opc;
		do {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			menu.mostrarMenu();
			menu.setOpcion(sc.nextLine());
			try {				
				switch (menu.getOpcion()) {
				case 1:				
					menu.agregar();
					break;
				case 2:				
					try {						
						menu.listar();
						System.out.println();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:				
					menu.actualizar();
					break;
				case 4:				
					menu.eliminar();
					break;
				case 5:				
					menu.salir();				
					break;
				default:				
					System.out.println ("Ingrese una opción del 1 al 5");
					break;
				}
				//System.in.read();  // Lo vi en el LibroPiensaEnJava - Hoja 121 - ESPERA UN ENTER	// Hacer una pausa para ver los resultados 
			}	catch (Exception e) {System.out.println(e); }		
			
			
		}while(menu.getOpcion() != 5 );		
		sc.close();			
	}
}
