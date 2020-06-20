package net.tecgurus.jdbc2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import net.tecgurus.jdbc2.model.Menu;


public class Main {
	public static char opc;

	public static void main (String[] args) throws SQLException {		
		System.out.println(" Ejercicio Menu ");		
		Menu menu=new Menu();
		Scanner sc = new Scanner(System.in);
		try { 
		
		do {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			menu.mostrarMenu();			
			String entrada=sc.nextLine();
			if(entrada.length()>0) {
				opc = entrada.toLowerCase().charAt(0);
				System.out.println("Valor de Entrada switch: " + opc);
			}
			else {
				opc = '0';
				System.out.println ("Ingrese una opción del 1 al 5.....");
				break;
			}
			

			//entrada= entrada.trim().toLowerCase();	
			//menu.setOpcion(entrada);				
			 
				switch (opc) {
				case '1':	
						menu.agregar();
					break;
				case '2':										
						menu.listar();				
					break;
				case '3':					
						menu.actualizar();					
					break;
				case '4':					
						menu.eliminar();					
					break;
				case '5':				
					menu.salir();				
					break;
				default:				
					System.out.println ("Ingrese una opción del 1 al 5  ");
					break;
				}
				//System.in.read();  // Lo vi en el LibroPiensaEnJava - Hoja 121 - ESPERA UN ENTER	// Hacer una pausa para ver los resultados 

		}while(opc != 5 && opc != 0 );	
		{
			System.out.println("bye");
            System.exit(0);
            sc.close();
		}
		}catch(Exception e) {
		//sc.close();	
			System.out.println("errorMessage");
            e.printStackTrace();
		}
	}
}
