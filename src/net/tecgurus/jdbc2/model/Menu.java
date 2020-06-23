package net.tecgurus.jdbc2.model;
import java.sql.SQLException;


public class Menu {
	private char opcion;

	public void limpiaMenu() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	protected static boolean isNumeric(String dato){
		try {
			Integer.parseInt(dato);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

	public void mostrarMenu() {
		limpiaMenu();
		System.out.println(" * * MENU * * ");
		System.out.println("1 - Alumnos");
		System.out.println("2 - Cursos ");
		System.out.println("3 - Salir");
		System.out.print("Ingrese una opción del 1 al 3: ");
	}

	public boolean validaDato(String teclado) {
		boolean temp;
		if (teclado.length() > 0) {
			temp = true;
		} else {
			// setOpcion('0');
			temp = false;
		}
		return temp;
	}

	public void setOpcion(String teclado) {
		if (validaDato(teclado)) {
			this.opcion = teclado.toLowerCase().charAt(0);
			// System.out.println("Dato: " + this.opcion);
		} else {
			System.out.println("Dato no valido ");
		}
	}

	public char getOpcion() {
		return this.opcion;
	}


	public void agregar() throws SQLException, ClassNotFoundException {

	}

	public void listar() throws SQLException, ClassNotFoundException {

	}

	public void eliminar() throws SQLException, ClassNotFoundException {

	}

	public void actualizar() throws SQLException, ClassNotFoundException {

	}

	public void salir() {
		System.out.print("  Adios :) ");
	}
}
