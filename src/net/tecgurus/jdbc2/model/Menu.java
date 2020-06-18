package net.tecgurus.jdbc2.model;

import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;
import net.tecgurus.jdbc2.dao.AlumnoDao;
import net.tecgurus.jdbc2.db.ConnectionFactory;

public class Menu {

	private int opcion;
	
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
	
	public int cleanOpcion(String teclado) {
		int opc;
		String temp = teclado.trim().toLowerCase();	
		switch (temp) {
			case "1":				
				opc=1;
				break;
			case "2":				
				opc=2;
				break;
			case "3":				
				opc=3;
				break;
			case "4":				
				opc=4;
				break;
			case "5":				
				opc=5;				
				break;
			default:				
				opc=0;
				break;
		}
		return opc;
	}
	
	public void setOpcion(String teclado) throws SQLException {				
            int opc = cleanOpcion(teclado);
			switch (opc) {
			case 1:				
				this.opcion=1;
				break;
			case 2:				
				this.opcion=2;
				break;
			case 3:				
				this.opcion=3;
				break;
			case 4:				
				this.opcion=4;
				break;
			case 5:				
				this.opcion=5;			
				break;
			case 0:				
				this.opcion=0;
				break;
			}
	}

	public int getOpcion() {
		return opcion;
	}
	
	public void agregar() throws SQLException, ClassNotFoundException {
		System.out.print("Selecciono Agregar");
		AlumnoDao alumnoDao = new AlumnoDao();
		Alumno alumno = new Alumno(100000, "200 Rommel", "rommel@gmail.com", 25, 'M');
		alumnoDao.agregar(alumno);
	}
	
	public void listar() throws SQLException, ClassNotFoundException {
		System.out.print("Selecciono Listar");		
		AlumnoDao alumnoDao = new AlumnoDao();
		List <Alumno> listAlummnos = new ArrayList<>();
		listAlummnos =alumnoDao.listar();
		for(Alumno alumno: listAlummnos) {
			System.out.println(alumno);
		}

	}
	
	public void eliminar() throws SQLException, ClassNotFoundException {
		System.out.print("Selecciono Eliminar");
		AlumnoDao alumnoDao = new AlumnoDao();
		int id = 1;
		alumnoDao.eliminar(id);
	}
	
	public void actualizar() throws SQLException, ClassNotFoundException {
		System.out.print("Selecciono Actualizar");
		AlumnoDao alumnoDao = new AlumnoDao();
		Alumno alumno = new Alumno(2, "300 Rommel", "rommel@gmail.com", 25, 'M');
		alumnoDao.actualizar(alumno);
	}
	public void salir(){
		System.out.print("  Adios :) ");
	}
}
