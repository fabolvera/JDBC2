package net.tecgurus.jdbc2.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.tecgurus.jdbc2.dao.CursoDao;
import net.tecgurus.jdbc2.model.Curso;
import net.tecgurus.jdbc2.model.Menu;

public class CursoService extends Menu {
	public static char opc;
	public static String teclado;

	public void setOpc(String teclado) {
		if (validaDato(teclado)) {
			this.opc = teclado.toLowerCase().charAt(0);
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
		System.out.println(" * * MENU CURSOS * * ");
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
		} while (opc != '5');
		{
			super.mostrarMenu();
		}
	}

	@Override
	public void agregar() throws SQLException, ClassNotFoundException {
		String nombre;

		System.out.println(" * * AGREGAR CURSO * * ");
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso: ");
		nombre = in.nextLine();

		Curso curso = new Curso();
		curso.setNombre(nombre);

		System.out.println(curso);
		CursoDao cursoDao = new CursoDao();
		cursoDao.agregar(curso);

	}

	@Override
	public void listar() throws SQLException, ClassNotFoundException {
		System.out.print("* * * LISTADO DE CURSOS * * *");
		CursoDao cursoDao = new CursoDao();
		List<Curso> listCursos = new ArrayList<>();
		listCursos = cursoDao.listar();
		for (Curso curso : listCursos) {
			System.out.println(curso);
		}
	}

	@Override
	public void eliminar() throws SQLException, ClassNotFoundException {
		String dato;
		System.out.println("* * ELIMINAR CURSOS * *");
		Scanner in = new Scanner(System.in);		
		int id = 0;
		do {
			System.out.println("Ingresar el ID del curso a eliminar: ");
			dato = in.nextLine();
			if(super.isNumeric(dato)){
				id = Integer.parseInt(dato);
			}
			else {
				System.out.println("Debe ingresar un número ");
			}
		}while(super.isNumeric(dato)==false);

		CursoDao cursoDao = new CursoDao();
		cursoDao.eliminar(id);
	}


	@Override
	public void actualizar() throws SQLException, ClassNotFoundException {
		String nombre;
		int id = 0;
		String dato;
		System.out.println(" * * ACTUALIZAR CURSO * * ");
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println("Ingresar el ID del curso a actualizar: ");
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

		Curso curso = new Curso();
		curso.setNombre(nombre);
		curso.setId(id);
		System.out.println(curso);
		CursoDao cursoDao = new CursoDao();
		cursoDao.actualizar(curso);

		// in.close(); --segun yo este cierre, al regresar la menu principal truena el
		// programa

	}

	@Override
	public void salir() {
		System.out.print("  Adios :) ");
	}
}
