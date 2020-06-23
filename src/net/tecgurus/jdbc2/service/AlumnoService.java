package net.tecgurus.jdbc2.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.tecgurus.jdbc2.dao.AlumnoDao;
import net.tecgurus.jdbc2.model.Alumno;
import net.tecgurus.jdbc2.model.Menu;

public class AlumnoService extends Menu {
	private char opc;
	public String teclado;

	public void setOpc(String teclado) {
		if (validaDato(teclado)) {
			this.opc = teclado.toLowerCase().charAt(0);
			// System.out.println("Dato: " + this.opcion);
		} else {
			System.out.println("Dato no valido ");
		}
	}

	public char getOpc() {
		return this.opc;
	}

	@Override
	public void mostrarMenu() {
		System.out.println();
		System.out.println(" * * MENU ALUMNOS* * ");
		System.out.println("1 - Agregar");
		System.out.println("2 - Listar ");
		System.out.println("3 - Actualizar ");
		System.out.println("4 - Eliminar");
		System.out.println("5 - Salir");
		System.out.print("Ingrese una opcion del 1 al 5: ");

	}

	public void controla() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		do {
			limpiaMenu();
			mostrarMenu();
			teclado = sc.nextLine();

			if (teclado != null) {
				setOpc(teclado);
				opc = getOpc();
			} else {
				opc = '0';
			}

			switch (opc) {
			case '1':
				agregar();
				break;
			case '2':
				listar();
				break;
			case '3':
				actualizar();
				break;
			case '4':
				eliminar();
				break;
			case '5':
				salir();
				break;
			default:
				System.out.println("Debe ingresar una opción del 1 al 5 ");
				break;
			}
			// System.in.read(); // Lo vi en el LibroPiensaEnJava - Hoja 121 - ESPERA UN
			// ENTER // Hacer una pausa para ver los resultados

		} while (opc != '5');
		{
			super.mostrarMenu();
		}
	}

	@Override
	public void agregar() throws SQLException, ClassNotFoundException {
		char genero = '\u0000';
		String nombre;
		String email;
		int edad=0;
		String dato;
		System.out.println(" * * AGREGAR ALUMNO");
		Scanner in = new Scanner(System.in);
		System.out.println("Ingresar el nombre: ");
		nombre = in.nextLine();
		System.out.print("Ingresar el correo: ");
		email = in.nextLine();
		System.out.print("Ingresar la edad: ");
		dato = in.nextLine();
		if(super.isNumeric(dato)){
			edad = Integer.parseInt(in.nextLine());
		}

		System.out.print("Ingresar genero M o F: ");
		dato = in.next().toLowerCase();
		genero= dato.charAt(0);		
		// in.close(); --Cerrar scanner, pero al regresar al menu principal truena el
		// programa, yano permite leer nuevamente un dato de la consola

		Alumno alumno = new Alumno();
		alumno.setNombre(nombre);
		alumno.setEmail(email);
		alumno.setEdad(edad);
		alumno.setGenero(genero);
		System.out.println(alumno);
		AlumnoDao alumnoDao = new AlumnoDao();
		alumnoDao.agregar(alumno);

	}

	@Override
	public void listar() throws SQLException, ClassNotFoundException {
		System.out.print("* * * LISTADO DE ALUMNOS * * *");
		AlumnoDao alumnoDao = new AlumnoDao();
		List<Alumno> listAlummnos = new ArrayList<>();
		listAlummnos = alumnoDao.listar();
		for (Alumno alumno : listAlummnos) {
			System.out.println(alumno);
		}
	}

	@Override
	public void eliminar() throws SQLException, ClassNotFoundException {
		String dato;
		int id =0;
		System.out.println("* * ELIMINAR ALUMNO * *");
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Ingresar el ID del alumno a eliminar: ");
			dato = in.nextLine();
			if(super.isNumeric(dato)){
				id = Integer.parseInt(dato);
			}
			else {
				System.out.println("Debe ingresar un número ");
			}
		}while(super.isNumeric(dato)==false);
		// in.close(); --Cerrar scanner, pero al regresar al menu principal truena el
		// programa, yano permite leer nuevamente un dato de la consola

		AlumnoDao alumnoDao = new AlumnoDao();
		alumnoDao.eliminar(id);
	}

	@Override
	public void actualizar() throws SQLException, ClassNotFoundException {
		char genero = '\u0000';
		String nombre;
		String email;
		int edad=0;
		int id = 0;
		String dato;
		System.out.println(" * * ACTUALIZAR ALUMNO * * ");
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Ingresar el ID del alumno a actualizar: ");
			dato = in.nextLine();
			if(super.isNumeric(dato)){
				id = Integer.parseInt(dato);
			}
			else {
				System.out.println("Debe ingresar un número ");
			}
		}while(super.isNumeric(dato)==false);
		System.out.println("Ingresar el nombre: ");
		nombre = in.nextLine();

		System.out.print("Ingresar el correo: ");
		email = in.nextLine();

		do {
			System.out.println("Ingresar la edad: ");
			dato = in.nextLine();
			if(super.isNumeric(dato)){
				edad = Integer.parseInt(dato);
			}
			else {
				System.out.println("Debe ingresar un número ");
			}
		}while(super.isNumeric(dato)==false);

		System.out.print("Ingresar genero M o F: ");
		dato = in.next().toLowerCase();
		genero= dato.charAt(0);

		Alumno alumno = new Alumno();
		alumno.setNombre(nombre);
		alumno.setEmail(email);
		alumno.setEdad(edad);
		alumno.setGenero(genero);
		alumno.setId(id);
		System.out.println(alumno);
		AlumnoDao alumnoDao = new AlumnoDao();
		alumnoDao.actualizar(alumno);
		// in.close(); --Cerrar scanner, pero al regresar al menu principal truena el
		// programa, yano permite leer nuevamente un dato de la consola

	}

	@Override
	public void salir() {
		System.out.print("  Adios :) ");
	}

}
